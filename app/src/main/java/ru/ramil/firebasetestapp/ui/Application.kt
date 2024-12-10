package ru.ramil.firebasetestapp.ui

import android.app.Application
import ru.ramil.firebasetestapp.di.AppComponent
import ru.ramil.firebasetestapp.di.DaggerAppComponent
import ru.ramil.firebasetestapp.di.module.AppModule

class Application : Application(){

    companion object{
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}