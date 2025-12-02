package com.example.receitasapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.receitasapp.data.ReceitaData
import com.example.receitasapp.databinding.FragmentDetalhesBinding

class DetalhesFragment : Fragment() {
    private lateinit var binding: FragmentDetalhesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalhesBinding.inflate(inflater, container, false)

        val id = arguments?.getInt("id") ?: 0
        val receita = ReceitaData.getById(id)

        binding.txtTitulo.text = receita.nome
        binding.txtIngredientes.text = receita.ingredientes.joinToString("\n")
        binding.txtPassosTitulo.text = "Modo de preparo:"
        binding.txtPassos.text = receita.passos.mapIndexed { i, p -> "${i + 1}. $p" }
            .joinToString("\n")

        return binding.root
    }
}
