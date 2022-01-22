package com.example.lus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SendGift : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_gift)
        supportActionBar?.hide()
    }
}