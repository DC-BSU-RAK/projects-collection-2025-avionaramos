package com.example.gradarirecruitment

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class JobSeekerLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jobseeker_login)

        val fullNameEditText = findViewById<EditText>(R.id.fullNameEditText)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val loginButton = findViewById<ImageButton>(R.id.loginButton)

        loginButton.setOnClickListener {
            val fullName = fullNameEditText.text.toString()
            val email = emailEditText.text.toString()

            // Save to SharedPreferences
            val sharedPref = getSharedPreferences("JobSeekerPrefs", MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("fullName", fullName)
                putString("email", email)
                apply()
            }

            // Show sign-in success message
            Toast.makeText(this, "SignIn Successfully", Toast.LENGTH_SHORT).show()

            // Wait 5 seconds before navigating to dashboard
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, JobSeekerDashboardActivity::class.java)
                startActivity(intent)
                finish()
            }, 5000)
        }
    }
}
