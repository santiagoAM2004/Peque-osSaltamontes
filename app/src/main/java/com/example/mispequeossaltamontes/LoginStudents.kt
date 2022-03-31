package com.example.mispequeossaltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.mispequeossaltamontes.entities.Operations
import com.example.mispequeossaltamontes.entities.Students

class LoginStudents : AppCompatActivity() {
    var fieldID: EditText?=null
    var fieldName:EditText?=null
    var fieldAge:EditText?=null
    var fieldAddress:EditText?=null
    var fieldPhone:EditText?=null

    var fieldMateria1:EditText?=null
    var fieldMateria2:EditText?=null
    var fieldMateria3:EditText?=null
    var fieldMateria4:EditText?=null
    var fieldMateria5:EditText?=null
    var fieldNote1:EditText?=null
    var fieldNote2:EditText?=null
    var fieldNote3:EditText?=null
    var fieldNote4:EditText?=null
    var fieldNote5:EditText?=null

    var operations:Operations?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_students)
        startComponents()
    }
    private fun startComponents() {
        //Se instancia la clase operaciones
        operations= Operations()

        fieldID=findViewById(R.id.fieldID)
        fieldName=findViewById(R.id.fieldName)
        fieldAge=findViewById(R.id.fieldAge)
        fieldAddress=findViewById(R.id.fieldAddress)
        fieldPhone=findViewById(R.id.fieldPhone)

        fieldMateria1=findViewById(R.id.fieldMateria1)
        fieldMateria2=findViewById(R.id.fieldMateria2)
        fieldMateria3=findViewById(R.id.fieldMateria3)
        fieldMateria4=findViewById(R.id.fieldMateria4)
        fieldMateria5=findViewById(R.id.fieldMateria5)

        fieldNote1=findViewById(R.id.fieldNote1)
        fieldNote2=findViewById(R.id.fieldNote2)
        fieldNote3=findViewById(R.id.fieldNote3)
        fieldNote4=findViewById(R.id.fieldNote4)
        fieldNote5=findViewById(R.id.fieldNote5)

        var btnLogUp: Button =findViewById(R.id.logUp)
        btnLogUp.setOnClickListener { logUpStudents() }
    }

    private fun logUpStudents() {
        //Se instancia la clase estudiante y se mapean los elementos del formulario
        var est:Students= Students()
        est.ID= fieldID?.text.toString()
        est.name=fieldName?.text.toString()
        est.age=fieldAge?.text.toString().toInt()
        est.address=fieldAddress?.text.toString()
        est.phone=fieldPhone?.text.toString()

        //Si se va a trabajar las materias y notas en la misma clase Estudiante
        est.materia1=fieldMateria1?.text.toString()
        est.materia2=fieldMateria2?.text.toString()
        est.materia3=fieldMateria3?.text.toString()
        est.materia4=fieldMateria4?.text.toString()
        est.materia5=fieldMateria5?.text.toString()

        est.note1= fieldNote1?.text.toString().toDouble()
        est.note2= fieldNote2?.text.toString().toDouble()
        est.note3= fieldNote3?.text.toString().toDouble()
        est.note4= fieldNote4?.text.toString().toDouble()
        est.note5= fieldNote5?.text.toString().toDouble()

        //Se asigna el promedio delegando el calculo al metodo de la clase operaciones
        est.average= operations!!.caldulateAverage(est)

        operations?.logUpStudents(est)
        operations?.printListOfStudents()
        sendData(est)

    }
    private fun sendData(est: Students) {
        var est:Students= Students()
        val intent = Intent(this,showStudentActivity::class.java);
        val bundle:Bundle = Bundle();

        bundle.putString("name", est.name);

        bundle.putString("course1", est.materia1);
        bundle.putString("course2", est.materia2);
        bundle.putString("course3", est.materia3);
        bundle.putString("course4", est.materia4);
        bundle.putString("course5", est.materia5);

        bundle.putDouble("note1", est.note1);
        bundle.putDouble("note2", est.note2);
        bundle.putDouble("note3", est.note3);
        bundle.putDouble("note4", est.note4);
        bundle.putDouble("note5", est.note5);

        bundle.putString("state", est.state);
        bundle.putDouble("average", est.average);

        intent.putExtras(bundle);
        startActivity(intent);
    }

}