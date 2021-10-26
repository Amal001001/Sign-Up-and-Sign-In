package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Signin : AppCompatActivity() {
    lateinit var etMobile: EditText
    lateinit var etPassword: EditText
    lateinit var btnSin: Button
    lateinit var btnSup: Button
    lateinit var dbhr:DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        dbhr = DBHelper(applicationContext)

        etMobile =findViewById(R.id.etMobile)
        etPassword =findViewById(R.id.etPassword)

        btnSin = findViewById(R.id.btnSin)
        btnSin.setOnClickListener {
            if (etMobile.text.toString() != "" && etPassword.text.toString() != "") {
                val mobile = etMobile.text.toString()
                val password = etPassword.text.toString()
                val check = dbhr.signIn(mobile)

                if (check == password) {
                    val intent = Intent(this, Details::class.java)
                    intent.putExtra("mobile", mobile)
                    startActivity(intent)
                } else {
                    Toast.makeText(applicationContext, "Mobile number or Password is not correct", Toast.LENGTH_LONG).show()
                }
            }
        }

        btnSup = findViewById(R.id.btnSup)
        btnSup.setOnClickListener { val intent = Intent(this, Signup::class.java)
            startActivity(intent) }
    }
}
