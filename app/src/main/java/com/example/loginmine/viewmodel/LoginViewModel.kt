package com.example.loginmine.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loginmine.UserInfo
import com.example.loginmine.datatype.User
import com.example.loginmine.repository.LoginRepository
import org.json.JSONObject

class LoginViewModel : ViewModel() {
    val btnSelected = MutableLiveData(true)
    val isLogin = MutableLiveData(false)
    private val loginRepository = LoginRepository.get()


    fun onLogin(user: User) {
        Log.d("tag", user.toString())
        if (checkValidate(user.email, user.password)) {
            val nickname = loginRepository.login(user.email, user.password)
            if (nickname.isNotEmpty()) {
                UserInfo.isLogin = true
                UserInfo.userName = nickname
                isLogin.value = true// thread 사용시 바꿔야함
            }
        }
    }

    private fun checkValidate(email: String, password: String): Boolean = true
    fun callback(result: String) {
        val jsonObject = JSONObject(result)
        val responseObject = JSONObject(jsonObject.getString("response"))
        val nickname = responseObject.getString("name")
        UserInfo.userName = nickname
        UserInfo.isLogin = true
        isLogin.value = true
    }

}