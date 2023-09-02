package com.mwangi.cultivatewise.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mwangi.cultivatewise.database.CultivateDb
import com.mwangi.cultivatewise.databinding.ActivitySignInBinding

class SignIn : AppCompatActivity() {
    lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btSignin.setOnClickListener {
            signInUser()
        }

//        binding.tvSignup.setOnClickListener { startActivity(Intent(this, SignUp::class.java)) }


    }

    fun signInUser() {
        val email = binding.etemail.text.toString()
        val password = binding.etpassword.text.toString()
        var error = false

        if (email.isBlank()) {
            binding.tilemail.error = "Name cannot be empty"
            error = true
        } else {
            binding.tilemail.error = null
        }

        if (password.isBlank()) {
            binding.tilpassword.error = "Password cannot be empty"
            error = true
        } else {
            binding.tilpassword.error = null
        }

        if (!error) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, Home::class.java))

            fun signInUser(db:CultivateDb, email:String, password:String):Boolean{
                val userDao = db.cultivateDao()
                val user = userDao.getUserbyEmail(email)

                if (user != null){
                    return password == user.password
                }

                return false
            }

        }
    }
}