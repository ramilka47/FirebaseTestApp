package ru.ramil.firebasetestapp.ui.service

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import ru.ramil.firebasetestapp.ui.Application
import ru.ramil.firebasetestapp.ui.view_model.FirebaseViewModel
import javax.inject.Inject

class FirebaseService : FirebaseMessagingService() {

    @Inject
    lateinit var firebaseViewModel: FirebaseViewModel

    override fun onCreate() {
        super.onCreate()
        Application.appComponent.inject(this)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        firebaseViewModel.setToken(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
    }
}