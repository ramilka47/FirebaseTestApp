package ru.ramil.firebasetestapp.domain

import ru.ramil.firebasetestapp.data.IGetTokenProvider
import ru.ramil.firebasetestapp.data.ISetTokenProvider
import ru.ramil.firebasetestapp.data.RegisterTokenProvider

class RegisterTokenUseCase(
    private val iGetTokenProvider: IGetTokenProvider,
    private val iSetTokenProvider: ISetTokenProvider,
    private val registerTokenProvider: RegisterTokenProvider) {

    suspend fun execute(){
        if (iGetTokenProvider.getToken() == null)
            registerTokenProvider.register()?.let {
                iSetTokenProvider.setToken(it)
            }
    }
}