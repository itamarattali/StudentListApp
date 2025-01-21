package com.example.studentlistapp.models

class StudentsModel private constructor() {
    val students = mutableListOf<Student>()

    companion object {
        val shared = StudentsModel()
    }

    init {
        for (i in 0..20) {
            val student = Student(
                name = "Student $i",
                id = i.toString(),
                phoneNumber = i.toString(),
                address = "address $i",
                isChecked = false
            )

            students.add(student)
        }
    }
}