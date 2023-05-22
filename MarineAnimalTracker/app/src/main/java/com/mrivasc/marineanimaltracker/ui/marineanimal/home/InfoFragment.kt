package com.mrivasc.marineanimaltracker.ui.marineanimal.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.mrivasc.marineanimaltracker.R
import com.mrivasc.marineanimaltracker.databinding.FragmentInfoBinding
import com.mrivasc.marineanimaltracker.ui.marineanimal.viewmodel.MarineAnimalViewModel

class InfoFragment : Fragment() {
    private lateinit var binding: FragmentInfoBinding

    private val animalViewModel : MarineAnimalViewModel by activityViewModels {
        MarineAnimalViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewmodel = animalViewModel
    }
}