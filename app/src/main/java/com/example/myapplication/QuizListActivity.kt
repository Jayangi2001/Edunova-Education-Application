package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuizListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz_list)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ivQuizBack = findViewById<ImageView>(R.id.ivQuizBack)

        val tvMechViewGrade = findViewById<TextView>(R.id.tvMechViewGrade)
        val tvMechAttempt = findViewById<TextView>(R.id.tvMechAttempt)
        val ivMechDelete1 = findViewById<ImageView>(R.id.ivMechDelete1)
        val ivMechDelete2 = findViewById<ImageView>(R.id.ivMechDelete2)
        val btnMechAddNew = findViewById<Button>(R.id.btnMechAddNew)

        val tvWavesViewGrade = findViewById<TextView>(R.id.tvWavesViewGrade)
        val btnWavesGet = findViewById<Button>(R.id.btnWavesGet)

        val btnAtomicGet = findViewById<Button>(R.id.btnAtomicGet)

        ivQuizBack.setOnClickListener {
            finish()
        }

        tvMechViewGrade.setOnClickListener {
            Toast.makeText(this, "Opening Grade Report...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, GradeReportActivity::class.java)
            startActivity(intent)
        }

        tvMechAttempt.setOnClickListener {
            Toast.makeText(this, "Opening Test Knowledge Screen...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, TestKnowledgeActivity::class.java)
            startActivity(intent)
        }

        ivMechDelete1.setOnClickListener {
            showDeleteDialog("Mechanics Quiz 01")
        }

        ivMechDelete2.setOnClickListener {
            showDeleteDialog("Mechanics Quiz 02")
        }

        btnMechAddNew.setOnClickListener {
            Toast.makeText(this, "Opening Create Quiz Screen...", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CreateQuizActivity::class.java)
            startActivity(intent)
        }

        tvWavesViewGrade.setOnClickListener {
            Toast.makeText(this, "Viewing Grade for Waves Quiz 01", Toast.LENGTH_SHORT).show()
        }

        btnWavesGet.setOnClickListener {
            Toast.makeText(this, "Unlocking Premium Quiz 02...", Toast.LENGTH_SHORT).show()
        }

        btnAtomicGet.setOnClickListener {
            Toast.makeText(this, "Unlocking Premium Atomic Structure Quiz...", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showDeleteDialog(quizName: String) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_delete_quiz, null)
        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setView(dialogView)

        val alertDialog = builder.create()
        alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        val tvDeleteTitle = dialogView.findViewById<TextView>(R.id.tvDeleteTitle)
        val btnCancel = dialogView.findViewById<Button>(R.id.btnCancelDelete)
        val btnConfirm = dialogView.findViewById<Button>(R.id.btnConfirmDelete)

        tvDeleteTitle.text = "Delete $quizName?"

        btnCancel.setOnClickListener {
            alertDialog.dismiss()
        }

        btnConfirm.setOnClickListener {
            Toast.makeText(this, "$quizName Deleted Successfully!", Toast.LENGTH_SHORT).show()
            alertDialog.dismiss()
        }

        alertDialog.show()
    }
}