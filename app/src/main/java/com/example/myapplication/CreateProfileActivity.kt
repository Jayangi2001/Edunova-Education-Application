package com.example.myapplication

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.imageview.ShapeableImageView
import java.util.Calendar

class CreateProfileActivity : AppCompatActivity() {

    private var selectedImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_profile)

        // --- Bind Views ---
        val profileImageContainer = findViewById<FrameLayout>(R.id.profileImageContainer)
        val ivProfilePlaceholder = findViewById<ShapeableImageView>(R.id.ivProfilePlaceholder)

        val etFirstName = findViewById<EditText>(R.id.etFirstName)
        val etLastName = findViewById<EditText>(R.id.etLastName)
        val etAddress = findViewById<EditText>(R.id.etAddress)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etGender = findViewById<EditText>(R.id.etGender)
        val etDOB = findViewById<EditText>(R.id.etDOB)
        val etGrade = findViewById<EditText>(R.id.etGrade)
        val etMedium = findViewById<EditText>(R.id.etMedium)

        val btnCreateProfile = findViewById<Button>(R.id.btnCreateProfile)

        val btnGoogleSignUp = findViewById<Button>(R.id.btnGoogleSignUp)
        val btnFacebookSignUp = findViewById<Button>(R.id.btnFacebookSignUp)

        val pickImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            if (uri != null) {
                selectedImageUri = uri
                ivProfilePlaceholder.setImageURI(uri)
            }
        }

        profileImageContainer.setOnClickListener {
            pickImageLauncher.launch("image/*")
        }

        etDOB.setOnClickListener {
            val c = Calendar.getInstance()
            val datePickerDialog = DatePickerDialog(this, { _, year, month, day ->

                etDOB.setText("$year-${month + 1}-$day")
            }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH))

            datePickerDialog.show()
        }

        btnCreateProfile.setOnClickListener {
            val fName = etFirstName.text.toString().trim()
            val lName = etLastName.text.toString().trim()

            if (fName.isEmpty() || lName.isEmpty()) {
                Toast.makeText(this, "Please fill First Name and Last Name!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            navigateToSuccessScreen("$fName $lName")
        }

        btnGoogleSignUp.setOnClickListener {
            Toast.makeText(this, "Signing up with Google...", Toast.LENGTH_SHORT).show()

            navigateToSuccessScreen("Google User")
        }

        btnFacebookSignUp.setOnClickListener {
            Toast.makeText(this, "Signing up with Facebook...", Toast.LENGTH_SHORT).show()

            navigateToSuccessScreen("Facebook User")
        }
    }

    private fun navigateToSuccessScreen(userName: String) {
        val myIntent = Intent(this, ProfileSuccessActivity::class.java)
        myIntent.putExtra("USER_NAME", userName)

        if (selectedImageUri != null) {
            myIntent.putExtra("PROFILE_IMAGE_URI", selectedImageUri.toString())
        }
        startActivity(myIntent)
    }
}