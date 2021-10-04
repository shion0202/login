package com.example.loginmine.repository

import android.content.Context
import com.example.loginmine.dao.LoginDao

class LoginRepository private constructor(context: Context){
    private val loginDao = LoginDao(context)
    fun login(email: String, password: String): String = loginDao.login(email, password)


    companion object {
        private var INSTANCE: LoginRepository? = null

        fun initialize(context:Context) {
            INSTANCE?:run { INSTANCE = LoginRepository(context) }
        }
        fun get(): LoginRepository {
            return INSTANCE ?: throw IllegalAccessException("UserRepository must be initialized")
        }
    }
}