package com.mrivasc.marineanimaltracker.ui.marineanimal.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mrivasc.marineanimaltracker.R
import com.mrivasc.marineanimaltracker.data.models.MarineAnimalModel
import com.mrivasc.marineanimaltracker.databinding.FragmentHomeBinding
import com.mrivasc.marineanimaltracker.ui.marineanimal.home.reyclerview.MarineAnimalRecyclerViewAdapter
import com.mrivasc.marineanimaltracker.ui.marineanimal.viewmodel.MarineAnimalViewModel

class HomeFragment : Fragment() {

    // Elements
    private lateinit var btnAddAnimal: FloatingActionButton

    // Binding elements
    private lateinit var binding: FragmentHomeBinding

    // Adapter
    private lateinit var adapter: MarineAnimalRecyclerViewAdapter

    // ViewModel
    private val viewModel: MarineAnimalViewModel by activityViewModels {
        MarineAnimalViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()

        setRecyclerView(view)

        binding.btnAddAnimal.setOnClickListener {
            viewModel.clearData()
            it.findNavController().navigate(R.id.action_homeFragment_to_newAnimalFragment)
        }
    }

    private fun setRecyclerView(view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = MarineAnimalRecyclerViewAdapter { selectedAnimal ->
            showSelectedItems(selectedAnimal)
        }

        // Setting adapter to recyclerview
        binding.recyclerView.adapter = adapter
        displayAnimals()
    }

    private fun displayAnimals() {
        adapter.setData(viewModel.getAnimals())
        adapter.notifyDataSetChanged()
    }

    private fun showSelectedItems(animatronic: MarineAnimalModel) {
        viewModel.selectedAnimal(animatronic)
        findNavController().navigate(R.id.action_homeFragment_to_infoFragment)
    }

    private fun bind() {
        btnAddAnimal = view?.findViewById(R.id.btnAddAnimal) as FloatingActionButton
    }
}