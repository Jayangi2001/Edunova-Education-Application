package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GradeReportActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n", "DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_grade_report)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ivReportClose = findViewById<ImageView>(R.id.ivReportClose)
        val circularProgressBar = findViewById<ProgressBar>(R.id.circularProgressBar)
        val tvScorePercentage = findViewById<TextView>(R.id.tvScorePercentage)
        val tvCorrectCount = findViewById<TextView>(R.id.tvCorrectCount)
        val tvIncorrectCount = findViewById<TextView>(R.id.tvIncorrectCount)

        val btnReviewQuiz = findViewById<Button>(R.id.btnReviewQuiz)
        val btnGoHome = findViewById<Button>(R.id.btnGoHome)

        val totalQuestions = 5
        val correctAnswers = 4
        val incorrectAnswers = 1
        val percentage = (correctAnswers.toFloat() / totalQuestions * 100).toInt()

        circularProgressBar.progress = percentage
        tvScorePercentage.text = "$percentage%"
        tvCorrectCount.text = String.format("%02d", correctAnswers)
        tvIncorrectCount.text = String.format("%02d", incorrectAnswers)

        ivReportClose.setOnClickListener {
            finish()
        }

        btnReviewQuiz.setOnClickListener {
            Toast.makeText(this, "Opening Quiz Review Mode...", Toast.LENGTH_SHORT).show()
        }

        btnGoHome.setOnClickListener {
            val intent = Intent(this, HomeDashboardActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}