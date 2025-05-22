package com.example.gradarirecruitment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class OpenVacanciesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.open_vacancies)

        val mmApplyButton = findViewById<ImageButton>(R.id.mmApply)
        mmApplyButton.setOnClickListener {
            val intent = Intent(this, JobSeekerApplicationActivity::class.java)
            intent.putExtra("selectedJobTitle", "Marketing Manager")
            startActivity(intent)
        }

        val smApplyButton = findViewById<ImageButton>(R.id.smApply)
        smApplyButton.setOnClickListener {
            val intent = Intent(this, JobSeekerApplicationActivity::class.java)
            intent.putExtra("selectedJobTitle", "Sales Manager")
            startActivity(intent)
        }

        val comApplyButton = findViewById<ImageButton>(R.id.comApply)
        comApplyButton.setOnClickListener {
            val intent = Intent(this, JobSeekerApplicationActivity::class.java)
            intent.putExtra("selectedJobTitle", "Capital Operation Manager")
            startActivity(intent)
        }

        val pasApplyButton = findViewById<ImageButton>(R.id.pasApply)
        pasApplyButton.setOnClickListener {
            val intent = Intent(this, JobSeekerApplicationActivity::class.java)
            intent.putExtra("selectedJobTitle", "Pro & Admin Specialist")
            startActivity(intent)
        }

        val qaqcApplyButton = findViewById<ImageButton>(R.id.qaqcApply)
        qaqcApplyButton.setOnClickListener {
            val intent = Intent(this, JobSeekerApplicationActivity::class.java)
            intent.putExtra("selectedJobTitle", "QAQC Manager")
            startActivity(intent)
        }

        val hgdmApplyButton = findViewById<ImageButton>(R.id.hgdmApply)
        hgdmApplyButton.setOnClickListener {
            val intent = Intent(this, JobSeekerApplicationActivity::class.java)
            intent.putExtra("selectedJobTitle", "HR General & Deputy Manager")
            startActivity(intent)
        }

        // Detail buttons with links
        findViewById<ImageButton>(R.id.comButton).setOnClickListener {
            openUrl("https://guildhall.agency/job/?job_id=1110\n")
        }

        findViewById<ImageButton>(R.id.mmButton).setOnClickListener {
            openUrl("https://guildhall.agency/job/?job_id=1123\n")
        }

        findViewById<ImageButton>(R.id.hgdmButton).setOnClickListener {
            openUrl("https://guildhall.agency/job/?job_id=1072\n")
        }

        findViewById<ImageButton>(R.id.pasButton).setOnClickListener {
            openUrl("https://guildhall.agency/job/?job_id=1140\n")
        }

        findViewById<ImageButton>(R.id.smButton).setOnClickListener {
            openUrl("https://guildhall.agency/job/?job_id=1121\n")
        }

        findViewById<ImageButton>(R.id.qaqcButton).setOnClickListener {
            openUrl("https://guildhall.agency/job/?job_id=1066")
        }

        // Apply buttons – go to JobSeekerApplicationActivity
        val applyButtons = listOf(
            R.id.comApply, R.id.mmApply, R.id.pasApply,
            R.id.qaqcApply, R.id.hgdmApply, R.id.smApply
        )

        for (id in applyButtons) {
            findViewById<ImageButton>(id).setOnClickListener {
                startActivity(Intent(this, JobSeekerApplicationActivity::class.java))
            }
        }

        // Back button – go to JobSeekerDashboardActivity
        findViewById<ImageButton>(R.id.backButton).setOnClickListener {
            startActivity(Intent(this, JobSeekerDashboardActivity::class.java))
            finish()
        }
    }

    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}