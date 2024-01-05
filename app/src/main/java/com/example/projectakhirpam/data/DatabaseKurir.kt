package com.example.projectakhirpam.data

import android.content.Context
import androidx.room.Database

@Database(entities = [Kurir::class], version = 1, exportSchema = false)
abstract class DatabaseKurir : RoomDatabase(){
    abstract fun KurirDao() : KurirDao

    companion object {
        @Volatile
        private var Instance: DatabaseKurir? = null

        fun getDatabase(context: Context): DatabaseKurir {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    DatabaseKurir::class.java,
                    "Kurir_database"
                )
                    .build().also { Instance = it }
            })
        }
    }
}