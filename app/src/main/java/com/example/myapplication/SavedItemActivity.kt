package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class SavedItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_item)

        val ivBack = findViewById<ImageView>(R.id.ivBackSaved)
        val btnTabLessons = findViewById<Button>(R.id.btnTabLessons)
        val btnTabQuestions = findViewById<Button>(R.id.btnTabQuestions)

        val btnUnbookmark1 = findViewById<ImageButton>(R.id.btnUnbookmark1)
        val btnUnbookmark2 = findViewById<ImageButton>(R.id.btnUnbookmark2)

        ivBack.setOnClickListener { finish() }

        btnTabLessons.setOnClickListener {
            btnTabLessons.setTextColor(resources.getColor(android.R.color.holo_orange_dark, null))
            btnTabQuestions.setTextColor(resources.getColor(android.R.color.darker_gray, null))
            Toast.makeText(this, "Showing Saved Lessons", Toast.LENGTH_SHORT).show()
        }

        btnTabQuestions.setOnClickListener {
            btnTabQuestions.setTextColor(resources.getColor(android.R.color.holo_orange_dark, null))
            btnTabLessons.setTextColor(resources.getColor(android.R.color.darker_gray, null))
            Toast.makeText(this, "Showing Saved Quizzes", Toast.LENGTH_SHORT).show()
        }

        fun showRemoveBookmarkDialog(itemName: String) {
            AlertDialog.Builder(this)
                .setTitle("Remove Bookmark")
                .setMessage("Are you sure you want to remove '$itemName' from your saved list?")
                .setCancelable(false)

                .setPositiveButton("Remove") { dialog, _ ->
                    Toast.makeText(this, "Removed from Bookmarks! 🗑️", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }

                .setNegativeButton("Cancel") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        btnUnbookmark1.setOnClickListener { showRemoveBookmarkDialog("02. Waves and Oscillations") }
        btnUnbookmark2.setOnClickListener { showRemoveBookmarkDialog("03. Thermal Physics - Tutorial 01") }
    }
}