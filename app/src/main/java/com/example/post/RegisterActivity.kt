package com.example.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val token = intent.getStringExtra("TOKEN")
        val tokenEditText = findViewById<EditText>(R.id.token)
        tokenEditText.setText(token)

        val created = intent.getStringExtra("CreatedAt")
        val createdEditText = findViewById<EditText>(R.id.createdAt)
        createdEditText.setText(created)



    }
}