package com.example.signupandsignin

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context,"details.db",null,2) {
    var sqLiteDatabase : SQLiteDatabase = writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL("create table users (Name text,Mobile text,Location text,Password text)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun signUp(name:String,mobile:String,location:String,password:String) {
        val cv = ContentValues()
        cv.put("Name",name)
        cv.put("Mobile",mobile)
        cv.put("Location",location)
        cv.put("Password",password)
        sqLiteDatabase.insert("users",null,cv)
    }

    @SuppressLint("Range", "Recycle")
    fun signIn(mobile: String): String {
        val cursor: Cursor =
            sqLiteDatabase.query("users", null, "Mobile=?", arrayOf(mobile), null, null, null)
        if (cursor.count < 1) return "signIn error"

        cursor.moveToFirst()
        return cursor.getString(cursor.getColumnIndex("Password"))
    }

    @SuppressLint("Range", "Recycle")
    fun userDetails(mobile:String): ArrayList<String> {
        val cursor:Cursor = sqLiteDatabase.query("users",null,"Mobile=?", arrayOf(mobile),null,null,null)
        cursor.moveToFirst()
        val loc = cursor.getString(cursor.getColumnIndex("Location"))
        val nam = cursor.getString(cursor.getColumnIndex("Name"))
        val userInfo = arrayListOf<String>(nam,loc)
        return userInfo
    }

}