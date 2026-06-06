package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileSuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile_success)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val userName = intent.getStringExtra("USER_NAME")
        val imageUriStr = intent.getStringExtra("PROFILE_IMAGE_URI")

        val ivCloseSuccess = findViewById<ImageView>(R.id.ivCloseSuccess)
        val tvViewProfileLink = findViewById<TextView>(R.id.tvViewProfileLink)

        ivCloseSuccess.setOnClickListener {
            navigateToMyProfile(userName, imageUriStr)
        }

        tvViewProfileLink.setOnClickListener {
            navigateToMyProfile(userName, imageUriStr)
        }
    }

    private fun navigateToMyProfile(name: String?, imageUri: String?) {
        val intent = Intent(this, MyProfileActivity::class.java)
        intent.putExtra("USER_NAME", name)
        intent.putExtra("PROFILE_IMAGE_URI", imageUri)
        startActivity(intent)
        finish()
    }
}