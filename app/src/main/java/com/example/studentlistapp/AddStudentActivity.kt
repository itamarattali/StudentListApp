package com.example.studentlistapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentlistapp.databinding.ActivityAddStudentBinding
import com.example.studentlistapp.models.Student
import com.example.studentlistapp.repository.StudentRepository

class AddStudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveStudentButton.setOnClickListener {
            val name = binding.studentNameEditText.text.toString()
            val id = binding.studentIdEditText.text.toString()
            val phoneNumber = binding.studentPhoneNumberEditText.text.toString()
            val address = binding.studentAddressEditText.text.toString()

            if (name.isNotBlank() && id.isNotBlank() && phoneNumber.isNotBlank() && address.isNotBlank()) {
                StudentRepository.addStudent(Student(name, id, phoneNumber, address))
                finish()
            }
        }
    }
}
