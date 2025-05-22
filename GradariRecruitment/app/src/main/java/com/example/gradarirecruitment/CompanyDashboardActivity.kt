package com.example.gradarirecruitment

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class CompanyDashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.company_dashboard)

        val usericonButton2 = findViewById<ImageButton>(R.id.usericonButton2)
        val gradariworksButton = findViewById<ImageButton>(R.id.gradariworksButton)
        val registerButton = findViewById<ImageButton>(R.id.registerButton)
        val partnerUsButton = findViewById<ImageButton>(R.id.partnerusButton)

        usericonButton2.setOnClickListener {
            val intent = Intent(this, CompanyProfileActivity::class.java)
            startActivity(intent)
        }

        gradariworksButton.setOnClickListener {
            val intent = Intent(this, HowGradariWorksActivity::class.java)
            startActivity(intent)
        }

        registerButton.setOnClickListener {
            val intent = Intent(this, CompanyRegistrationActivity::class.java)
            startActivity(intent)
        }

        partnerUsButton.setOnClickListener {
            val intent = Intent(this, WhyPartnerWithUsActivity::class.java)
            startActivity(intent)
        }
    }
}