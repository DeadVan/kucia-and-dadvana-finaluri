package com.example.lus

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import bottomnavigation.NewsFragment
import com.example.lus.databinding.ActivityStartGivingMonthylyBinding

class StartGivingMonthyly : AppCompatActivity() {
    private lateinit var binding: ActivityStartGivingMonthylyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_giving_monthyly)
        supportActionBar?.hide()
        binding= ActivityStartGivingMonthylyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registerListeners()
    }
    private fun  registerListeners(){

        binding.PayButton.setOnClickListener {
            Toast.makeText(this, "გადახდა", Toast.LENGTH_SHORT).show()
        }
        binding.TransferButton.setOnClickListener {
            Toast.makeText(this, "გაგზავნა", Toast.LENGTH_SHORT).show()
        }
        binding.Transaction.setOnClickListener {
            Toast.makeText(this, "პრინციპში ესენი ყველა ერთი და იგივეა გადახდა გაგზავნა IDK", Toast.LENGTH_SHORT).show()
        }
        binding.SeeAll.setOnClickListener {
            Toast.makeText(this, "ყველას ნახვა", Toast.LENGTH_SHORT).show()
        }
    }
}