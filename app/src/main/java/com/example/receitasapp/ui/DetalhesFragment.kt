package com.example.receitasapp.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.receitasapp.R
import com.example.receitasapp.data.AppDatabase
import com.example.receitasapp.databinding.FragmentDetalhesBinding

class DetalhesFragment : Fragment() {
    private lateinit var binding: FragmentDetalhesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalhesBinding.inflate(inflater, container, false)

        val idReceitaAtual = arguments?.getInt("id") ?: 0

        val db = AppDatabase.getDatabase(requireContext())

        Thread {
            val receita = db.receitaDao().getById(idReceitaAtual)

            activity?.runOnUiThread {
                binding.txtTitulo.text = receita.nome
                binding.txtIngredientes.text = receita.ingredientes.joinToString("\n")
                binding.txtPassosTitulo.text = "Modo de preparo:"

                binding.txtPassos.text = receita.passos.mapIndexed { i, p -> "${i + 1}. $p" }
                    .joinToString("\n")

                binding.ratingBar.rating = receita.nota.toFloat()

                binding.ratingBar.setOnRatingBarChangeListener { _, rating, fromUser ->
                    if (fromUser) {
                        Thread {
                            receita.nota = rating.toInt()
                            db.receitaDao().update(receita)

                            activity?.runOnUiThread {
                                Snackbar.make(
                                    binding.root,
                                    "Avaliação salva com sucesso!",
                                    Snackbar.LENGTH_SHORT
                                ).show()
                            }
                        }.start()
                    }
                }
            }
        }.start()

        binding.btnEditar.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("receitaId", idReceitaAtual)

            findNavController().navigate(R.id.cadastroFragment, bundle)
        }

        binding.btnExcluir.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Excluir Receita")
                .setMessage("Tem certeza que deseja excluir esta receita? Essa ação não pode ser desfeita.")
                .setPositiveButton("Sim, excluir") { _, _ ->
                    excluirReceita(idReceitaAtual)
                }
                .setNegativeButton("Cancelar", null) // Não faz nada, só fecha o modal
                .show()
        }

        return binding.root
    }

    private fun excluirReceita(id: Int) {
        val db = AppDatabase.getDatabase(requireContext())

        Thread {
            val receitaParaDeletar = db.receitaDao().getById(id)

            db.receitaDao().delete(receitaParaDeletar)

            activity?.runOnUiThread {
                Toast.makeText(requireContext(), "Receita excluída com sucesso!", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            }
        }.start()
    }
}