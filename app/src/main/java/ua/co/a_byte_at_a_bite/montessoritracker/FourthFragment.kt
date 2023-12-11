package ua.co.a_byte_at_a_bite.montessoritracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ua.co.a_byte_at_a_bite.montessoritracker.databinding.FrFourthViewEditActivityBinding


class FourthFragment : Fragment() {

    private var _binding: FrFourthViewEditActivityBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FrFourthViewEditActivityBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}