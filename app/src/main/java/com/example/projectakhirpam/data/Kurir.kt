package com.example.projectakhirpam.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblSiswa")
data class Kurir(
    @PrimaryKey(autoGenerate = true)
    val nama: String,
    val alamat: String,
    val telepon: String,
    val beratbarang: String,
    val statuspengiriman: String,
    val namakurir: String
)
