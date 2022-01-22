package com.example.lus

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.lus.databinding.ActivityLoginBinding
import com.example.lus.databinding.ActivityPasswordchangeBinding
import com.example.lus.databinding.ActivityRegistrationBinding
import com.example.lus.databinding.ActivityViaMailBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registerListeners()
    }

    private fun registerListeners() {

        binding.buttonLogin.setOnClickListener{
            val email = binding.editTextEmailAddress.text.toString()
            val password = binding.editTextPassword.text.toString()

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show()
                //return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword("email", "password")
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        gotoProfile()
                    }else{
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
                }

            gotoProfile()
        }

        binding.signin.setOnClickListener{
            val intent = Intent(this,RegistrationActivity::class.java)
            startActivity(intent)
        }
        binding.forgot.setOnClickListener {
            val intent = Intent(this,PasswordChangeAcivity::class.java)
            startActivity(intent)
        }

    }

    private fun gotoProfile() {
        startActivity(Intent(this,ProfileActivity::class.java))
        finish()
    }

}