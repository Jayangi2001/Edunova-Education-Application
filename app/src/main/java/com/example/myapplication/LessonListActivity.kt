package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class LessonListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_list)

        val ivBack = findViewById<ImageView>(R.id.ivBackLessons)
        val btnCreateNav = findViewById<ImageButton>(R.id.btnCreateLessonNav)

        val btnEdit1 = findViewById<ImageButton>(R.id.btnEditLesson1)
        val btnDelete1 = findViewById<ImageButton>(R.id.btnDeleteLesson1)
        val btnBookmarkLesson1 = findViewById<ImageButton>(R.id.btnBookmarkLesson1)

        val btnEdit2 = findViewById<ImageButton>(R.id.btnEditLesson2)
        val btnDelete2 = findViewById<ImageButton>(R.id.btnDeleteLesson2)
        val btnBookmarkLesson2 = findViewById<ImageButton>(R.id.btnBookmarkLesson2)

        val btnEdit3 = findViewById<ImageButton>(R.id.btnEditLesson3)
        val btnDelete3 = findViewById<ImageButton>(R.id.btnDeleteLesson3)
        val btnBookmarkLesson3 = findViewById<ImageButton>(R.id.btnBookmarkLesson3)

        ivBack.setOnClickListener { finish() }

        btnCreateNav.setOnClickListener {
            val intent = Intent(this, LessonCreateActivity::class.java)
            startActivity(intent)
        }
        val editClickListener = {
            val intent = Intent(this, LessonEditActivity::class.java)
            startActivity(intent)
        }

        btnBookmarkLesson1.setOnClickListener {
            val intent = Intent(this, AddBookmarkActivity::class.java)
            intent.putExtra("LESSON_TITLE", "01. Introduction to Mechanics")
            startActivity(intent)
        }

        btnBookmarkLesson2.setOnClickListener {
            val intent = Intent(this, AddBookmarkActivity::class.java)
            intent.putExtra("LESSON_TITLE", "02. Waves and Oscillations")
            startActivity(intent)
        }

        btnBookmarkLesson3.setOnClickListener {
            val intent = Intent(this, AddBookmarkActivity::class.java)
            intent.putExtra("LESSON_TITLE", "03. Thermal Physics")
            startActivity(intent)
        }

        btnEdit1.setOnClickListener { editClickListener() }
        btnEdit2.setOnClickListener { editClickListener() }
        btnEdit3.setOnClickListener { editClickListener() }

        fun showDeleteDialog(lessonName: String) {
            AlertDialog.Builder(this)
                .setTitle("Delete Lesson")
                .setMessage("Are you sure you want to delete '$lessonName'?")
                .setCancelable(false)
                .setPositiveButton("Delete") { dialog, _ ->
                    Toast.makeText(this, "$lessonName deleted successfully! 🗑️", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }

                .setNegativeButton("Cancel") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        btnDelete1.setOnClickListener { showDeleteDialog("01. Introduction to Mechanics") }
        btnDelete2.setOnClickListener { showDeleteDialog("02. Waves and Oscillations") }
        btnDelete3.setOnClickListener { showDeleteDialog("03. Thermal Physics") }
    }
}