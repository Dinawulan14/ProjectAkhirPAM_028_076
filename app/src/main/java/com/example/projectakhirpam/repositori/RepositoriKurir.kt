package com.example.projectakhirpam.repositori

import com.example.projectakhirpam.data.Kurir
import kotlinx.coroutines.flow.Flow

interface RepositoriKurir {
    fun getAllKurirStream(): Flow<List<Kurir>>

    fun getKurirStream(id: Int): Flow<Kurir?>

    suspend fun insertKurir(kurir: Kurir)

    suspend fun deleteKurir(kurir: Kurir)

    suspend fun updateKurir(kurir: Kurir)
}