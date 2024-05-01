package com.project.mathgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var add : Button
    private lateinit var sub : Button
    private lateinit var mul : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        add = findViewById(R.id.add)
        sub = findViewById(R.id.sub)
        mul = findViewById(R.id.mul)

        add.setOnClickListener {
            intent = Intent(this@MainActivity, GameActivity::class.java)
            startActivity(intent)
        }
        sub.setOnClickListener {
            intent = Intent(this@MainActivity, SubActivity::class.java)
            startActivity(intent)
        }
        mul.setOnClickListener {
            intent = Intent(this@MainActivity, MulActivity::class.java)
            startActivity(intent)
        }

    }
}