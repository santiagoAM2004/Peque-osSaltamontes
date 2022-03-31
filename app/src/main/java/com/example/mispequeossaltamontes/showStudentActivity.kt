package com.example.mispequeossaltamontes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.mispequeossaltamontes.entities.Operations

class showStudentActivity : AppCompatActivity() {

    var nameEs: TextView? = null

    var materiaEs1:TextView? = null
    var materiaEs2:TextView? = null
    var materiaEs3:TextView? = null
    var materiaEs4:TextView? = null
    var materiaEs5:TextView? = null

    var nota1Es:TextView? = null
    var nota2Es:TextView? = null
    var nota3Es:TextView? = null
    var nota4Es:TextView? = null
    var nota5Es:TextView? = null

    var averageEs:TextView? = null
    var winOrDefeat:TextView? = null

    var operations: Operations?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_student)
        getDataStudents()
    }

    private fun getDataStudents() {
        operations = Operations()

        nameEs = findViewById(R.id.name)

        materiaEs1 = findViewById(R.id.Materia1)
        materiaEs2 = findViewById(R.id.Materia2)
        materiaEs3 = findViewById(R.id.Materia3)
        materiaEs4 = findViewById(R.id.Materia4)
        materiaEs5 = findViewById(R.id.Materia5)

        nota1Es = findViewById(R.id.Note1)
        nota2Es = findViewById(R.id.Note2)
        nota3Es = findViewById(R.id.Note3)
        nota4Es = findViewById(R.id.Note4)
        nota5Es = findViewById(R.id.Note5)

        averageEs = findViewById(R.id.average)
        winOrDefeat = findViewById(R.id.winOrDefeat)

        sendDatas()
    }

    private fun sendDatas() {
        var bundleVerDatos: Bundle? = this.intent.extras

        if (bundleVerDatos != null) {
            nameEs!!.text = "${bundleVerDatos.getString("name")}"

            materiaEs1!!.text = "${bundleVerDatos.getString("course1")}"
            materiaEs2!!.text = "${bundleVerDatos.getString("course2")}"
            materiaEs3!!.text = "${bundleVerDatos.getString("course3")}"
            materiaEs4!!.text = "${bundleVerDatos.getString("course4")}"
            materiaEs5!!.text = "${bundleVerDatos.getString("course5")}"

            nota1Es!!.text = "${bundleVerDatos.getDouble("note1")}"
            nota2Es!!.text = "${bundleVerDatos.getDouble("note2")}"
            nota3Es!!.text = "${bundleVerDatos.getDouble("note3")}"
            nota4Es!!.text = "${bundleVerDatos.getDouble("note4")}"
            nota5Es!!.text = "${bundleVerDatos.getDouble("note5")}"

            averageEs!!.text = "${bundleVerDatos.getDouble("average")}"
            winOrDefeat!!.text = "${bundleVerDatos.getString("state")}"
        }
    }
}