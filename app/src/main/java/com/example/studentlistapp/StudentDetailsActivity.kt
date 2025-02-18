package com.example.studentlistapp

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.example.studentlistapp.databinding.ActivityStudentDetailsBinding
import com.example.studentlistapp.models.StudentsModel

class StudentDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentDetailsBinding
    private var studentId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        studentId = intent.getStringExtra("STUDENT_ID")
        loadStudentDetails()

        binding.editStudentButton.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("STUDENT_ID", studentId)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        loadStudentDetails()
    }

    private fun loadStudentDetails() {
        val student = StudentsModel.shared.students.find { it.id == studentId }

        if (student != null) {
            binding.studentNameTextView.text = "Name: ${student.name}"
            binding.studentIdTextView.text = "ID: ${student.id}"
            binding.studentPhoneNumberTextView.text = "Phone: ${student.phoneNumber}"
            binding.studentAddressTextView.text = "Address: ${student.address}"
            binding.studentCheckBox.apply {
                isChecked = student.isChecked
                setOnClickListener { view ->
                    student.isChecked = (view as? CheckBox)?.isChecked ?: false
                }
            }
        }
    }
}