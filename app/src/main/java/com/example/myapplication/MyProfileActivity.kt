package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri

class MyProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_profile)

        val ivProfileBack = findViewById<ImageView>(R.id.ivProfileBack)
        val ivCloseProfile = findViewById<ImageView>(R.id.ivCloseProfile)
        val ivDashProfilePic = findViewById<ImageView>(R.id.ivDashProfilePic)
        val tvDashUserName = findViewById<TextView>(R.id.tvDashUserName)
        val btnEditProfile = findViewById<Button>(R.id.btnEditProfile)

        val menuMyLessons = findViewById<LinearLayout>(R.id.menuMyLessons)
        val menuMyQuiz = findViewById<LinearLayout>(R.id.menuMyQuiz)
        val menuGrades = findViewById<LinearLayout>(R.id.menuGrades)
        val menuBookmarks = findViewById<LinearLayout>(R.id.menuMyBookmarks)
        val menuLogOut = findViewById<LinearLayout>(R.id.menuLogOut)

        val userName = intent.getStringExtra("USER_NAME")
        val imageUriStr = intent.getStringExtra("PROFILE_IMAGE_URI")

        if (!userName.isNullOrEmpty()) {
            tvDashUserName.text = userName
        }
        if (!imageUriStr.isNullOrEmpty()) {
            ivDashProfilePic.setImageURI(imageUriStr.toUri())
        }

        ivProfileBack.setOnClickListener { finish() }
        ivCloseProfile.setOnClickListener { finish() }

        btnEditProfile.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            intent.putExtra("CURRENT_NAME", tvDashUserName.text.toString())
            intent.putExtra("CURRENT_IMAGE", imageUriStr)
            startActivity(intent)
        }

        menuMyLessons.setOnClickListener {
            val intent = Intent(this, LessonListActivity::class.java)
            startActivity(intent)
        }

        menuMyQuiz.setOnClickListener {
            Toast.makeText(this, "Opening My Quizzes...", Toast.LENGTH_SHORT).show()
        }

        menuGrades.setOnClickListener {
            val intent = Intent(this, GradeReportActivity::class.java)
            startActivity(intent)
        }

        menuBookmarks.setOnClickListener {
            val intent = Intent(this, SavedBookmarksActivity::class.java)
            startActivity(intent)
        }

        menuLogOut.setOnClickListener {
            Toast.makeText(this, "Logging Out...", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}