package com.example.mispequeossaltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    private val time:Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)
        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },time)
    }
}