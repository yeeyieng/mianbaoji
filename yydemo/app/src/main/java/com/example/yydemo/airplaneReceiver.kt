package com.example.yydemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast

class airplaneReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d("#######", "Receiver End")

        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.action)) {
            var isAirplaneModeOn = intent.getBooleanExtra("state", false)
            if (isAirplaneModeOn == false) {
                Toast.makeText(context, "Airplane mode is turned off", Toast.LENGTH_LONG).show()
            }
            if (isAirplaneModeOn == true) {
                Toast.makeText(context, "Airplane mode is turned on", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun isConnectedOrConnecting(context: Context): Boolean {
        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnectedOrConnecting
    }
}
