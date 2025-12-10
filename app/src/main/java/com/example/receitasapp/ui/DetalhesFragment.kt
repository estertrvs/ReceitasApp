package com.example.receitasapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import androidx.fragment.app.Fragment
import com.example.receitasapp.data.AppDatabase
import com.example.receitasapp.databinding.FragmentDetalhesBinding

class DetalhesFragment : Fragment() {
    private lateinit var binding: FragmentDetalhesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalhesBinding.inflate(inflater, container, false)

        val id = arguments?.getInt("id") ?: 0


        val db = AppDatabase.getDatabase(requireContext())
        val receita = db.receitaDao().getById(id)


        binding.txtTitulo.text = receita.nome
        binding.txtIngredientes.text = receita.ingredientes.joinToString("\n")
        binding.txtPassosTitulo.text = "Modo de preparo:"
        binding.txtPassos.text = receita.passos.mapIndexed { i, p -> "${i + 1}. $p" }
            .joinToString("\n")


        binding.ratingBar.rating = receita.nota.toFloat()

        binding.ratingBar.setOnRatingBarChangeListener { _, rating, fromUser ->
            if (fromUser) {

                receita.nota = rating.toInt()
                db.receitaDao().update(receita)


                Snackbar.make(
                    binding.root,
                    "Avaliação salva com sucesso!",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }

        return binding.root
    }
}