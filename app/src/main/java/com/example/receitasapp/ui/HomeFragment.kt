package com.example.receitasapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.receitasapp.R
import com.example.receitasapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnDoces.setOnClickListener {
            findNavController().navigate(
                R.id.listaFragment,
                Bundle().apply { putString("tipo", "doce") }
            )
        }

        binding.btnSalgadas.setOnClickListener {
            findNavController().navigate(
                R.id.listaFragment,
                Bundle().apply { putString("tipo", "salgado") }
            )
        }

        return binding.root
    }
}
