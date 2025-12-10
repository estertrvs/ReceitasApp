package com.example.receitasapp.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


val Context.dataStore by preferencesDataStore(name = "settings")

class UserPreferences(private val context: Context) {

    companion object {
        val NOME_CHEF_KEY = stringPreferencesKey("nome_chef")
    }


    val nomeChef: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[NOME_CHEF_KEY] ?: "Visitante"
        }


    suspend fun salvarNome(nome: String) {
        context.dataStore.edit { preferences ->
            preferences[NOME_CHEF_KEY] = nome
        }
    }
}