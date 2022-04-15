package com.example.yydemo

import android.Manifest
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ThirdActivity : AppCompatActivity() {
    var receiver3 = headsetReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)


        val btn_click_me = findViewById<Button>(R.id.btn_nxt3)
        btn_click_me.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val btn_bck2 = findViewById<Button>(R.id.btn_bck2)
        btn_bck2.setOnClickListener(){
            val intent1 = Intent(this,SecondActivity::class.java)
            startActivity(intent1)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle","onStart invoked")
        IntentFilter(Intent.ACTION_HEADSET_PLUG).also{
            registerReceiver(receiver3,it)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver3)
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle","onPause invoked")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle","onDestroy invoked")
    }
}