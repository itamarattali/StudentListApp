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

    fun deleteStudent(student: Student) {
        students.remove(student) // Removes the specific student
    }

    fun updateStudent(oldId: String, updatedStudent: Student) {
        val index = students.indexOfFirst { it.id == oldId }
        if (index != -1) {
            students[index] = updatedStudent // Replace the old student with the updated student
        }
    }
}