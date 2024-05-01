@file:Suppress("DEPRECATION")

package com.project.mathgame

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var add : Button
    private lateinit var sub : Button
    private lateinit var mul : Button

    @SuppressLint("CustomSplashScreen")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash) // Set splash screen layout

        Handler().postDelayed({
            setContentView(R.layout.activity_main) // Set main activity layout after delay
            initializeViews() // Initialize views after setting the main activity layout
        }, 3000)
    }

    private fun initializeViews() {
        add = findViewById(R.id.add)
        sub = findViewById(R.id.sub)
        mul = findViewById(R.id.mul)

        add.setOnClickListener {
            startActivity(Intent(this@MainActivity, GameActivity::class.java))
        }
        sub.setOnClickListener {
            startActivity(Intent(this@MainActivity, SubActivity::class.java))
        }
        mul.setOnClickListener {
            startActivity(Intent(this@MainActivity, MulActivity::class.java))
        }
    }
}
