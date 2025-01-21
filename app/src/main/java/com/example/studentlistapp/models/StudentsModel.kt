package com.example.studentlistapp.models

class StudentsModel private constructor() {
    val students = mutableListOf<Student>()

    companion object {
        val shared = StudentsModel()
    }
}