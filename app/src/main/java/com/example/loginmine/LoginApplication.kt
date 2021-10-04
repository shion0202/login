package com.example.loginmine

import android.app.Application
import com.example.loginmine.repository.LoginRepository

class LoginApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        LoginRepository.initialize(this)
    }
}