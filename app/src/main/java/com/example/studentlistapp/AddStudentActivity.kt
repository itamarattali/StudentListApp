package com.example.studentlistapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentlistapp.databinding.ActivityAddStudentBinding
import com.example.studentlistapp.models.Student
import com.example.studentlistapp.models.StudentsModel

class AddStudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddStudentBinding
    private lateinit var students: MutableList<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        students = StudentsModel.shared.students

        binding.saveStudentButton.setOnClickListener {
            val name = binding.studentNameEditText.text.toString()
            val id = binding.studentIdEditText.text.toString()
            val phoneNumber = binding.studentPhoneNumberEditText.text.toString()
            val address = binding.studentAddressEditText.text.toString()

            if (name.isNotBlank() && id.isNotBlank() && phoneNumber.isNotBlank() && address.isNotBlank()) {
                addStudent(name, id, phoneNumber, address)
                finish()
            }
        }
    }

    private fun addStudent(
        name: String,
        id: String,
        phoneNumber: String,
        address: String
    ) {
        students.add(Student(name, id, phoneNumber, address))
    }
}
