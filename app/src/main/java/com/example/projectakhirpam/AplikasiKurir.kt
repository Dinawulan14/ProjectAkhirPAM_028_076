package com.example.projectakhirpam

import android.app.Application

class AplikasiKurir : Application() {
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}