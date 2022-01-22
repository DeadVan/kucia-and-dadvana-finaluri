package com.example.lus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SlidingScale : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sliding_scale)
        supportActionBar?.hide()
    }
}