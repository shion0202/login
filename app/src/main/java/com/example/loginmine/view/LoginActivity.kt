package com.example.loginmine.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.loginmine.R
import com.example.loginmine.UserInfo
import com.example.loginmine.databinding.ActivityLoginBinding
import com.example.loginmine.datatype.User
import com.example.loginmine.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    lateinit var loginBinding: ActivityLoginBinding
    private val user = User()
    private val loginViewmodel: LoginViewModel by lazy {
        ViewModelProvider(this as ViewModelStoreOwner).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        loginBinding.viewmodel = loginViewmodel
        loginBinding.user = user
        initObservers()
    }
    private fun initObservers() {
        loginViewmodel.isLogin.observe(this, Observer {
            if(it) {
                Toast.makeText(this, "welcome, ${UserInfo.userName}", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        })
    }
}