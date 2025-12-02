package com.example.receitasapp.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import com.example.receitasapp.R
import com.example.receitasapp.data.Receita

class ReceitaAdapter(
    private val ctx: Context,
    private val lista: List<Receita>
) : BaseAdapter() {

    override fun getCount() = lista.size

    override fun getItem(position: Int) = lista[position]

    override fun getItemId(position: Int) = lista[position].id.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(ctx)
            .inflate(R.layout.item_receita, parent, false)

        val nome = view.findViewById<TextView>(R.id.txtNome)
        val botao = view.findViewById<ImageView>(R.id.btnVer)

        val receita = lista[position]
        nome.text = receita.nome

        botao.setOnClickListener {
            (ctx as? Activity)?.let { activity ->
                val navController = Navigation.findNavController(activity, R.id.navHost)
                val bundle = android.os.Bundle().apply {
                    putInt("id", receita.id)
                }
                navController.navigate(R.id.detalhesFragment, bundle)
            }
        }

        return view
    }
}
