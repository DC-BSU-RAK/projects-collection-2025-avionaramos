package com.example.gradarirecruitment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CompanyRegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.company_registration)

        val previousButton = findViewById<ImageButton>(R.id.previousButton4)
        val submitButton = findViewById<ImageButton>(R.id.companyregButton)

        // Navigate back to dashboard
        previousButton.setOnClickListener {
            val intent = Intent(this, CompanyDashboardActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Handle form submission
        submitButton.setOnClickListener {
            Toast.makeText(this, "Application successfully submitted", Toast.LENGTH_SHORT).show()

            // Delay for 5 seconds before redirecting to dashboard
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, CompanyDashboardActivity::class.java)
                startActivity(intent)
                finish()
            }, 5000)
        }
    }
}