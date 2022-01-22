package com.example.lus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.lus.databinding.ActivityInfoBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class InfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.title.text = intent.getStringExtra("currentItemTitle")
        binding.description.text = intent.getStringExtra("currentItemDescription")
        val url = intent.getStringExtra("currentItemImageUrl")

        Glide.with(this)
            .load(url)
            .into(binding.image)
    }

}