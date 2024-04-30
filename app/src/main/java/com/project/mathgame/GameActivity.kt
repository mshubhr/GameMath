package com.project.mathgame

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private lateinit var score : TextView
    private lateinit var life : TextView
    private lateinit var time : TextView
    private lateinit var que : TextView
    private lateinit var ans : EditText
    private lateinit var ok : Button
    lateinit var next : Button

    private var correct = 0
    private var userscore = 0
    private var userlife = 3

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)

        score = findViewById(R.id.score)
        life = findViewById(R.id.life)
        time = findViewById(R.id.time)
        que = findViewById(R.id.que)
        ans = findViewById(R.id.ans)
        ok = findViewById(R.id.ok)
        next = findViewById(R.id.next)

        gameContinue()

        ok.setOnClickListener {
            val input = ans.text.toString()
            if (input == "") {
                Toast.makeText(applicationContext, "Please enter your answer!", Toast.LENGTH_SHORT)
                    .show()
            }
            else {
                val yourans = input.toInt()
                if (yourans == correct) {
                    userscore += 10
                    que.text = "Nice, your answer is correct"
                    score.text = userscore.toString()
                }
                else {
                    userlife--
                    que.text = "Uff, your answer is wrong"
                    life.text = userlife.toString()
                }
            }

        }

        next.setOnClickListener {
            gameContinue()
            ans.setText("")
        }

    }

    @SuppressLint("SetTextI18n")
    fun gameContinue() {
        val num1 = Random.nextInt(0, 100)
        val num2 = Random.nextInt(0, 100)
        que.text = "$num1 + $num2"
        correct = num1 + num2
    }
}