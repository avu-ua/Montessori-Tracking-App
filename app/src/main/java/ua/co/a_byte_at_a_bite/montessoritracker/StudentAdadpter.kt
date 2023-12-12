package ua.co.a_byte_at_a_bite.montessoritracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ua.co.a_byte_at_a_bite.montessoritracker.databinding.ItemStudentBinding
//import ua.co.a_byte_at_a_bite.montessoritracker.models.Student


class StudentAdapter(private var students: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding =
            ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.bind(student)
    }

    override fun getItemCount(): Int {
        return students.size
    }

    class StudentViewHolder(private val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(student: Student) {
            binding.studentName.text = student.name
            // Set other data to the views
        }
    }

    fun updateStudents(newStudents: List<Student>) {
        students = newStudents
        notifyDataSetChanged()
    }
}
