package com.example.gradarirecruitment

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class WhyPartnerWithUsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.partner_with_us)

        val previousButton = findViewById<ImageButton>(R.id.previousButton6)

        previousButton.setOnClickListener {
            val intent = Intent(this, CompanyDashboardActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
