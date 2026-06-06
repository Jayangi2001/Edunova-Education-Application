package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout

class MyCoursesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_courses)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayoutCourses)
        val cardPhysics = findViewById<LinearLayout>(R.id.cardPhysics)
        val ivCoursesBack = findViewById<ImageView>(R.id.ivCoursesBack)
        val ivCoursesProfilePic = findViewById<ImageView>(R.id.ivCoursesProfilePic)
        val tvWelcomeBackTitle = findViewById<TextView>(R.id.tvWelcomeBackTitle)

        tabLayout.addTab(tabLayout.newTab().setText("Home"))
        tabLayout.addTab(tabLayout.newTab().setText("Dash Board"))
        tabLayout.addTab(tabLayout.newTab().setText("My Courses"))
        tabLayout.addTab(tabLayout.newTab().setText("Quiz"))

        tabLayout.getTabAt(2)?.select()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MyCoursesActivity, "${tab?.text} Selected", Toast.LENGTH_SHORT).show()
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
        cardPhysics.setOnClickListener {

            val intent = Intent(this, PhysicsOverviewActivity::class.java)
            startActivity(intent)
        }

        ivCoursesBack.setOnClickListener { finish() }
    }
}