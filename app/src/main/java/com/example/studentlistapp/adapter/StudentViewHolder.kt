package com.example.studentlistapp.adapter

import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.example.studentlistapp.R
import com.example.studentlistapp.databinding.ItemStudentBinding
import com.example.studentlistapp.models.Student

class StudentViewHolder(
    private val binding: ItemStudentBinding,
    onStudentClicked: (Student?) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {
    private var student: Student? = null

    init {
        binding.studentCheckBox.apply {
            setOnClickListener { view ->
                student?.isChecked = (view as? CheckBox)?.isChecked ?: false
            }
        }

        itemView.setOnClickListener {
            onStudentClicked(student)
        }
    }

    fun bind(student: Student) {
        this.student = student
        binding.studentNameTextView.text = student.name
        binding.studentIdTextView.text = student.id
        binding.studentImageView.setImageResource(R.drawable.ic_default_profile)
        binding.studentCheckBox.isChecked = student.isChecked
    }
}