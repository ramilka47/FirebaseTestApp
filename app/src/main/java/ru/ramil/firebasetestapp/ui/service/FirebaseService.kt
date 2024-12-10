package ru.ramil.firebasetestapp.ui.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import ru.ramil.firebasetestapp.R
import ru.ramil.firebasetestapp.ui.Application
import ru.ramil.firebasetestapp.ui.screen.MainActivity
import ru.ramil.firebasetestapp.ui.view_model.FirebaseViewModel
import ru.ramil.firebasetestapp.ui.view_model.MainViewModel
import ru.ramil.firebasetestapp.ui.view_model.ViewModelFactory
import javax.inject.Inject

class FirebaseService : FirebaseMessagingService() {

    companion object{
        private const val DEFAULT_CHANNEL_ID = "default"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val firebaseViewModel by lazy{
        viewModelFactory.create(FirebaseViewModel::class.java)
    }

    override fun onCreate() {
        super.onCreate()
        Application.appComponent.inject(this)

        firebaseViewModel.onCreate()
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        firebaseViewModel.setToken(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        val id = message.messageId

        val title = message.notification?.title ?: message.data["t"] ?: ""
        val message = message.notification?.body ?: message.data["m"] ?: ""

        val intent = Intent(applicationContext, MainActivity::class.java).apply {
            flags = flags and Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
        }

        val pendingIntent = PendingIntent.getActivity(
            applicationContext,
            0,
            intent.apply {
                putExtra("t", title)
                putExtra("m", message)
                putExtra("id", id)
            },
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE
            } else
                PendingIntent.FLAG_UPDATE_CURRENT
        )

        val notification = NotificationCompat.Builder(applicationContext, DEFAULT_CHANNEL_ID)
            .setSmallIcon(R.drawable.gcm_icon2)
            .setContentTitle(title)
            .setContentText(message)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        val notificationManager =
            getSystemService(NOTIFICATION_SERVICE) as? NotificationManager ?: return
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                DEFAULT_CHANNEL_ID,
                getString(R.string.fcm_messages_default_channel_name),
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                    setShowBadge(true)
            }
            notificationManager.createNotificationChannel(channel)
        }
        notificationManager.notify(1, notification)
    }
}