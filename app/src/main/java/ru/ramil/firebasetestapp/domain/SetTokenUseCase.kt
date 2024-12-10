package ru.ramil.firebasetestapp.domain

import ru.ramil.firebasetestapp.data.ISetTokenProvider

class SetTokenUseCase(private val iSetTokenProvider: ISetTokenProvider) {

    suspend fun execute(token : String) =
        iSetTokenProvider.setToken(token)
}