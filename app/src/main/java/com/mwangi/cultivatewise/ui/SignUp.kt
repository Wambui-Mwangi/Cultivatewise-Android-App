package com.mwangi.cultivatewise.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mwangi.cultivatewise.database.CultivateDao
import com.mwangi.cultivatewise.database.CultivateDb
import com.mwangi.cultivatewise.databinding.ActivitySignUpBinding
import com.mwangi.cultivatewise.model.User

class SignUp : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btSignUp.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            signUpUser()
        }

        binding.tvLogin.setOnClickListener{startActivity(Intent(this, SignIn::class.java))}


    }

    fun signUpUser() {
        val firstName = binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val phone = binding.etPhoneNumber.text.toString()
        val email = binding.etEmailAddress.text.toString()
        val password = binding.etPassword.text.toString()
        val confirmPassword = binding.etConfirmPassword.text.toString()
        var error = false


        if (firstName.isBlank()) {
            binding.tilUserName.error = "Name cannot be empty"
            error = true
        }
        else {
            binding.tilUserName.error = null
        }

        if (lastName.isBlank()) {
            binding.tilLastName.error = "Name cannot be empty"
            error = true
        }
        else {
            binding.tilUserName.error = null
        }

        if (phone.isBlank()) {
            binding.tilPhoneNumber.error = "Phone number cannot be empty"
            error = true
        }
        else {
            binding.tilPhoneNumber.error = null
        }

        if (email.isBlank()) {
            binding.tilEmailAddress.error = "Email Address cannot be empty"
            error = true
        }
        else {
            binding.tilEmailAddress.error = null
        }

        if (password.isBlank()) {
            binding.tilPassword.error = "Password cannot be empty"
            error = true
        }
        else {
            binding.tilPassword.error = null
        }

        if (password != confirmPassword) {
            binding.tilConfirmPassword.error = "Passwords do not match"
            error = true
        }
        else {
            binding.tilConfirmPassword.error = null
        }

        if (!error) {
            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()

            fun registerUser(db:CultivateDb, username:String, email: String, password:String){
                val userDao = db.cultivateDao()
                val newUser = User(id=0, username, email, password )
                userDao.insert(newUser)
            }

            startActivity(Intent(this, SignIn::class.java))


        }
    }
}