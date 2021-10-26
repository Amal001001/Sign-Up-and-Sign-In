package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Signup : AppCompatActivity() {
    lateinit var etName:EditText
    lateinit var etMobile:EditText
    lateinit var etLocation:EditText
    lateinit var etPassword:EditText
    lateinit var btnSin: Button
    lateinit var btnSup: Button
    lateinit var dbhr:DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        dbhr = DBHelper(applicationContext)

        etName = findViewById(R.id.etName)
        etMobile =findViewById(R.id.etMobile)
        etLocation =findViewById(R.id.etLocation)
        etPassword =findViewById(R.id.etPassword)

        btnSup = findViewById(R.id.btnSup)
        btnSup.setOnClickListener {
            if(etName.text.toString() != "" && etMobile.text.toString() != "" && etLocation.text.toString() != "" && etPassword.text.toString() != "") {
                val name = etName.text.toString()
                val mobile = etMobile.text.toString()
                val location = etLocation.text.toString()
                val password = etPassword.text.toString()
                dbhr.signUp(name, mobile, location, password)
                Toast.makeText(applicationContext, "Sign up successfully completed", Toast.LENGTH_LONG).show()

                val intent = Intent(this, Details::class.java)
                intent.putExtra("mobile", mobile)
                startActivity(intent)
            }
        }

        btnSin = findViewById(R.id.btnSin)
        btnSin.setOnClickListener { val intent = Intent(this, Signin::class.java)
            startActivity(intent) }
    }
}