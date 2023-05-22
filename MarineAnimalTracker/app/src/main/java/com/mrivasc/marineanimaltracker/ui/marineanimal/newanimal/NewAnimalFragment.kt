package com.mrivasc.marineanimaltracker.ui.marineanimal.newanimal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.mrivasc.marineanimaltracker.databinding.FragmentNewAnimalBinding
import com.mrivasc.marineanimaltracker.ui.marineanimal.viewmodel.MarineAnimalViewModel

class NewAnimalFragment : Fragment() {

    private lateinit var binding: FragmentNewAnimalBinding
    private val animalViewModel : MarineAnimalViewModel by activityViewModels {
        MarineAnimalViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewAnimalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }

    private fun observeStatus() {
        animalViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(MarineAnimalViewModel.WRONG_INFO) -> {
                    Log.d("Error", status)
                    animalViewModel.clearStatus()
                }
                status.equals(MarineAnimalViewModel.ANIMAL_CREATED) -> {
                    Log.d("Success", status)

                    animalViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    private fun setViewModel() {
        binding.viewmodel = animalViewModel
    }
}