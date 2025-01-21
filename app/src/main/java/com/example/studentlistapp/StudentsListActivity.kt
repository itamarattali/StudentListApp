package com.example.studentlistapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentlistapp.adapter.StudentAdapter
import com.example.studentlistapp.databinding.ActivityStudentsListBinding
import com.example.studentlistapp.models.Student
import com.example.studentlistapp.models.StudentsModel

class StudentsListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentsListBinding
    private lateinit var students: MutableList<Student>
    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        students = StudentsModel.shared.students

        adapter = StudentAdapter(students) { student ->
            if (student != null) {
                val intent = Intent(this, StudentDetailsActivity::class.java)
                intent.putExtra("STUDENT_ID", student.id)
                startActivity(intent)
            }
        }

        binding.studentsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.studentsRecyclerView.adapter = adapter

        binding.addStudentButton.setOnClickListener {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivity(intent)
        }

        showOrUpdateStudentsList()
    }

    override fun onResume() {
        super.onResume()
        adapter.updateData(students)
        showOrUpdateStudentsList()
    }

    private fun showOrUpdateStudentsList() {
        if (students.isEmpty()) {
            binding.noStudentsTextView.visibility = android.view.View.VISIBLE
            binding.studentsRecyclerView.visibility = android.view.View.GONE
        } else {
            binding.noStudentsTextView.visibility = android.view.View.GONE
            binding.studentsRecyclerView.visibility = android.view.View.VISIBLE
        }
    }
}