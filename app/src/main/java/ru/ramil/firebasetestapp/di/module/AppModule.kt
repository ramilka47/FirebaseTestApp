package ru.ramil.firebasetestapp.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context : Application) {

    companion object{
        private const val SHARED_PUBLIC = "shared_Ramil_app"
    }

    @Provides
    fun provideContext() : Context = context

    @Provides
    fun provideSharedPreferences(context: Context) =
        context.getSharedPreferences(SHARED_PUBLIC, Context.MODE_PRIVATE)
}