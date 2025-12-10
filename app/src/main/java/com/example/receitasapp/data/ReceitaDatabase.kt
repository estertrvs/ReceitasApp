package com.example.receitasapp.data

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.Update


@Dao
interface ReceitaDao {


    @Query("SELECT * FROM tabela_receitas WHERE tipo = :tipo")
    fun getByTipo(tipo: String): List<Receita>


    @Query("SELECT * FROM tabela_receitas WHERE id = :id")
    fun getById(id: Int): Receita


    @Query("SELECT * FROM tabela_receitas")
    fun getAll(): List<Receita>

    @Query("SELECT * FROM tabela_receitas WHERE nome = :nome LIMIT 1")
    fun getByNome(nome: String): Receita?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(receitas: List<Receita>)

    @Insert
    fun insert(receita: Receita)

    @Update
    fun update(receita: Receita)
}


@Database(entities = [Receita::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun receitaDao(): ReceitaDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "receitas_db"
                )
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}