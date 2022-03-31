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
        operations= Operations()
        startComponents()
    }
    private val response=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ valor ->
        if (valor.resultCode== RESULT_OK){
            //resp y resp 2 almacenan el mismo dato, solo se muestran 2 formas como podria capturarse el dato
            val resp=valor?.data?.extras?.get("resultado") as String
            val resp2=valor?.data?.getStringExtra("resultado")
            println("Valor respuesta=$resp y la resps2=$resp2")
            //capturamos el objeto nuevo y lo asignamos a operaciones
            operations= valor?.data?.extras?.get("objetoOperaciones") as Operations?
            operations?.printListOfStudents()
        }
    }
    private fun startComponents() {
        val btnRegistro:Button=findViewById(R.id.logUp)
        val btnStatistics:Button=findViewById(R.id.statistics)
        val btnHelp:Button=findViewById(R.id.help)

        btnRegistro.setOnClickListener { onClick(1) }
        btnHelp.setOnClickListener { onClick(2) }
        btnStatistics.setOnClickListener { onClick(3) }
    }

    private fun onClick(boton: Int) {
        when(boton){
            1->{
                var miIntent:Intent= Intent(this,LoginStudents::class.java)
                var miBundle:Bundle= Bundle()
                miBundle.putSerializable("operaciones",operations)
                miIntent.putExtras(miBundle)
                miIntent.putExtra("Objeto",operations)
                // startActivity(miIntent)
                response.launch(miIntent)
            }
            2->startActivity(Intent(this,HelpActivity::class.java))
            3-> startActivity(Intent(this,StatisticsActivity::class.java))
        }
    }

}