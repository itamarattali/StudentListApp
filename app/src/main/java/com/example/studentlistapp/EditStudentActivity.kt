package com.example.studentlistapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentlistapp.databinding.ActivityEditStudentBinding
import com.example.studentlistapp.models.Student
import com.example.studentlistapp.models.StudentsModel

class EditStudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditStudentBinding
    private lateinit var students: MutableList<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        students = StudentsModel.shared.students

        val studentId = intent.getStringExtra("STUDENT_ID")
        val student = students.find { it.id == studentId }

        if (student != null) {
            binding.studentNameEditText.setText(student.name)
            binding.studentIdEditText.setText(student.id)
            binding.studentPhoneNumberEditText.setText(student.phoneNumber)
            binding.studentAddressEditText.setText(student.address)
            binding.studentCheckBox.isChecked = student.isChecked

            binding.saveStudentButton.setOnClickListener {
                val updatedStudent = Student(
                    name = binding.studentNameEditText.text.toString(),
                    id = binding.studentIdEditText.text.toString(),
                    phoneNumber = binding.studentPhoneNumberEditText.text.toString(),
                    address = binding.studentAddressEditText.text.toString(),
                    isChecked = binding.studentCheckBox.isChecked
                )
                updateStudent(student.id, updatedStudent)
                finish()
            }

            binding.deleteStudentButton.setOnClickListener {
                deleteStudent(student)
                navigateToStudentList()
            }
        }

        binding.cancelButton.setOnClickListener {
            finish()
        }
    }

    private fun navigateToStudentList() {
        val intent = Intent(this, StudentsListActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

    private fun deleteStudent(student: Student) {
        students.remove(student)
    }

    private fun updateStudent(oldId: String, updatedStudent: Student) {
        val index = students.indexOfFirst { it.id == oldId }
        if (index != -1) {
            students[index] = updatedStudent
        }
    }
}