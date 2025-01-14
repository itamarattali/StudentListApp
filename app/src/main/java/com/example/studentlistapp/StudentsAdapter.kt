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
        holder.bind(students[position])
    }

    override fun getItemCount(): Int = students.size

    fun updateData(newStudents: List<Student>) {
        students = newStudents
        notifyDataSetChanged()
    }

    class StudentViewHolder(private val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(student: Student) {
            binding.studentNameTextView.text = student.name
            binding.studentIdTextView.text = student.id
            binding.studentPhoneNumberTextView.text = student.phoneNumber
            binding.studentAddressTextView.text = student.address
            binding.studentCheckBox.isChecked = student.isChecked

            binding.studentCheckBox.setOnCheckedChangeListener { _, isChecked ->
                student.isChecked = isChecked
            }

            binding.root.setOnClickListener {
                // Optional: Handle onClick if needed
            }
        }
    }
}
