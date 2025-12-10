package com.example.receitasapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.receitasapp.data.AppDatabase
import com.example.receitasapp.data.Receita
import com.example.receitasapp.databinding.FragmentCadastroBinding

class CadastroFragment : Fragment() {

    private lateinit var binding: FragmentCadastroBinding
    private var receitaId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCadastroBinding.inflate(inflater, container, false)

        receitaId = arguments?.getInt("receitaId") ?: 0

        if (receitaId > 0) {
            carregarDadosReceita(receitaId)
        }

        binding.btnSalvar.setOnClickListener {
            salvarReceita()
        }

        return binding.root
    }

    private fun carregarDadosReceita(id: Int) {
        val db = AppDatabase.getDatabase(requireContext())

        Thread {
            val receita = db.receitaDao().getById(id)

            activity?.runOnUiThread {
                binding.apply {

                    btnSalvar.text = "Salvar Alterações"

                    editNome.setText(receita.nome)

                    editIngredientes.setText(receita.ingredientes.joinToString("\n"))
                    editPassos.setText(receita.passos.joinToString("\n"))

                    if (receita.tipo == "doce") {
                        rbDoce.isChecked = true
                    } else {
                        rbSalgado.isChecked = true
                    }
                }
            }
        }.start()
    }

    private fun salvarReceita() {
        val nome = binding.editNome.text.toString().trim()
        val ingredientesTexto = binding.editIngredientes.text.toString()
        val passosTexto = binding.editPassos.text.toString()
        val tipo = if (binding.rbDoce.isChecked) "doce" else "salgado"

        if (nome.isEmpty() || ingredientesTexto.isEmpty() || passosTexto.isEmpty()) {
            Toast.makeText(requireContext(), "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            return
        }

        val listaIngredientes = ingredientesTexto.split("\n").filter { it.isNotBlank() }
        val listaPassos = passosTexto.split("\n").filter { it.isNotBlank() }

        Thread {
            val db = AppDatabase.getDatabase(requireContext())

            val receitaComMesmoNome = db.receitaDao().getByNome(nome)

            var nomeDuplicado = false

            if (receitaId == 0) {
                if (receitaComMesmoNome != null) {
                    nomeDuplicado = true
                }
            } else {
                if (receitaComMesmoNome != null && receitaComMesmoNome.id != receitaId) {
                    nomeDuplicado = true
                }
            }

            if (nomeDuplicado) {
                activity?.runOnUiThread {
                    Toast.makeText(requireContext(), "Já existe uma receita com este nome!", Toast.LENGTH_LONG).show()
                    binding.editNome.requestFocus()
                    binding.editNome.selectAll()
                }
                return@Thread
            }

            if (receitaId == 0) {
                val novaReceita = Receita(
                    nome = nome,
                    tipo = tipo,
                    ingredientes = listaIngredientes,
                    passos = listaPassos,
                    nota = 0
                )
                db.receitaDao().insert(novaReceita)
            } else {
                val receitaAntiga = db.receitaDao().getById(receitaId)
                val receitaEditada = Receita(
                    id = receitaId,
                    nome = nome,
                    tipo = tipo,
                    ingredientes = listaIngredientes,
                    passos = listaPassos,
                    nota = receitaAntiga.nota
                )
                db.receitaDao().update(receitaEditada)
            }

            activity?.runOnUiThread {
                Toast.makeText(requireContext(), "Salvo com sucesso!", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            }
        }.start()
    }
}