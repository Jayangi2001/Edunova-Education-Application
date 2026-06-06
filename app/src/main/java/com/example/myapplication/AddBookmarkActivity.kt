package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddBookmarkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_bookmark)

        val ivBack = findViewById<ImageView>(R.id.ivBackAddBookmark)
        val etBookmarkTitle = findViewById<EditText>(R.id.etBookmarkTitle)
        val etBookmarkDesc = findViewById<EditText>(R.id.etBookmarkDesc)
        val btnSave = findViewById<Button>(R.id.btnSaveBookmarkConfirm)

        val lessonTitle = intent.getStringExtra("LESSON_TITLE")
        if (!lessonTitle.isNullOrEmpty()) {
            etBookmarkTitle.setText(lessonTitle)
        }

        ivBack.setOnClickListener { finish() }

        btnSave.setOnClickListener {
            val description = etBookmarkDesc.text.toString()

            Toast.makeText(this, "Saved Successfully with note! 📝⭐", Toast.LENGTH_SHORT).show()

            finish()
        }
    }
}