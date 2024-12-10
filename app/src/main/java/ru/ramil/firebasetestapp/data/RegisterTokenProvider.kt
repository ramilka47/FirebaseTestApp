package ru.ramil.firebasetestapp.data

interface RegisterTokenProvider {

    suspend fun register() : String?
}