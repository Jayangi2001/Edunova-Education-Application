package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class SavedBookmarksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_bookmarks)

        // 🔙 Back Button
        val ivBackSaved = findViewById<ImageView>(R.id.ivBackSavedBookmarks)
        ivBackSaved.setOnClickListener { finish() }

        // 📑 Tabs
        val btnTabLessons = findViewById<Button>(R.id.btnTabLessons)
        val btnTabQuestions = findViewById<Button>(R.id.btnTabQuestions)

        btnTabLessons.setOnClickListener { Toast.makeText(this, "Showing Lessons", Toast.LENGTH_SHORT).show() }
        btnTabQuestions.setOnClickListener { Toast.makeText(this, "Showing Quizzes", Toast.LENGTH_SHORT).show() }

        // 🔄 UPDATE LOGIC (Edit Buttons)
        val btnEdit1 = findViewById<ImageButton>(R.id.btnEditBookmark1)
        val btnEdit2 = findViewById<ImageButton>(R.id.btnEditBookmark2)
        val btnEdit3 = findViewById<ImageButton>(R.id.btnEditBookmark3)
        val btnEdit4 = findViewById<ImageButton>(R.id.btnEditBookmark4)
        val btnEdit5 = findViewById<ImageButton>(R.id.btnEditBookmark5)

        btnEdit1.setOnClickListener { openEditScreen("01. Introduction to Mechanics", "Revise Newton's 3rd law before exam.") }
        btnEdit2.setOnClickListener { openEditScreen("02. Waves and Oscillations", "Doppler effect formulas are hard.") }
        btnEdit3.setOnClickListener { openEditScreen("03. Thermal Physics - Tutorial 01", "Check ideal gas equations again.") }
        btnEdit4.setOnClickListener { openEditScreen("Quiz 01: Kinematics MCQs", "Got 3 wrong answers. Retry later.") }
        btnEdit5.setOnClickListener { openEditScreen("Quiz 04: Refraction & Lenses", "Lens maker's formula questions included.") }

        // 🗑️ DELETE LOGIC (Star Buttons)
        val btnDelete1 = findViewById<ImageButton>(R.id.btnDeleteBookmark1)
        val btnDelete2 = findViewById<ImageButton>(R.id.btnDeleteBookmark2)
        val btnDelete3 = findViewById<ImageButton>(R.id.btnDeleteBookmark3)
        val btnDelete4 = findViewById<ImageButton>(R.id.btnDeleteBookmark4)
        val btnDelete5 = findViewById<ImageButton>(R.id.btnDeleteBookmark5)

        btnDelete1.setOnClickListener { showDeleteDialog("01. Introduction to Mechanics") }
        btnDelete2.setOnClickListener { showDeleteDialog("02. Waves and Oscillations") }
        btnDelete3.setOnClickListener { showDeleteDialog("03. Thermal Physics - Tutorial 01") }
        btnDelete4.setOnClickListener { showDeleteDialog("Quiz 01: Kinematics MCQs") }
        btnDelete5.setOnClickListener { showDeleteDialog("Quiz 04: Refraction & Lenses") }
    }

    private fun openEditScreen(title: String, desc: String) {
        val intent = Intent(this, EditBookmarkActivity::class.java)
        intent.putExtra("BOOKMARK_TITLE", title)
        intent.putExtra("BOOKMARK_DESC", desc)
        startActivity(intent)
    }

    private fun showDeleteDialog(itemName: String) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_delete_bookmark, null)
        val builder = AlertDialog.Builder(this).setView(dialogView)
        val alertDialog = builder.create()

        val btnCancel = dialogView.findViewById<Button>(R.id.btnCancelDelete)
        val btnConfirm = dialogView.findViewById<Button>(R.id.btnConfirmDelete)

        btnCancel.setOnClickListener { alertDialog.dismiss() }
        btnConfirm.setOnClickListener {
            alertDialog.dismiss()
            Toast.makeText(this, "$itemName Removed from Bookmarks! 🗑️", Toast.LENGTH_SHORT).show()
        }
        alertDialog.show()
    }
}