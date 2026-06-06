package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class LessonCreateActivity : AppCompatActivity() {

    private lateinit var tvSelectedFileName: TextView
    private var selectedFileUri: Uri? = null

    @SuppressLint("SetTextI18n")
    private val filePickerLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            selectedFileUri = data?.data

            selectedFileUri?.let { uri ->
                val fileName = getFileName(uri)
                tvSelectedFileName.text = "📎 $fileName"
                tvSelectedFileName.setTextColor(resources.getColor(android.R.color.holo_green_dark, null))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_create)

        val ivBack = findViewById<ImageView>(R.id.ivBackCreate)
        val etTitle = findViewById<EditText>(R.id.etLessonTitle)
        val etDesc = findViewById<EditText>(R.id.etLessonDesc)
        val layoutUpload = findViewById<LinearLayout>(R.id.layoutUploadFile)
        tvSelectedFileName = findViewById(R.id.tvSelectedFileName)
        val btnSave = findViewById<Button>(R.id.btnSaveLesson)

        ivBack.setOnClickListener { finish() }

        layoutUpload.setOnClickListener {
            val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "*/*" // 🌟 PDF, Word, Image ඕනම එකක් තෝරන්න දීමට
                val mimeTypes = arrayOf("application/pdf", "application/msword", "image/*")
                putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
                addCategory(Intent.CATEGORY_OPENABLE)
            }
            filePickerLauncher.launch(intent)
        }

        btnSave.setOnClickListener {
            val title = etTitle.text.toString().trim()
            val desc = etDesc.text.toString().trim()

            if (title.isEmpty() || desc.isEmpty()) {
                Toast.makeText(this, "Please fill in all details!", Toast.LENGTH_SHORT).show()
            } else {

                AlertDialog.Builder(this)
                    .setTitle("Success! 🎉")
                    .setMessage("Lesson and files have been uploaded successfully.")
                    .setCancelable(false)
                    .setPositiveButton("Done") { dialog, _ ->
                        dialog.dismiss()
                        finish()
                    }
                    .show()
            }
        }
    }

    private fun getFileName(uri: Uri): String {
        var result: String? = null
        if (uri.scheme == "content") {
            val cursor = contentResolver.query(uri, null, null, null, null)
            cursor?.use {
                if (it.moveToFirst()) {
                    val index = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                    if (index != -1) result = it.getString(index)
                }
            }
        }
        if (result == null) {
            result = uri.path
            val cut = result?.lastIndexOf('/')
            if (cut != null && cut != -1) {
                result = result?.substring(cut + 1)
            }
        }
        return result ?: "Selected File"
    }
}