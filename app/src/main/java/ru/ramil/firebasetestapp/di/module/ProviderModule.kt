package ru.ramil.firebasetestapp.di.module

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import ru.ramil.firebasetestapp.data.IGetTokenProvider
import ru.ramil.firebasetestapp.data.ISetTokenProvider
import ru.ramil.firebasetestapp.data.RegisterTokenFirebaseProvider
import ru.ramil.firebasetestapp.data.RegisterTokenProvider
import ru.ramil.firebasetestapp.data.TokenProvider

@Module
class ProviderModule {

    @Provides
    fun provideTokenProvider(sharedPreferences: SharedPreferences) =
        TokenProvider(sharedPreferences)

    @Provides
    fun provideIGetTokenProvider(tokenProvider: TokenProvider) : IGetTokenProvider =
        tokenProvider

    @Provides
    fun provideISetTokenProvider(tokenProvider: TokenProvider) : ISetTokenProvider =
        tokenProvider

    @Provides
    fun provideRegisterTokenProvider() : RegisterTokenProvider =
        RegisterTokenFirebaseProvider()
}