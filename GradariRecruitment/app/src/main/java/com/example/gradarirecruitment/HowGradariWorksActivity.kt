package com.example.gradarirecruitment

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class HowGradariWorksActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.howgradari_works)

        val previousButton = findViewById<ImageButton>(R.id.previousButton5)

        previousButton.setOnClickListener {
            val intent = Intent(this, CompanyDashboardActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}