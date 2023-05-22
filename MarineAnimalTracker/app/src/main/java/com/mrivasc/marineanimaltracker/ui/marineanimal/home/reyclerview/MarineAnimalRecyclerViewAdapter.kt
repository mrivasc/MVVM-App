package com.mrivasc.marineanimaltracker.ui.marineanimal.home.reyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrivasc.marineanimaltracker.data.models.MarineAnimalModel
import com.mrivasc.marineanimaltracker.databinding.AnimalItemBinding

class MarineAnimalRecyclerViewAdapter(private val clickListener: (MarineAnimalModel) -> Unit):
    RecyclerView.Adapter<MarineAnimalRecyclerViewHolder>() {
    private val animatronics = ArrayList<MarineAnimalModel>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MarineAnimalRecyclerViewHolder {
        val binding = AnimalItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MarineAnimalRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return animatronics.size
    }

    override fun onBindViewHolder(holder: MarineAnimalRecyclerViewHolder, position: Int) {
        val animatronic = animatronics[position]
        holder.bind(animatronic, clickListener)
    }

    fun setData(animatronicsList: List<MarineAnimalModel>) {
        animatronics.clear()
        animatronics.addAll(animatronicsList)
    }
}