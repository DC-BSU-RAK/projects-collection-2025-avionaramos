package com.example.gradarirecruitment

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class CareerGuidanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.career_guidance)

        val previousButton3 = findViewById<ImageButton>(R.id.previousButton3)
        previousButton3.setOnClickListener {
            val intent = Intent(this, JobSeekerDashboardActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}