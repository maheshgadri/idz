package com.idz.idz_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.idz.idz_task.databinding.ActivityMainBinding



import android.content.Intent

import android.widget.Toast
import com.idz.idz_task.db_helper.DatabaseHelper


class MainActivity : AppCompatActivity() {

    // Declare View Binding object
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Access views using binding object
        binding.btnSubmit.setOnClickListener {
            val name = binding.etName.text.toString()
            val day = binding.etDay.text.toString()
            val year = binding.etYear.text.toString()
            val month = binding.etMonth.text.toString()
            val email = binding.etEmail.text.toString()

            // Check if all fields are filled
            if (name.isNotEmpty() && day.isNotEmpty() && year.isNotEmpty() && email.isNotEmpty()) {
                // Moved the birthday variable outside of if-block
                val birthday = "$month $day $year"

                // Insert the data into the database
                val dbHelper = DatabaseHelper(this)
                val isInserted = dbHelper.insertData(name, birthday, email)

                if (isInserted) {
                    // Go to Activity2
                    val intent = Intent(this, Activity2::class.java)
                    intent.putExtra("name", name)
                    intent.putExtra("birthday", birthday)
                    intent.putExtra("email", email)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Error saving data", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
