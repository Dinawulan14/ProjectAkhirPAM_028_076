package com.example.projectakhirpam.navigasi

interface DestinasiNavigasi {
    //Nama unik untuk menentukan jalur untuk composable
    val route: String
    //String resource id yang berisi judul yang akan ditampilkan dilayar halaman
    val titleRes: Int
}