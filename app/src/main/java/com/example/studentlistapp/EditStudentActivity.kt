package com.example.studentlistapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentlistapp.databinding.ActivityEditStudentBinding
import com.example.studentlistapp.models.Student
import com.example.studentlistapp.repository.StudentRepository

class EditStudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val studentId = intent.getStringExtra("STUDENT_ID")
        val student = StudentRepository.getAllStudents().find { it.id == studentId }

        if (student != null) {
            // Populate existing student data
            binding.studentNameEditText.setText(student.name)
            binding.studentIdEditText.setText(student.id)
            binding.studentPhoneNumberEditText.setText(student.phoneNumber)
            binding.studentAddressEditText.setText(student.address)
            binding.studentCheckBox.isChecked = student.isChecked

            // Save button logic
            binding.saveStudentButton.setOnClickListener {
                val updatedStudent = Student(
                    name = binding.studentNameEditText.text.toString(),
                    id = binding.studentIdEditText.text.toString(),
                    phoneNumber = binding.studentPhoneNumberEditText.text.toString(),
                    address = binding.studentAddressEditText.text.toString(),
                    isChecked = binding.studentCheckBox.isChecked
                )
                StudentRepository.updateStudent(student.id, updatedStudent) // Update the student in the repository
                finish()
            }

            // Delete button logic
            binding.deleteStudentButton.setOnClickListener {
                StudentRepository.deleteStudent(student)
                finish()
            }
        }

        // Cancel button logic
        binding.cancelButton.setOnClickListener {
            finish()
        }
    }
}