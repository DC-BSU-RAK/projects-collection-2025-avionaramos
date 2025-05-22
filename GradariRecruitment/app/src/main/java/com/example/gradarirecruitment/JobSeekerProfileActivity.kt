package com.example.gradarirecruitment

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit

class JobSeekerProfileActivity : AppCompatActivity() {

    private lateinit var sharedPref: android.content.SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jobseeker_profile)

        sharedPref = getSharedPreferences("JobSeekerPrefs", MODE_PRIVATE)
        val fullName = sharedPref.getString("fullName", "N/A")
        val email = sharedPref.getString("email", "N/A")

        // Display full name and email
        val nameOutput = findViewById<TextView>(R.id.candidatenameOutput)
        val emailOutput = findViewById<TextView>(R.id.candidateemailOutput)
        nameOutput.text = fullName
        emailOutput.text = email

        val genderOutput = findViewById<TextView>(R.id.genderOutput)
        val emiratesOutput = findViewById<TextView>(R.id.emiratesOutput)
        val visaOutput = findViewById<TextView>(R.id.visaOutput)
        val summaryView = findViewById<EditText>(R.id.candidateSummary)

        genderOutput.text = sharedPref.getString("gender", "")
        emiratesOutput.text = sharedPref.getString("emirates", "")
        visaOutput.text = sharedPref.getString("visa", "")
        summaryView.setText(sharedPref.getString("summary", ""))

        // Back button
        findViewById<ImageButton>(R.id.previousButton7).setOnClickListener {
            startActivity(Intent(this, JobSeekerDashboardActivity::class.java))
            finish()
        }

        // Gender dropdown
        findViewById<ImageButton>(R.id.genderSelection).setOnClickListener {
            showDropdown(arrayOf("Female", "Male", "Others"), genderOutput)
        }

        // Logout button — clears all data
        val logoutBtn = findViewById<ImageButton>(R.id.candidatelogoutProfile)
        logoutBtn.setOnClickListener {
            sharedPref.edit() { clear() }  // Clears everything
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Emirates dropdown
        findViewById<ImageButton>(R.id.emiratesSelection).setOnClickListener {
            showDropdown(
                arrayOf(
                    "Abu Dhabi",
                    "Dubai",
                    "Sharjah",
                    "Ajman",
                    "Umm Al Quwain",
                    "Ras Al Khaimah",
                    "Fujairah"
                ),
                emiratesOutput
            )
        }

        // Visa dropdown
        findViewById<ImageButton>(R.id.visaSelection).setOnClickListener {
            showDropdown(
                arrayOf(
                    "Father’s Visa",
                    "Mother’s Visa",
                    "Spouse Visa",
                    "Visit Visa",
                    "Student Visa",
                    "Employee Visa",
                    "Freelance Visa",
                    "Golden Visa"
                ),
                visaOutput
            )
        }
    }

    private fun saveToPrefs(key: String, value: String) {
        sharedPref.edit().putString(key, value).apply()
    }

    private fun showDropdown(options: Array<String>, output: TextView) {
        val builder = AlertDialog.Builder(this)
        builder.setItems(options) { _, which ->
            val value = options[which]
            output.text = value

            when (output.id) {
                R.id.genderOutput -> saveToPrefs("gender", value)
                R.id.emiratesOutput -> saveToPrefs("emirates", value)
                R.id.visaOutput -> saveToPrefs("visa", value)
            }
        }
        builder.show()
    }
    override fun onPause() {
        super.onPause()
        val summary = findViewById<EditText>(R.id.candidateSummary).text.toString()
        sharedPref.edit().putString("summary", summary).apply()
    }
}
