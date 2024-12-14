package ru.ramil.firebasetestapp.data

import android.content.SharedPreferences

class TokenProvider(private val preferences : SharedPreferences) : ITokenProvider {

    companion object{
        private const val TOKEN_KEY = "token"
    }

    override fun getToken(): Token? =
        preferences.getString(TOKEN_KEY, null)?.let { Token(it) }


    override fun setToken(token : Token) =
        preferences.edit().putString(TOKEN_KEY, token.value).apply()
}