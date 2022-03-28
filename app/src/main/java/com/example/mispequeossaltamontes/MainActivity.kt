package com.example.mispequeossaltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStudents: Button = findViewById(R.id.loginStudents)
        btnStudents.setOnClickListener {
            val intent: Intent = Intent(this, LoginStudents::class.java)
            startActivity(intent)
        }
    }
}