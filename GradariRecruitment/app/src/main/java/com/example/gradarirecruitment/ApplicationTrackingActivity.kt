package com.example.gradarirecruitment

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ApplicationTrackingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.application_tracking)

        val sharedPref = getSharedPreferences("ApplicationData", MODE_PRIVATE)
        val jobTitle = sharedPref.getString("jobTitle", null)
        val status = sharedPref.getString("status", null)
        val date = sharedPref.getString("date", null)

        val statusView = findViewById<TextView>(R.id.statusTextView)
        val titleView = findViewById<TextView>(R.id.jobTitleTextView)
        val dateView = findViewById<TextView>(R.id.dateTextView)

        if (jobTitle != null && status != null && date != null) {
            statusView.text = status
            titleView.text = jobTitle
            dateView.text = "Submitted on $date"
        } else {
            statusView.text = "No application submitted yet."
            titleView.text = ""
            dateView.text = ""
        }

        // Back button
        findViewById<ImageButton>(R.id.previousButton2).setOnClickListener {
            startActivity(Intent(this, JobSeekerDashboardActivity::class.java))
        }
    }
}