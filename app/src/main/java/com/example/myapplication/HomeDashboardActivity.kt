package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeDashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_dashboard)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ivHeaderBack = findViewById<ImageView>(R.id.ivHeaderBack)
        val ivProfile = findViewById<ImageView>(R.id.ivProfile)
        val tabQuiz = findViewById<Button>(R.id.tabQuiz)
        val btnJoinBiology = findViewById<Button>(R.id.btnJoinBiology)
        val btnJoinPhysics = findViewById<Button>(R.id.btnJoinPhysics)
        val tabSaved = findViewById<Button>(R.id.tabSaved)
        val tabCourses = findViewById<Button>(R.id.tabMyCourses)

        ivHeaderBack.setOnClickListener {
            finish()
        }

        ivProfile.setOnClickListener {
            val intent = Intent(this, MyProfileActivity::class.java)
            startActivity(intent)
        }

        tabQuiz.setOnClickListener {
            val intent = Intent(this, QuizListActivity::class.java)
            startActivity(intent)
        }

        tabCourses.setOnClickListener {
            val intent = Intent(this, MyCoursesActivity::class.java)
            startActivity(intent)
        }

        btnJoinBiology.setOnClickListener {
            Toast.makeText(this, "Joining Biology Course...", Toast.LENGTH_SHORT).show()
        }

        btnJoinPhysics.setOnClickListener {
            Toast.makeText(this, "Joining Physics Course...", Toast.LENGTH_SHORT).show()
        }

        tabSaved.setOnClickListener {
            val intent = Intent(this, SavedItemActivity::class.java)
            startActivity(intent)
        }
    }
}