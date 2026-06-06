package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSignUpSubmit = findViewById<Button>(R.id.btnSignUpSubmit)
        val tvAlreadyAccount = findViewById<TextView>(R.id.tvAlreadyAccount)
        val btnGoogleSignUp = findViewById<Button>(R.id.btnGoogleSignUp)
        val btnFacebookSignUp = findViewById<Button>(R.id.btnFacebookSignUp)

        btnSignUpSubmit.setOnClickListener {
            Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, HomeDashboardActivity::class.java)
            startActivity(intent)
        }

        tvAlreadyAccount.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }

        btnGoogleSignUp.setOnClickListener {
            Toast.makeText(this, "Connecting with Google...", Toast.LENGTH_SHORT).show()
        }

        btnFacebookSignUp.setOnClickListener {
            Toast.makeText(this, "Connecting with Facebook...", Toast.LENGTH_SHORT).show()
        }
    }
}