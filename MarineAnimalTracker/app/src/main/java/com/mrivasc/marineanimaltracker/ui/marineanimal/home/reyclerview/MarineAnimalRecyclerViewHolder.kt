package com.mrivasc.marineanimaltracker.ui.marineanimal.home.reyclerview

import androidx.recyclerview.widget.RecyclerView
import com.mrivasc.marineanimaltracker.data.models.MarineAnimalModel
import com.mrivasc.marineanimaltracker.databinding.AnimalItemBinding

class MarineAnimalRecyclerViewHolder(private val binding: AnimalItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(animal: MarineAnimalModel, clickListener: (MarineAnimalModel) -> Unit) {
        binding.txtSpecie.text = animal.specie
        binding.txtHabitat.text = animal.habitat
        binding.animalCardView.setOnClickListener {
            clickListener(animal)
        }
    }
}