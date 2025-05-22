package com.example.gradarirecruitment

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class JobSeekerApplicationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jobseeker_application)

        val submitButton = findViewById<ImageButton>(R.id.candidateregButton)
        val backButton = findViewById<ImageButton>(R.id.previousButton10)
        val jobTitleField = findViewById<EditText>(R.id.currentJobTitleInput)

        submitButton.setOnClickListener {
            // Get job title from intent or fallback to user input
            val selectedJobTitle = intent.getStringExtra("selectedJobTitle")
            val inputJobTitle = jobTitleField.text.toString().trim()
            val finalJobTitle = when {
                !selectedJobTitle.isNullOrEmpty() -> selectedJobTitle
                inputJobTitle.isNotEmpty() -> inputJobTitle
                else -> null
            }

            if (finalJobTitle != null) {
                val status = "Applied"
                val currentDate = SimpleDateFormat("MMMM d, yyyy", Locale.getDefault()).format(Date())

                // ✅ Save to SharedPreferences
                val sharedPref = getSharedPreferences("ApplicationData", MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("jobTitle", finalJobTitle)
                    putString("status", status)
                    putString("date", currentDate)
                    apply()
                }

                Toast.makeText(this, "Your application has been submitted.", Toast.LENGTH_SHORT).show()

                // ✅ Navigate to tracking activity
                val intent = Intent(this, ApplicationTrackingActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Please enter your job title before submitting.", Toast.LENGTH_SHORT).show()
            }
        }

        backButton.setOnClickListener {
            val intent = Intent(this, JobSeekerDashboardActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
