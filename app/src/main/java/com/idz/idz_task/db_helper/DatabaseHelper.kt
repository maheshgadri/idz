package com.idz.idz_task.db_helper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "UserData.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE User(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, birthday TEXT, email TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS User")
        onCreate(db)
    }

    fun insertData(name: String, birthday: String, email: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("name", name)
        contentValues.put("birthday", birthday)
        contentValues.put("email", email)
        val result = db.insert("User", null, contentValues)
        return result != -1L
    }

    // Method to retrieve user data
    fun getUserData(): Cursor {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM User", null)
    }
}
