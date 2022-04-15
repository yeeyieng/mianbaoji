package com.example.yydemo

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import org.w3c.dom.Text

class SecondActivity : AppCompatActivity() {
    var receiver1 = wifiReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btn_nxt2 = findViewById<Button>(R.id.btn_nxt2)
        btn_nxt2.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        val btn_bck1 = findViewById<Button>(R.id.btn_bck1)
        btn_bck1.setOnClickListener() {
            val intent1 = Intent(this, MainActivity::class.java)
            startActivity(intent1)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "onStart invoked")
        IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).also {
            registerReceiver(receiver1, it)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle","onResume invoked")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle","onStop invoked")
        unregisterReceiver(receiver1)
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