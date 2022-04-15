package com.example.yydemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast


class wifiReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.d("#######", "Receiver End")

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.action)) {
            var isWifiOn = isConnectedOrConnecting(context)
            if (isWifiOn == false) {
                Toast.makeText(context, "WIFI is turned off", Toast.LENGTH_LONG).show()
            }
            if (isWifiOn == true) {
                Toast.makeText(context, "WIFI is turned on", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun isConnectedOrConnecting(context: Context): Boolean {
        val connMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnectedOrConnecting
    }
}

//        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.action)){
//            var isAirplaneModeOn = intent.getBooleanExtra("state",false)
//            if (isAirplaneModeOn == false){
//                Toast.makeText(context, "Airplane mode is turned off", Toast.LENGTH_LONG).show()
//            }
//            if (isAirplaneModeOn == true){
//                Toast.makeText(context, "Airplane mode is turned on", Toast.LENGTH_LONG).show()
//            }
//        }

//        if (Intent.ACTION_HEADSET_PLUG.equals(intent.action)){
//            var state = intent.getIntExtra("state",-1)
//            if (state == 0){
//                val headsetPluggedIn = false
//                Toast.makeText(context, "Headset not plugged in", Toast.LENGTH_LONG).show()
//            }
//            if (state == 1){
//                val headsetPluggedIn = true
//                Toast.makeText(context, "Headset plugged in", Toast.LENGTH_LONG).show()
//            }




