package com.example.lus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lus.databinding.ActivityPasswordchangeBinding
import com.example.lus.databinding.ActivityViaMailBinding
import com.google.firebase.auth.FirebaseAuth

class viaMail : AppCompatActivity() {


    private lateinit var binding: ActivityViaMailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityViaMailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registerListeners()

    }
    private fun registerListeners(){
         binding.buttonSendEmail.setOnClickListener{
            val email = binding.editTextEmail.text.toString()
            if(email.isEmpty()){
                Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "check email", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }

                }
             val intent = Intent(this,ResetPasswordActivity::class.java)
             startActivity(intent)
        }

    }

}