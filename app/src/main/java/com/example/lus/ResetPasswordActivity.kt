package com.example.lus

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lus.databinding.ActivityResetpasswordBinding
import com.google.firebase.auth.FirebaseAuth

class ResetPasswordActivity :AppCompatActivity(){

    private lateinit var binding: ActivityResetpasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityResetpasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registerListeners()

    }
    private fun registerListeners(){
        binding.update.setOnClickListener{
            val newPassword = binding.editpassword1.text.toString()
            val newPassword2 = binding.editpassword2.text.toString()
            if(newPassword.isEmpty()||newPassword.length<6){
                Toast.makeText(this, "incorrect password ", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(newPassword2.isEmpty()||newPassword2.length<6){
                Toast.makeText(this, "incorrect password ", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().currentUser?.updatePassword(newPassword)
                ?.addOnCompleteListener{task->
                    if ( task.isSuccessful){
                        Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }


}