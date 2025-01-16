package com.example.studentlistapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentlistapp.databinding.ItemStudentBinding
import com.example.studentlistapp.models.Student

class StudentsAdapter(
    private var students: List<Student>,
    private val onStudentClicked: (Student) -> Unit
) : RecyclerView.Adapter<StudentsAdapter.StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(students[position], onStudentClicked)
    }

    override fun getItemCount(): Int = students.size

    fun updateData(newStudents: List<Student>) {
        students = newStudents
        notifyDataSetChanged()
    }

    class StudentViewHolder(private val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(student: Student, onStudentClicked: (Student) -> Unit) {
            binding.studentNameTextView.text = student.name
            binding.studentIdTextView.text = student.id
            binding.studentImageView.setImageResource(R.drawable.ic_default_profile)
            binding.studentCheckBox.isChecked = student.isChecked

            binding.root.setOnClickListener {
                onStudentClicked(student)
            }

            binding.studentCheckBox.setOnCheckedChangeListener { _, isChecked ->
                student.isChecked = isChecked
            }
        }
    }
}