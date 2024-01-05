package com.example.projectakhirpam.data

import android.content.Context

@Database(entities = [Kasir::class], version = 1, exportSchema = false)
abstract class DatabaseKasir : RoomDatabase(){
    abstract fun KasirDao() : KasirDao

    companion object {
        @Volatile
        private var Instance: DatabaseKasir? = null

        fun getDatabase(context: Context): DatabaseKasir {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    DatabaseKasir::class.java,
                    "Kasir_database"
                )
                    .build().also { Instance = it }
            })
        }
    }
}
}