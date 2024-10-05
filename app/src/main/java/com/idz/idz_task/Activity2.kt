package com.idz.idz_task

import android.database.Cursor
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.idz.idz_task.databinding.Activity2Binding
import com.idz.idz_task.db_helper.DatabaseHelper

class Activity2 : AppCompatActivity() {

    // Declare View Binding object
    private lateinit var binding: Activity2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using View Binding
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve data passed from MainActivity
        val name = intent.getStringExtra("name")
        val birthday = intent.getStringExtra("birthday")
        val email = intent.getStringExtra("email")

        // Set data to TextViews using the binding object
        binding.tvName.text = name
        binding.tvBirthday.text = birthday
        binding.tvEmail.text = email
    }
}
