package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class CourseClassroomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_course_classroom)

        val ivBackClassroom = findViewById<ImageView>(R.id.ivBackClassroom)
        val btnJoinLive = findViewById<Button>(R.id.btnJoinLive)
        val btnDownloadTute = findViewById<RelativeLayout>(R.id.btnDownloadTute)
        val btnWatchRecording = findViewById<RelativeLayout>(R.id.btnWatchRecording)
        val btnTakeQuiz = findViewById<RelativeLayout>(R.id.btnTakeQuiz)

        ivBackClassroom.setOnClickListener { finish() }

        btnJoinLive.setOnClickListener {
            Toast.makeText(this, "Opening Live Classroom Stream... 🎥", Toast.LENGTH_SHORT).show()
        }


        btnDownloadTute.setOnClickListener {
            Toast.makeText(this, "Downloading PDF Tute... 📥", Toast.LENGTH_SHORT).show()
        }


        btnWatchRecording.setOnClickListener {
            Toast.makeText(this, "Opening Video Player... 🎬", Toast.LENGTH_SHORT).show()
        }


        btnTakeQuiz.setOnClickListener {
            Toast.makeText(this, "Starting Weekly Quiz Paper... 📝", Toast.LENGTH_SHORT).show()
        }
    }
}