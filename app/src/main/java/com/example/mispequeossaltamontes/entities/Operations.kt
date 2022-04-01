package com.example.mispequeossaltamontes.entities

class Operations {

    companion object {
        var Students = arrayListOf<Students>()
    }

    fun addStudent(student: Students) {
        Students.add(student)
    }

    fun showNumberOfRegistered(): Int {
        return Students.count()
    }

    fun validateRatingGrade(qualification: Double): Boolean {
        return qualification in 0.0..5.0
    }

    fun performAverage(student: Students): Double {
        var average: Double =
            (student.note1 + student.note2 + student.note3 +
                    student.note4 + student.note5) / 5;
        return average;
    }

    fun validateEnteredGrade(student: Students): Boolean {
        return (
                validateRatingGrade(student.note1) === true &&
                        validateRatingGrade(student.note2) === true &&
                        validateRatingGrade(student.note3) === true &&
                        validateRatingGrade(student.note4) === true &&
                        validateRatingGrade(student.note5) === true
                )
    }

    fun kwonStudentStatus(student: Students): String {
        var state = "";
        if (student.average >= 3.6) {
            state = "Gano";
        } else if (student.average >= 2.5) {
            state = "En recuperación"
        } else{
            state = "Perdio"
        }
        return state;
    }

    fun showQuantity(estado:String):Int {
        var counter:Int = 0;
        for (i in Students){
            if(i.state == estado){
                counter ++;
            }
        }
        return counter;
    }
}