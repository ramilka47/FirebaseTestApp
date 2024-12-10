package ru.ramil.firebasetestapp.data

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
                        pushToken
                    } catch (e: Throwable) {
                        null
                    }
                )
            }
        }
}