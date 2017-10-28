package com.hanakusoman.hola.services

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

/**
 * Created by taihe on 2017/10/28.
 */
class HoraFirebaseMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(p0: RemoteMessage?) {
        super.onMessageReceived(p0)
    }
}

class HoraFirebaseInstanceIDService : FirebaseInstanceIdService() {

    private val TAG = HoraFirebaseInstanceIDService::class.java.simpleName

    override fun onTokenRefresh() {
        val refreshToken = FirebaseInstanceId.getInstance().token
        Log.i(TAG, "token=" + refreshToken)
    }
}

