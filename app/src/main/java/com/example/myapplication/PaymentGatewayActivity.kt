package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class PaymentGatewayActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_payment_gateway)

        val ivBackPayment = findViewById<ImageView>(R.id.ivBackPayment)
        val btnOptionCard = findViewById<RelativeLayout>(R.id.btnOptionCard)
        val btnOptionBank = findViewById<RelativeLayout>(R.id.btnOptionBank)
        val rbCard = findViewById<RadioButton>(R.id.rbCard)
        val rbBank = findViewById<RadioButton>(R.id.rbBank)

        val layoutCardDetails = findViewById<LinearLayout>(R.id.layoutCardDetails)
        val layoutBankDetails = findViewById<LinearLayout>(R.id.layoutBankDetails)

        val etCardNumber = findViewById<EditText>(R.id.etCardNumber)
        val etCardExpiry = findViewById<EditText>(R.id.etCardExpiry)
        val etCardCVV = findViewById<EditText>(R.id.etCardCVV)

        val btnUploadSlip = findViewById<Button>(R.id.btnUploadSlip)
        val btnPayFinal = findViewById<Button>(R.id.btnPayFinal)

        ivBackPayment.setOnClickListener { finish() }

        btnOptionCard.setOnClickListener {
            rbCard.isChecked = true
            rbBank.isChecked = false
            layoutCardDetails.visibility = View.VISIBLE
            layoutBankDetails.visibility = View.GONE
            btnPayFinal.text = "Secure Pay Rs. 6500"
        }

        btnOptionBank.setOnClickListener {
            rbCard.isChecked = false
            rbBank.isChecked = true
            layoutCardDetails.visibility = View.GONE
            layoutBankDetails.visibility = View.VISIBLE
            btnPayFinal.text = "Submit Receipt & Enroll"
        }

        btnUploadSlip.setOnClickListener {
            Toast.makeText(this, "Gallery Opened (Simulated) 📸", Toast.LENGTH_SHORT).show()
        }

        btnPayFinal.setOnClickListener {

            if (rbCard.isChecked) {
                val cardNo = etCardNumber.text.toString().trim()
                val expiry = etCardExpiry.text.toString().trim()
                val cvv = etCardCVV.text.toString().trim()

                if (cardNo.isEmpty() || expiry.isEmpty() || cvv.isEmpty()) {
                    Toast.makeText(this, "Please fill all card details!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                Toast.makeText(this, "Processing Card Payment... 💳", Toast.LENGTH_SHORT).show()

            } else {

                Toast.makeText(this, "Submitting Bank Receipt... 🏦", Toast.LENGTH_SHORT).show()
            }

            val intent = Intent(this, EnrollmentSuccessActivity::class.java)
            startActivity(intent)

            finish()
        }
    }
}