package com.example.receitasapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.receitasapp.adapter.ReceitaAdapter
import com.example.receitasapp.data.ReceitaData
import com.example.receitasapp.databinding.FragmentListaBinding

class ListaFragment : Fragment() {
    private lateinit var binding: FragmentListaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListaBinding.inflate(inflater, container, false)

        val tipo = arguments?.getString("tipo") ?: "doce"
        val receitas = ReceitaData.getByTipo(tipo)

        binding.listViewReceitas.adapter = ReceitaAdapter(requireContext(), receitas)

        return binding.root
    }
}
