package com.example.signupandsignin

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Details : AppCompatActivity() {
    lateinit var tvWelcome: TextView
    lateinit var tvDetails: TextView
    lateinit var btnSout:Button
    lateinit var dbhr:DBHelper

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        dbhr = DBHelper(applicationContext)

        tvWelcome = findViewById(R.id.tvWelcome)
        tvDetails = findViewById(R.id.tvDetails)

        var mobile = intent.extras?.getString("mobile")!!
        tvWelcome.text = "Welcome "+mobile

        var info = dbhr.userDetails(mobile)

        tvDetails.text = "Your details are,\nName: ${info[0]}\nLocation: ${info[1]}"

        btnSout = findViewById(R.id.btnSout)
        btnSout.setOnClickListener { val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) }

    }
}