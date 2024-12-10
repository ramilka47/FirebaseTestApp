package ru.ramil.firebasetestapp.data

import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class RegisterTokenFirebaseProvider : RegisterTokenProvider {

    override suspend fun register() =
        suspendCoroutine { continuation ->
            FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
                continuation.resume(
                    try {
                        val pushToken = task.result
                        Log.d("JCD", "push_token $pushToken")
                        pushToken
                    } catch (e: Throwable) {
                        Log.e("JCD", "", e)
                        null
                    }
                )
            }
        }
}