package ru.ramil.firebasetestapp.domain

import ru.ramil.firebasetestapp.data.IGetTokenProvider

class GetTokenUseCase(private val iGetTokenProvider: IGetTokenProvider) {

    suspend fun execute() =
        iGetTokenProvider.getToken()?.value
}