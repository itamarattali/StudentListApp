package com.example.studentlistapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentlistapp.databinding.ActivityStudentDetailsBinding
import com.example.studentlistapp.repository.StudentRepository

class StudentDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val studentId = intent.getStringExtra("STUDENT_ID")
        val student = StudentRepository.getAllStudents().find { it.id == studentId }

        if (student != null) {
            binding.studentNameTextView.text = "Name: ${student.name}"
            binding.studentIdTextView.text = "ID: ${student.id}"
            binding.studentPhoneNumberTextView.text = "Phone: ${student.phoneNumber}"
            binding.studentAddressTextView.text = "Address: ${student.address}"
            binding.studentCheckBox.isChecked = student.isChecked

        }
    }
}