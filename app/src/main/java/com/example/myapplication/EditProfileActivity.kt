package com.example.myapplication

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.imageview.ShapeableImageView
import java.util.Calendar

class EditProfileActivity : AppCompatActivity() {

    private var updatedImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_profile)

        val ivEditBack = findViewById<ImageView>(R.id.ivEditBack)
        val editImageContainer = findViewById<FrameLayout>(R.id.editImageContainer)
        val ivEditProfilePic = findViewById<ShapeableImageView>(R.id.ivEditProfilePic)
        val etEditFirstName = findViewById<EditText>(R.id.etEditFirstName)
        val etEditLastName = findViewById<EditText>(R.id.etEditLastName)
        val etEditAddress = findViewById<EditText>(R.id.etEditAddress)
        val etEditEmail = findViewById<EditText>(R.id.etEditEmail)
        val etEditPhone = findViewById<EditText>(R.id.etEditPhone)
        val etEditDOB = findViewById<EditText>(R.id.etEditDOB)

        val btnDeleteProfile = findViewById<Button>(R.id.btnDeleteProfile)
        val btnSaveProfile = findViewById<Button>(R.id.btnSaveProfile)

        val currentName = intent.getStringExtra("CURRENT_NAME") ?: ""
        val currentImageStr = intent.getStringExtra("CURRENT_IMAGE")

        if (currentName.isNotEmpty()) {
            val nameParts = currentName.split(" ")
            if (nameParts.isNotEmpty()) etEditFirstName.setText(nameParts[0])
            if (nameParts.size > 1) etEditLastName.setText(nameParts.subList(1, nameParts.size).joinToString(" "))
        }

        etEditAddress.setText("No 245, Galle road Colombo 06")
        etEditEmail.setText("tharushi@gmail.com")
        etEditPhone.setText("071-345 7825")
        etEditDOB.setText("24/04/2009")

        if (!currentImageStr.isNullOrEmpty()) {
            updatedImageUri = Uri.parse(currentImageStr)
            ivEditProfilePic.setImageURI(updatedImageUri)
        }

        val pickImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            if (uri != null) {
                updatedImageUri = uri
                ivEditProfilePic.setImageURI(uri)
            }
        }
        editImageContainer.setOnClickListener { pickImageLauncher.launch("image/*") }

        etEditDOB.setOnClickListener {
            val c = Calendar.getInstance()
            DatePickerDialog(this, { _, y, m, d -> etEditDOB.setText("$d/${m + 1}/$y") },
                c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show()
        }

        ivEditBack.setOnClickListener { finish() }

        btnSaveProfile.setOnClickListener {
            Toast.makeText(this, "Profile Updated Successfully!", Toast.LENGTH_SHORT).show()
            finish()
        }

        btnDeleteProfile.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(this)
            val dialogView = layoutInflater.inflate(R.layout.dialog_delete_account, null)
            bottomSheetDialog.setContentView(dialogView)

            val btnCancelDelete = dialogView.findViewById<Button>(R.id.btnCancelDelete)
            val btnConfirmDelete = dialogView.findViewById<Button>(R.id.btnConfirmDelete)

            btnCancelDelete.setOnClickListener {
                bottomSheetDialog.dismiss()
            }

            btnConfirmDelete.setOnClickListener {
                bottomSheetDialog.dismiss()
                Toast.makeText(this, "Account Deleted Successfully! 🗑️", Toast.LENGTH_LONG).show()

                finish()
            }

            bottomSheetDialog.show()
        }
    }
}