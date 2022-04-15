package com.example.yydemo

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var receiver2 = airplaneReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Lifecycle","onCreate invoked")

    val btn_click_me = findViewById<Button>(R.id.btn_nxt1)
    btn_click_me.setOnClickListener{
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle","onStart invoked")
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also{
            registerReceiver(receiver2,it)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver2)
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