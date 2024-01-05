package com.example.projectakhirpam.repositori

import com.example.projectakhirpam.data.Kurir
import com.example.projectakhirpam.data.KurirDao
import com.example.rootsiswa.repositori.RepositoriKurir
import kotlinx.coroutines.flow.Flow

class OfflineRepositoriKurir(private val kurirDao: KurirDao) : RepositoriKurir {

    override fun getAllSiswaStream(): Flow<List<Kurir>> = kurirDao.getAllSiswa()

    override fun getSiswaStream(id: Int): Flow<Kurir?> {
        return kurirDao.getSiswa(id)
    }

    override suspend fun insertSiswa(siswa: Kurir) = kurirDao.insert(siswa)

    override suspend fun deleteSiswa(siswa: Kurir) = kurirDao.delete(siswa)

    override suspend fun updateSiswa(siswa: Kurir) {
        kurirDao.update(siswa)
    }
}