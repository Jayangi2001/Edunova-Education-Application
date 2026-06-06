package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditBookmarkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_bookmark)

        val ivBack = findViewById<ImageView>(R.id.ivBackEditBookmark)
        val etEditTitle = findViewById<EditText>(R.id.etEditBookmarkTitle)
        val etEditDesc = findViewById<EditText>(R.id.etEditBookmarkDesc)
        val btnUpdate = findViewById<Button>(R.id.btnUpdateBookmarkConfirm)

        val currentTitle = intent.getStringExtra("BOOKMARK_TITLE")
        val currentDesc = intent.getStringExtra("BOOKMARK_DESC")

        if (!currentTitle.isNullOrEmpty()) {
            etEditTitle.setText(currentTitle)
        }
        if (!currentDesc.isNullOrEmpty()) {
            etEditDesc.setText(currentDesc)
        }

        ivBack.setOnClickListener {
            finish()
        }

        btnUpdate.setOnClickListener {
            val updatedDesc = etEditDesc.text.toString().trim()

            if (updatedDesc.isEmpty()) {
                etEditDesc.error = "Note cannot be empty"
                etEditDesc.requestFocus()
            } else {

                Toast.makeText(this, "Bookmark updated successfully! 🔄📝", Toast.LENGTH_SHORT).show()

                finish()
            }
        }
    }
}