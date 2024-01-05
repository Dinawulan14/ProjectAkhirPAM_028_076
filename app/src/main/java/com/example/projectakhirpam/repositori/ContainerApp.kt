package com.example.projectakhirpam.repositori

import android.content.Context
import com.example.projectakhirpam.data.DatabaseKurir

interface ContainerApp {
    val repositoriKurir : RepositoriKurir
}

class ContainerDataApp(private val context: Context): ContainerApp {
    override val repositoriSiswa: RepositoriKurir by lazy {
        OfflineRepositoriKurir(DatabaseKurir.getDatabase(context).kurirDao())
    }
}