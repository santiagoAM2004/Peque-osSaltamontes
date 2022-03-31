package com.example.mispequeossaltamontes.entities

import java.io.Serializable

class Operations:Serializable {
    var listStudents: ArrayList<Students> =arrayListOf<Students>()

    fun logUpStudents(students: Students){
        listStudents.add(students)
    }

    fun printListOfStudents(){
        for(est in listStudents){
            println(est)
        }
    }

    fun caldulateAverage(est: Students): Double {

        var prom=(est.note1+est.note2+est.note3+est.note4+est.note4+est.note5)/5

        return prom
    }
}