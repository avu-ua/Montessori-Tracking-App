package ua.co.a_byte_at_a_bite.montessoritracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.navigation.fragment.findNavController
import ua.co.a_byte_at_a_bite.montessoritracker.databinding.FrThirdActivitiesListBinding

class ThirdFragment : Fragment() {

    private var _binding: FrThirdActivitiesListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FrThirdActivitiesListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupExpandableListView()
    }

    private fun setupExpandableListView() {
        val mathPresentations = listOf(
            Presentation("Math 1"),
            Presentation("Math 2"),
            Presentation("Math n")
        )
        val languagePresentations = listOf(
            Presentation("Language 1"),
            Presentation("Language 2"),
            Presentation("Language 3")
        )
        val lifePresentations = listOf(
            Presentation("Washing table"),
            Presentation("Rolling a Floor Mat"),
            Presentation("Squeezing a Sponge"),
            Presentation("Nuts and Bolts"),
            Presentation("Padlocks"),
            Presentation("Pegs"),
            Presentation("Boxes and Bottles"),
            Presentation("Folding Fabrics"),
            Presentation("Folding Paper"),
            Presentation("Cutting Paper")
        )

        val sensorialPresentations = listOf(
            Presentation("Cylinder Blocks 1"),
            Presentation("Cylinder Blocks 2"),
            Presentation("Cylinder Blocks 3"),
            Presentation("Cylinder Blocks 4"),
            Presentation("Pink Tower"),
            Presentation("Brown Stairs"),
            Presentation("Red Rods"),
            Presentation("Color Tablets 1"),
            Presentation("Color Tablets 2"),
            Presentation("Color Tablets 3")
        )

        val topics = listOf(
            Topic("Math", mathPresentations),
            Topic("Language", languagePresentations),
            Topic("Practical Life", lifePresentations),
            Topic("Sensorial", sensorialPresentations)
        )

        val adapter = ExpandableListAdapter(requireContext(), topics)
        binding.expandableListView.setAdapter(adapter)

        binding.expandableListView.setOnGroupClickListener { _, _, groupPosition, _ ->
            if (binding.expandableListView.isGroupExpanded(groupPosition)) {
                binding.expandableListView.collapseGroup(groupPosition)
            } else {
                binding.expandableListView.expandGroup(groupPosition)
            }
            true // Return true to consume the click event
        }
        binding.expandableListView.setOnChildClickListener { _, _, _, _, _ ->
            // Add click handling logic here
            findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment)
            true
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}