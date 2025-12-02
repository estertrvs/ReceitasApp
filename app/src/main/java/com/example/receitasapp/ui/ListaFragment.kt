package com.example.receitasapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.SearchView
import com.example.receitasapp.adapter.ReceitaAdapter
import com.example.receitasapp.data.Receita
import com.example.receitasapp.data.ReceitaData
import com.example.receitasapp.databinding.FragmentListaBinding

class ListaFragment : Fragment() {
    private lateinit var binding: FragmentListaBinding
    private lateinit var adapter: ReceitaAdapter
    private lateinit var todasReceitas: List<Receita>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListaBinding.inflate(inflater, container, false)

        val tipo = arguments?.getString("tipo") ?: "doce"
        todasReceitas = ReceitaData.getByTipo(tipo)

        adapter = ReceitaAdapter(requireContext(), todasReceitas.toMutableList())
        binding.listViewReceitas.adapter = adapter

        setupSearch()

        return binding.root
    }

    private fun setupSearch() {
        val searchView = binding.searchViewReceitas
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val q = newText?.trim() ?: ""
                if (q.isEmpty()) {
                    adapter.updateData(todasReceitas)
                } else {
                    val filtradas = todasReceitas.filter {
                        it.nome.contains(q, ignoreCase = true)
                    }
                    adapter.updateData(filtradas)
                }
                return true
            }
        })
    }
}
