package com.project.mathgame

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    private lateinit var play : Button
    private lateinit var exit : Button
    lateinit var res : TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        res = findViewById(R.id.result)
        play = findViewById(R.id.again)
        exit = findViewById(R.id.exit)

        val score = intent.getIntExtra("score",0)
        res.text = "Your score: $score"

        play.setOnClickListener {

            val intent = Intent(this@ResultActivity,MainActivity::class.java)
            startActivity(intent)
            finish()

        }

        exit.setOnClickListener {

            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)

        }

    }
}