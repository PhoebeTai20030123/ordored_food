package com.example.sport.index_data

import com.example.sport.R
import com.example.sport.index_modle.Affirmation

class Datasource {
    fun fat(): List<Affirmation>{
        return listOf<Affirmation>(
            Affirmation(R.string.yoga, R.drawable.yoga),
            Affirmation(R.string.dance, R.drawable.dance),
            Affirmation(R.string.boxing, R.drawable.boxing),
            Affirmation(R.string.plank, R.drawable.plank),
            Affirmation(R.string.squat, R.drawable.squat)
        )
    }
}