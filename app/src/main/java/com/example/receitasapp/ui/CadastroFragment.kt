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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCadastroBinding.inflate(inflater, container, false)

        binding.btnSalvar.setOnClickListener {
            salvarReceita()
        }

        return binding.root
    }

    private fun salvarReceita() {
        val nome = binding.editNome.text.toString()
        val ingredientesTexto = binding.editIngredientes.text.toString()
        val passosTexto = binding.editPassos.text.toString()

        val tipo = if (binding.rbDoce.isChecked) "doce" else "salgado"

        if (nome.isEmpty() || ingredientesTexto.isEmpty() || passosTexto.isEmpty()) {
            Toast.makeText(requireContext(), "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            return
        }

        val listaIngredientes = ingredientesTexto.split("\n").filter { it.isNotBlank() }
        val listaPassos = passosTexto.split("\n").filter { it.isNotBlank() }

        val novaReceita = Receita(
            nome = nome,
            tipo = tipo,
            ingredientes = listaIngredientes,
            passos = listaPassos,
            nota = 0
        )

        val db = AppDatabase.getDatabase(requireContext())
        db.receitaDao().insert(novaReceita)

        Toast.makeText(requireContext(), "Receita cadastrada com sucesso!", Toast.LENGTH_SHORT).show()

        findNavController().popBackStack()
    }
}