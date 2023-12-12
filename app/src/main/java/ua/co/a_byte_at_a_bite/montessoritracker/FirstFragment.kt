package ua.co.a_byte_at_a_bite.montessoritracker

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ua.co.a_byte_at_a_bite.montessoritracker.databinding.FrFirstStudentsBinding
//import ua.co.a_byte_at_a_bite.montessoritracker.adapters.StudentAdapter
//import ua.co.a_byte_at_a_bite.montessoritracker.models.Student

class FirstFragment : Fragment() {

    private var _binding: FrFirstStudentsBinding? = null
    private val binding get() = _binding!!

    private lateinit var studentAdapter: StudentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FrFirstStudentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the adapter with an empty list
        studentAdapter = StudentAdapter(emptyList())

        // Set a layout manager for the RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Set the adapter
        binding.recyclerView.adapter = studentAdapter

        binding.fr1AddStudentBtn.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        // Update the list when needed
        // For example, you can call updateList function when new students are added
        updateList(listOf(Student("Jonny Doe"), Student("Hanna Doe")))

        // ... (other click listeners and code)
    }

    private fun updateList(students: List<Student>) {
        studentAdapter.updateStudents(students)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
