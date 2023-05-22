package com.mrivasc.marineanimaltracker.repositories

import com.mrivasc.marineanimaltracker.data.models.MarineAnimalModel

class MarineAnimalRepository (private val animals: MutableList<MarineAnimalModel>){
    fun getMarineAnimals() = animals

    // Add the animal at the beggining of list
    fun addMarineAnimal(animal: MarineAnimalModel) = animals.add(0, animal)
}