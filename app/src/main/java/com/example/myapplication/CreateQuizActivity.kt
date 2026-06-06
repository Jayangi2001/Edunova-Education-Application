package com.example.myapplication

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class CreateQuizActivity : AppCompatActivity() {

    private var questionCounter = 0
    private var isEditMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_quiz)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val ivCreateBack = findViewById<ImageView>(R.id.ivCreateBack)
        val tvCreateTitle = findViewById<TextView>(R.id.tvCreateTitle)
        val etQuizTitle = findViewById<EditText>(R.id.etQuizTitle)
        val etQuizCategory = findViewById<EditText>(R.id.etQuizCategory)
        val etQuizDescription = findViewById<EditText>(R.id.etQuizDescription)
        val etStartDate = findViewById<EditText>(R.id.etStartDate)
        val etDueDate = findViewById<EditText>(R.id.etDueDate)
        val etQuizTime = findViewById<EditText>(R.id.etQuizTime)
        val etNumQuestions = findViewById<EditText>(R.id.etNumQuestions)

        val questionsContainer = findViewById<LinearLayout>(R.id.questionsContainer)
        val btnAddNewQuestionFields = findViewById<Button>(R.id.btnAddNewQuestionFields)
        val btnSaveQuiz = findViewById<Button>(R.id.btnSaveQuiz)


        isEditMode = intent.getBooleanExtra("IS_EDIT_MODE", false)

        if (isEditMode) {
            // Edit Mode නම්, Screen Title එක සහ Button Text එක වෙනස් කරනවා
            tvCreateTitle.text = "Edit Quiz Details"
            btnSaveQuiz.text = "Update & Save Changes"

            // කලින් තිබ්බ ඩේටා ටික Fields වලට Auto-Fill කරනවා (දැනට Dummy Data දමා ඇත)
            etQuizTitle.setText(intent.getStringExtra("QUIZ_TITLE") ?: "Mechanics Quiz 01")
            etQuizCategory.setText("Physics - Mechanics")
            etQuizDescription.setText("This quiz covers Newton's laws and friction.")
            etStartDate.setText("2026-06-01")
            etDueDate.setText("2026-06-10")
            etQuizTime.setText("45")
            etNumQuestions.setText("2")

            // 🌟 Edit කරද්දී කලින් තිබ්බ ප්‍රශ්න ටිකත් පල්ලෙහාට auto එකතු වෙන්න ඕන නිසා:
            loadExistingQuestions(questionsContainer)
        }

        // 2. Back Button
        ivCreateBack.setOnClickListener { finish() }

        // 3. Date Pickers
        etStartDate.setOnClickListener { showDatePicker(etStartDate) }
        etDueDate.setOnClickListener { showDatePicker(etDueDate) }

        // 4. Add Dynamic Question Fields Button
        btnAddNewQuestionFields.setOnClickListener {
            val maxQuestionsStr = etNumQuestions.text.toString().trim()
            if (maxQuestionsStr.isEmpty()) {
                Toast.makeText(this, "Please enter 'No. of Questions' first!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val maxQuestions = maxQuestionsStr.toInt()
            if (questionCounter < maxQuestions) {
                questionCounter++
                addQuestionForm(questionsContainer, questionCounter, "", "", "", "", "", "")
            } else {
                Toast.makeText(this, "You have already added $maxQuestions questions!", Toast.LENGTH_SHORT).show()
            }
        }

        // 5. Save / Update Button Click Action
        btnSaveQuiz.setOnClickListener {
            val title = etQuizTitle.text.toString().trim()
            if (title.isEmpty()) {
                Toast.makeText(this, "Please enter Quiz Title!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (isEditMode) {
                Toast.makeText(this, "Quiz '$title' Updated Successfully! 🔄", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Quiz '$title' Created Successfully! 🚀", Toast.LENGTH_LONG).show()
            }
            finish()
        }
    }

    // 🔄 Dynamic එකක් ඇතුළත් කරන පොදු Function එක
    private fun addQuestionForm(container: LinearLayout, number: Int, qText: String, a: String, b: String, c: String, d: String, correct: String) {
        val inflater = LayoutInflater.from(this)
        val questionView = inflater.inflate(R.layout.item_question_input, container, false)

        questionView.findViewById<TextView>(R.id.tvDynamicQuestionNum).text = "Question $number"

        // පරණ ඩේටා තියෙනවා නම් ඒවා සෙට් කරනවා (Edit Mode එකේදී පාවිච්චි වේ)
        questionView.findViewById<EditText>(R.id.etDynamicQuestionText).setText(qText)
        questionView.findViewById<EditText>(R.id.etDynamicOptA).setText(a)
        questionView.findViewById<EditText>(R.id.etDynamicOptB).setText(b)
        questionView.findViewById<EditText>(R.id.etDynamicOptC).setText(c)
        questionView.findViewById<EditText>(R.id.etDynamicOptD).setText(d)
        questionView.findViewById<EditText>(R.id.etDynamicCorrect).setText(correct)

        container.addView(questionView)
    }

    // 📝 Edit කරද්දී පරණ ප්‍රශ්න ඩේටා ටික Load කරන හැටි (Sample)
    private fun loadExistingQuestions(container: LinearLayout) {
        questionCounter++
        addQuestionForm(container, questionCounter, "What is the SI unit of force?", "Watt", "Joule", "Newton", "Pascal", "C")

        questionCounter++
        addQuestionForm(container, questionCounter, "F = ma represents which law?", "1st Law", "2nd Law", "3rd Law", "Gravitation", "B")
    }

    private fun showDatePicker(editText: EditText) {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(this, { _, year, month, day ->
            editText.setText("$year-${month + 1}-$day")
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
        datePickerDialog.show()
    }
}