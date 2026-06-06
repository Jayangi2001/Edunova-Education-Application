package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.ScrollView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizQuestionActivity : AppCompatActivity() {

    private val correctAnswers = arrayOf(
        R.id.rbOptionB1,
        R.id.rbOptionA2,
        R.id.rbOptionC3,
        R.id.rbOptionB4,
        R.id.rbOptionA5
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz_question)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val quizScrollView = findViewById<ScrollView>(R.id.quizScrollView)
        val ivQuestionsBack = findViewById<ImageView>(R.id.ivQuestionsBack)
        val btnPrevious = findViewById<Button>(R.id.btnPrevious)
        val btnNextSubmit = findViewById<Button>(R.id.btnNextSubmit)

        val rgOptions1 = findViewById<RadioGroup>(R.id.rgOptions1)
        val rgOptions2 = findViewById<RadioGroup>(R.id.rgOptions2)
        val rgOptions3 = findViewById<RadioGroup>(R.id.rgOptions3)
        val rgOptions4 = findViewById<RadioGroup>(R.id.rgOptions4)
        val rgOptions5 = findViewById<RadioGroup>(R.id.rgOptions5)

        ivQuestionsBack.setOnClickListener {
            finish()
        }

        btnPrevious.text = "Top"
        btnPrevious.setOnClickListener {
            quizScrollView.fullScroll(ScrollView.FOCUS_UP)
        }

        btnNextSubmit.text = "Submit"
        btnNextSubmit.setOnClickListener {

            val ans1 = rgOptions1.checkedRadioButtonId
            val ans2 = rgOptions2.checkedRadioButtonId
            val ans3 = rgOptions3.checkedRadioButtonId
            val ans4 = rgOptions4.checkedRadioButtonId
            val ans5 = rgOptions5.checkedRadioButtonId

            if (ans1 == -1 || ans2 == -1 || ans3 == -1 || ans4 == -1 || ans5 == -1) {
                Toast.makeText(this, "Answer all the questions!", Toast.LENGTH_SHORT).show()
            } else {
                var score = 0
                if (ans1 == correctAnswers[0]) { score++ }
                if (ans2 == correctAnswers[1]) { score++ }
                if (ans3 == correctAnswers[2]) { score++ }
                if (ans4 == correctAnswers[3]) { score++ }
                if (ans5 == correctAnswers[4]) { score++ }

                Toast.makeText(this, "Quiz Submitted Successfully! Score: $score/5", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }
}