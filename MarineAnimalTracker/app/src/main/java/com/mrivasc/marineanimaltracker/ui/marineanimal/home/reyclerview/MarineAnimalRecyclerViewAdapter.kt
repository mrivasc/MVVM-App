package com.mrivasc.marineanimaltracker.ui.marineanimal.home.reyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrivasc.marineanimaltracker.data.models.MarineAnimalModel
import com.mrivasc.marineanimaltracker.databinding.AnimalItemBinding

class MarineAnimalRecyclerViewAdapter(private val clickListener: (MarineAnimalModel) -> Unit):
    RecyclerView.Adapter<MarineAnimalRecyclerViewHolder>() {
    private val animals = ArrayList<MarineAnimalModel>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MarineAnimalRecyclerViewHolder {
        val binding = AnimalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MarineAnimalRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return animals.size
    }

    override fun onBindViewHolder(holder: MarineAnimalRecyclerViewHolder, position: Int) {
        val animal = animals[position]
        holder.bind(animal, clickListener)
    }

    fun setData(animatronicsList: List<MarineAnimalModel>) {
        animals.clear()
        animals.addAll(animatronicsList)
    }
}