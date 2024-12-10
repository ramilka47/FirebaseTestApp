package ru.ramil.firebasetestapp.di.module

import dagger.Module
import dagger.Provides
import ru.ramil.firebasetestapp.domain.GetTokenUseCase
import ru.ramil.firebasetestapp.domain.RegisterTokenUseCase
import ru.ramil.firebasetestapp.domain.SetTokenUseCase
import ru.ramil.firebasetestapp.ui.view_model.ViewModelFactory

@Module
class ViewModelsModule {

    @Provides
    fun provideViewModelFactory(
        setTokenUseCase: SetTokenUseCase,
        getTokenUseCase: GetTokenUseCase,
        registerTokenUseCase: RegisterTokenUseCase
    ) = ViewModelFactory(
        registerTokenUseCase = registerTokenUseCase,
        setTokenUseCase = setTokenUseCase,
        getTokenUseCase = getTokenUseCase)
}