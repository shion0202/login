package com.example.loginmine.dao

import android.content.Context
import android.util.Log
import com.example.loginmine.utils.CoroutinesAsyncTask
import com.nhn.android.naverlogin.OAuthLogin

class NaverAsyncTask(private var context: Context,
                     private val mOAuthLoginModule: OAuthLogin,
                     private val accessToken: String,
                     private val callback: (result: String) -> Unit): CoroutinesAsyncTask<Int, Int, String>("Login using Naver") {
    override fun doInBackground(vararg params: Int?): String {
        val apiURL = "https://openapi.naver.com/v1/nid/me"
        return mOAuthLoginModule.requestApi(context, accessToken, apiURL)
    }

    override fun onPostExecute(result: String?) {
        callback(result ?: "error..")
        Log.d("tag", result ?: "Null...")
    }
}