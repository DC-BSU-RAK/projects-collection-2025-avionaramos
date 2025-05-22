package com.example.gradarirecruitment

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class JobSeekerDashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jobseeker_dashboard) // Ensure this matches your XML filename

        // Find buttons by ID
        val userIconButton = findViewById<ImageButton>(R.id.usericonButton)
        val vacanciesButton = findViewById<ImageButton>(R.id.vacanciesButton)
        val careerButton = findViewById<ImageButton>(R.id.gradariworksButton)
        val applicationButton = findViewById<ImageButton>(R.id.partnerusButton)

        // Set click listeners
        userIconButton.setOnClickListener {
            val intent = Intent(this, JobSeekerProfileActivity::class.java)
            startActivity(intent)
        }

        vacanciesButton.setOnClickListener {
            val intent = Intent(this, OpenVacanciesActivity::class.java)
            startActivity(intent)
        }

        careerButton.setOnClickListener {
            val intent = Intent(this, CareerGuidanceActivity::class.java)
            startActivity(intent)
        }

        applicationButton.setOnClickListener {
            val intent = Intent(this, ApplicationTrackingActivity::class.java)
            startActivity(intent)
        }
    }
}