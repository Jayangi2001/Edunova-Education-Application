package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class EnrollmentFormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_enrollment_form)

        val ivBackEnrollForm = findViewById<ImageView>(R.id.ivBackEnrollForm)
        val spinnerMonths = findViewById<Spinner>(R.id.spinnerMonths)
        val btnEnrollNowFinal = findViewById<Button>(R.id.btnEnrollNowFinal)

        ivBackEnrollForm.setOnClickListener { finish() }

        val months = arrayOf("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, months)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMonths.adapter = adapter

        spinnerMonths.setSelection(5)

        btnEnrollNowFinal.setOnClickListener {
            val selectedMonth = spinnerMonths.selectedItem.toString()
            Toast.makeText(this, "Successfully Enrolled for $selectedMonth! 🎉", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, PaymentGatewayActivity::class.java)
            startActivity(intent)

            finish()
        }
    }
}