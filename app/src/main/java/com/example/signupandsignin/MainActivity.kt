package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnSin:Button
    lateinit var btnSup:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSin = findViewById(R.id.btnSin)
        btnSin.setOnClickListener { val intent = Intent(this, Signin::class.java)
            startActivity(intent) }


        btnSup = findViewById(R.id.btnSup)
        btnSup.setOnClickListener { val intent = Intent(this, Signup::class.java)
            startActivity(intent) }
    }
}