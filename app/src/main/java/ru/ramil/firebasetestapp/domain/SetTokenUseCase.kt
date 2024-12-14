package ru.ramil.firebasetestapp.domain

import ru.ramil.firebasetestapp.data.ISetTokenProvider
import ru.ramil.firebasetestapp.data.Token

class SetTokenUseCase(private val iSetTokenProvider: ISetTokenProvider) {

    suspend fun execute(token : String) =
        iSetTokenProvider.setToken(Token(token))
}