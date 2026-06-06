package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class PhysicsEducatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_physics_educator)

        val ivBackEducator = findViewById<ImageView>(R.id.ivBackEducator)
        val btnJoinWithUsBig = findViewById<Button>(R.id.btnJoinWithUsBig)

        ivBackEducator.setOnClickListener { finish() }

        btnJoinWithUsBig.setOnClickListener {
            val intent = Intent(this, EnrollmentFormActivity::class.java)
            startActivity(intent)
        }
    }
}