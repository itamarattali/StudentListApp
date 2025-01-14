package com.example.studentlistapp.repository

import com.example.studentlistapp.models.Student

object StudentRepository {
    private val students = mutableListOf<Student>()

    fun getAllStudents(): List<Student> = students

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun updateStudentStatus(id: String, isChecked: Boolean) {
        students.find { it.id == id }?.isChecked = isChecked
    }
}
