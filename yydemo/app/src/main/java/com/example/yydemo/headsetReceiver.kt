package com.example.yydemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast

class headsetReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d("#######", "Receiver End")

        if (Intent.ACTION_HEADSET_PLUG.equals(intent.action)){
            var state = intent.getIntExtra("state",-1)
            if (state == 0){
                val headsetPluggedIn = false
                Toast.makeText(context, "Headset not plugged in", Toast.LENGTH_LONG).show()
            }
            if (state == 1){
                val headsetPluggedIn = true
                Toast.makeText(context, "Headset plugged in", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun isConnectedOrConnecting(context: Context): Boolean {
        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnectedOrConnecting
    }
}