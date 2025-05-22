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

class CompanyLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.company_login)

        val companyNameEditText = findViewById<EditText>(R.id.companyNameEditText)
        val companyEmailEditText = findViewById<EditText>(R.id.companyEmailEditText)
        val signinButton = findViewById<ImageButton>(R.id.signinButton)

        signinButton.setOnClickListener {
            val companyName = companyNameEditText.text.toString()
            val email = companyEmailEditText.text.toString()

            // Save to SharedPreferences
            val sharedPref = getSharedPreferences("CompanyPrefs", MODE_PRIVATE)
            with(sharedPref.edit()) {
                putString("companyName", companyName)
                putString("email", email)
                apply()
            }

            // Show sign-in success message
            Toast.makeText(this, "SignIn Successfully", Toast.LENGTH_SHORT).show()

            // Wait 5 seconds before navigating to dashboard
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, CompanyDashboardActivity::class.java)
                startActivity(intent)
                finish()
            }, 5000)
        }
    }
}