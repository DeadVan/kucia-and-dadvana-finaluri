package com.example.lus

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.lus.databinding.ActivityLoginBinding
import com.example.lus.databinding.ActivityRegistrationBinding
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity:AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerListeners()
   }

    private fun registerListeners (){
        binding.buttonregistration.setOnClickListener{
            val email = binding.editTextEmail.text.toString()
            val password = binding.editPassword.text.toString()

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        startActivity(Intent(this, ProfileActivity::class.java) )
                        finish()
                    }else{
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }

                }

        }

    }
}