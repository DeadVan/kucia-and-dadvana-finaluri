package com.example.lus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class GuidBook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guid_book)
        supportActionBar?.hide()
    }
}