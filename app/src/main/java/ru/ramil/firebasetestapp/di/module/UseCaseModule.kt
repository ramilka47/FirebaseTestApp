package ru.ramil.firebasetestapp.di.module

import dagger.Module
import dagger.Provides
import ru.ramil.firebasetestapp.data.IGetTokenProvider
import ru.ramil.firebasetestapp.data.ISetTokenProvider
import ru.ramil.firebasetestapp.domain.GetTokenUseCase
import ru.ramil.firebasetestapp.domain.SetTokenUseCase

@Module
class UseCaseModule {

    @Provides
    fun provideGetTokenUseCase(iGetTokenProvider: IGetTokenProvider) =
        GetTokenUseCase(iGetTokenProvider)

    @Provides
    fun provideSetTokenUseCase(iSetTokenProvider: ISetTokenProvider) =
        SetTokenUseCase(iSetTokenProvider)
}