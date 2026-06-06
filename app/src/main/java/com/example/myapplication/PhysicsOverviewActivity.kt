package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class PhysicsOverviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_physics_overview)

        val ivBackPhysics = findViewById<ImageView>(R.id.ivBackPhysics)
        val btnEnrollNow = findViewById<Button>(R.id.btnEnrollNow)

        ivBackPhysics.setOnClickListener { finish() }

        btnEnrollNow.setOnClickListener {
            val intent = Intent(this, PhysicsEducatorActivity::class.java)
            startActivity(intent)
        }
    }
}