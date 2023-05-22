package com.mrivasc.marineanimaltracker.ui.marineanimal.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.mrivasc.marineanimaltracker.data.models.MarineAnimalModel
import com.mrivasc.marineanimaltracker.repositories.MarineAnimalRepository
import com.mrivasc.marineanimaltracker.ui.marineanimal.MarineAnimalApplication


class MarineAnimalViewModel (private val repository: MarineAnimalRepository) : ViewModel() {
    // Mutable values linked with LiveData
    var specie = MutableLiveData("")
    var habitat = MutableLiveData("")
    var status = MutableLiveData("")

    // Get all animals
    fun getAnimals() = repository.getMarineAnimals()

    // Add an animal
    private fun addAnimal(animal: MarineAnimalModel) = repository.addMarineAnimal(animal)

    // Creating animal
    fun createAnimal() {
        // If data is wrong
        if(!validateData()) {
            status.value = WRONG_INFO
            return
        }

        // Else, add the animal
        val animal = MarineAnimalModel(
            specie.value!!,
            habitat.value!!,
        )

        addAnimal(animal)
        clearData() // Reset values

        // Success status
        status.value = ANIMAL_CREATED
    }

    // Clear var data
    fun clearData() {
        specie.value = ""
        habitat.value = ""
    }

    // Validating if strings are empty
    private fun validateData(): Boolean {
        when {
            specie.value.isNullOrEmpty() -> return false
            habitat.value.isNullOrEmpty() -> return false
        }; return true
    }

    // Reset status
    fun clearStatus() {
        status.value = INACTIVE
    }

    // Selected animal to show
    fun selectedAnimal(animal: MarineAnimalModel) {
        specie.value = animal.specie
        habitat.value = animal.habitat
    }

    // ViewModel Factory and status values
    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MarineAnimalApplication
                MarineAnimalViewModel(app.marineAnimalRepository)
            }
        }
        const val ANIMAL_CREATED = "Animal created"
        const val WRONG_INFO = "Wrong information"
        const val INACTIVE = ""
    }
}