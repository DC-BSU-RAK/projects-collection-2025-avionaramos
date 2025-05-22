package com.example.gradarirecruitment

import android.app.AlertDialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CompanyProfileActivity : AppCompatActivity() {

    private lateinit var summaryTextView: TextView
    private lateinit var industryOutput: TextView
    private lateinit var establishedOutput: TextView
    private lateinit var registeredOutput: TextView
    private lateinit var sharedPref: SharedPreferences

    private val industryList = listOf("Real Estate", "Technology", "Finance", "Education", "Healthcare", "Retail", "Logistics")
    private val establishedYears = (1990..2025).map { it.toString() }
    private val yesNoOptions = listOf("Yes", "No")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.company_profile)

        sharedPref = getSharedPreferences("CompanyPrefs", MODE_PRIVATE)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // UI references
        summaryTextView = findViewById(R.id.companySummary)
        industryOutput = findViewById(R.id.industryOutput)
        establishedOutput = findViewById(R.id.establishedOutput)
        registeredOutput = findViewById(R.id.registeredOutput)

        // Load saved data
        summaryTextView.text = sharedPref.getString("summary", "")
        industryOutput.text = sharedPref.getString("industry", "")
        establishedOutput.text = sharedPref.getString("established", "")
        registeredOutput.text = sharedPref.getString("registered", "")

        val companyName = sharedPref.getString("companyName", "N/A")
        val email = sharedPref.getString("email", "N/A")

        val companyNameOutput = findViewById<TextView>(R.id.companynameOutput)
        val companyEmailOutput = findViewById<TextView>(R.id.companyemailOutput)

        companyNameOutput.text = companyName
        companyEmailOutput.text = email

        val backButton = findViewById<ImageButton>(R.id.previousButton8)
        val industryBtn = findViewById<ImageButton>(R.id.industrySelection)
        val establishedBtn = findViewById<ImageButton>(R.id.establishedSelection)
        val registeredBtn = findViewById<ImageButton>(R.id.registeredSelection)
        val logoutBtn = findViewById<ImageButton>(R.id.companylogoutProfile)

        // Logout button click
        logoutBtn.setOnClickListener {
            sharedPref.edit().clear().apply()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        // Back to Dashboard
        backButton.setOnClickListener {
            startActivity(Intent(this, CompanyDashboardActivity::class.java))
            finish()
        }

        // Dropdowns
        industryBtn.setOnClickListener {
            showDropdown("Choose Industry", industryList) {
                industryOutput.text = it
            }
        }

        establishedBtn.setOnClickListener {
            showDropdown("Choose Year Established", establishedYears) {
                establishedOutput.text = it
            }
        }

        registeredBtn.setOnClickListener {
            showDropdown("Registered?", yesNoOptions) {
                registeredOutput.text = it
            }
        }
    }

    private fun showDropdown(title: String, options: List<String>, onItemSelected: (String) -> Unit) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setItems(options.toTypedArray()) { _, which ->
            val value = options[which]
            onItemSelected(value)

            val editor = sharedPref.edit()
            when (title) {
                "Choose Industry" -> editor.putString("industry", value)
                "Choose Year Established" -> editor.putString("established", value)
                "Registered?" -> editor.putString("registered", value)
            }
            editor.apply()
        }
        builder.show()
    }
}