package ru.ramil.firebasetestapp.di

import android.app.Application
import dagger.Component
import ru.ramil.firebasetestapp.di.module.AppModule
import ru.ramil.firebasetestapp.di.module.ProviderModule
import ru.ramil.firebasetestapp.di.module.UseCaseModule
import ru.ramil.firebasetestapp.ui.screen.MainActivity
import ru.ramil.firebasetestapp.ui.service.FirebaseService

@Component(modules = [
    UseCaseModule::class,
    ProviderModule::class,
    AppModule::class
])
interface AppComponent {

    fun inject(firebaseService: FirebaseService)

    fun inject(application: Application)

    fun inject(mainActivity: MainActivity)
}