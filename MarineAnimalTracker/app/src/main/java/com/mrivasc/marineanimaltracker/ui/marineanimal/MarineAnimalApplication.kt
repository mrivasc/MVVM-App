package com.mrivasc.marineanimaltracker.ui.marineanimal

import android.app.Application
import com.mrivasc.marineanimaltracker.data.models.animals
import com.mrivasc.marineanimaltracker.repositories.MarineAnimalRepository

class MarineAnimalApplication : Application() {
    val marineAnimalRepository: MarineAnimalRepository by lazy {
        MarineAnimalRepository(animals)
    }
}