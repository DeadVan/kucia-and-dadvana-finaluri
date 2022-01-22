package com.example.lus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SideBar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_side_bar)
        supportActionBar?.hide()
    }
}