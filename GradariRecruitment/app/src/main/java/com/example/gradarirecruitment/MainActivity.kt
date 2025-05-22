package com.example.gradarirecruitment


import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val jobButton = findViewById<ImageButton>(R.id.jobButton)
        val hireButton = findViewById<ImageButton>(R.id.hireButton)


        jobButton.setOnClickListener {
            val intent = Intent(this, JobSeekerLoginActivity::class.java)
            startActivity(intent)
        }


        hireButton.setOnClickListener {
            val intent = Intent(this, CompanyLoginActivity::class.java)
            startActivity(intent)
        }
    }
}
