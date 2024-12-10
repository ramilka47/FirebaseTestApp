package ru.ramil.firebasetestapp.data

import android.content.SharedPreferences

class TokenProvider(private val preferences : SharedPreferences) : ITokenProvider {

    companion object{
        private const val TOKEN_KEY = "token"
    }

    override fun getToken(): String? =
        preferences.getString(TOKEN_KEY, null)


    override fun setToken(token : String) =
        preferences.edit().putString(TOKEN_KEY, token).apply()
}