package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LessonEditActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_edit)

        val ivBack = findViewById<ImageView>(R.id.ivBackEdit)
        val etTitle = findViewById<EditText>(R.id.etEditLessonTitle)
        val etDesc = findViewById<EditText>(R.id.etEditLessonDesc)
        val btnUpdate = findViewById<Button>(R.id.btnUpdateLesson)

        etTitle.setText("01. Introduction to Mechanics")
        etDesc.setText("Covers basic vectors, kinematics, and Newton's laws.")

        ivBack.setOnClickListener {
            finish()
        }

        btnUpdate.setOnClickListener {
            val title = etTitle.text.toString().trim()
            val desc = etDesc.text.toString().trim()

            if (title.isEmpty() || desc.isEmpty()) {
                Toast.makeText(this, "Please fill in all details!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Lesson updated successfully! 🔄", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}