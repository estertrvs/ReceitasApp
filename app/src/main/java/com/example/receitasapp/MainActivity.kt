package com.example.receitasapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.receitasapp.data.AppDatabase
import com.example.receitasapp.data.ReceitaData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navHost = supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        setupActionBarWithNavController(navHost.navController)


        val db = AppDatabase.getDatabase(this)


        if (db.receitaDao().getAll().isEmpty()) {

            db.receitaDao().insertAll(ReceitaData.receitas)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navHost = supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        return navHost.navController.navigateUp()
    }
}