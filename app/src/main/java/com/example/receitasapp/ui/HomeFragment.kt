package com.example.receitasapp.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.receitasapp.R
import com.example.receitasapp.data.UserPreferences
import com.example.receitasapp.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private lateinit var userPreferences: UserPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        userPreferences = UserPreferences(requireContext())



        lifecycleScope.launch {
            userPreferences.nomeChef.collect { nome ->

                binding.txtBoasVindas.text = "Olá, Chef $nome!"
            }
        }


        binding.btnMudarNome.setOnClickListener {
            mostrarDialogoParaDigitarNome()
        }


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


    private fun mostrarDialogoParaDigitarNome() {
        val input = EditText(requireContext())
        input.hint = "Digite seu nome aqui"

        AlertDialog.Builder(requireContext())
            .setTitle("Configuração de Perfil")
            .setMessage("Como você gostaria de ser chamado?")
            .setView(input)
            .setPositiveButton("Salvar") { _, _ ->
                val novoNome = input.text.toString()
                if (novoNome.isNotEmpty()) {

                    lifecycleScope.launch {
                        userPreferences.salvarNome(novoNome)
                        Toast.makeText(context, "Nome atualizado!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
}