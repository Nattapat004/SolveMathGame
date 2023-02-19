package com.example.a24mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Victory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_victory)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(){
            val intent = Intent(this, LevelSelect::class.java)
            startActivity(intent)
        }
    }
}