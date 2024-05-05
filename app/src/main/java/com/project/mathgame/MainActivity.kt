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
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        Handler().postDelayed({
            setContentView(R.layout.activity_main)
            initializeViews()
        }, 3000)
    }

    private fun initializeViews() {
        add = findViewById(R.id.add)
        sub = findViewById(R.id.sub)
        mul = findViewById(R.id.mul)

        add.setOnClickListener {
            startActivity(Intent(this@MainActivity, GameActivity::class.java).putExtra("type", "add"))
        }
        sub.setOnClickListener {
            startActivity(Intent(this@MainActivity, GameActivity::class.java).putExtra("type", "sub"))
        }
        mul.setOnClickListener {
            startActivity(Intent(this@MainActivity, GameActivity::class.java).putExtra("type", "mul"))
        }
    }
}
