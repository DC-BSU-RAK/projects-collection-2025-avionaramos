package com.example.dishdecider

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InfoModalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.information)

        val closeButton: ImageButton = findViewById(R.id.closeButton)
        closeButton.setOnClickListener {
            finish() // Closes the modal and returns to MainActivity
        }
    }
}