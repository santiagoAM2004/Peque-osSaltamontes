package com.example.mispequeossaltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import com.example.mispequeossaltamontes.entities.Operations

class MainActivity : AppCompatActivity() {
    var operations: Operations?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startComponents()
    }
    private fun startComponents() {
        val btnRegistro:Button=findViewById(R.id.loginStudents)
        val btnStatistics:Button=findViewById(R.id.statistics)
        val btnHelp:Button=findViewById(R.id.help)

        btnRegistro.setOnClickListener { onClick(1) }
        btnHelp.setOnClickListener { onClick(2) }
        btnStatistics.setOnClickListener { onClick(3) }
    }

    private fun onClick(boton: Int) {
        when(boton){
            1->startActivity(Intent(this,LoginStudents::class.java))
            2->startActivity(Intent(this,HelpActivity::class.java))
            3-> startActivity(Intent(this,StatisticsActivity::class.java))
        }
    }


}