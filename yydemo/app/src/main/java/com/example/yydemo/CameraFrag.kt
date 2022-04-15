package com.example.yydemo

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import java.util.jar.Manifest


class CameraFrag : Fragment() {
    val CAMERA_PERM_CODE = 101
    val CAMERA_REQUEST_CODE = 102
    lateinit var selectedImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(com.example.yydemo.R.layout.fragment_camera, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        selectedImage = view.findViewById(com.example.yydemo.R.id.imageView1)
        val btnPhoto = view.findViewById(com.example.yydemo.R.id.btn_take_photo) as Button
        btnPhoto.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "camera button clicked", Toast.LENGTH_SHORT).show()
                askCameraPermissions()
        })
    }

    fun askCameraPermissions() {
        if (context?.let {
                ContextCompat.checkSelfPermission(
                    it,
                    android.Manifest.permission.CAMERA
                )
            } != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(arrayOf(android.Manifest.permission.CAMERA), CAMERA_PERM_CODE)
        } else {
            openCamera()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == CAMERA_PERM_CODE) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera()
            } else {
                Toast.makeText(
                    context, "Camera Permission is required to use camera.", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun openCamera() {
        Toast.makeText(context, "Camera Enabled", Toast.LENGTH_SHORT).show()
        val camera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(camera, CAMERA_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERA_REQUEST_CODE) {
            val image = data?.extras?.get("data") as Bitmap
            if (image != null) {
                selectedImage.setImageBitmap(image)
            }

        }
    }
}