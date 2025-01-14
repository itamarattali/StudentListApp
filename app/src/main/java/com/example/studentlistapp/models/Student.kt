package com.example.studentlistapp.models

data class Student(
    var name: String,
    var id: String,
    var phoneNumber: String,
    var address: String,
    var isChecked: Boolean = false
)
