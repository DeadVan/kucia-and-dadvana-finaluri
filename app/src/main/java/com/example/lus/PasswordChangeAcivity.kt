package com.example.lus

import android.content.Intent
import android.os.Binder
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.lus.databinding.ActivityPasswordchangeBinding
import com.example.lus.databinding.ActivityViaMailBinding
import com.google.firebase.auth.FirebaseAuth

class PasswordChangeAcivity:AppCompatActivity() {

    private lateinit var binding: ActivityPasswordchangeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityPasswordchangeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imageView2.setOnClickListener{
            val intent = Intent(this,viaMail::class.java)
            startActivity(intent)
        }

    }

}


