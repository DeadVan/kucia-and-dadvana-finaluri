package com.example.lus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SeaAnimals : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sea_animals)
        supportActionBar?.hide()
    }
}