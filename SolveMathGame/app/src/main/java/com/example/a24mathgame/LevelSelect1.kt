package com.example.a24mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class LevelSelect1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_select1)
        val backtoep = findViewById<ImageButton>(R.id.backtoep)
        backtoep.setOnClickListener {
            val intent = Intent(this, Episode::class.java)
            startActivity(intent)
        }
        val homeButton = findViewById<ImageButton>(R.id.homeButton)
        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val stage1 = findViewById<Button>(R.id.stage1)
        stage1.setOnClickListener {
            val intent = Intent(this, ep1stage1::class.java)
            startActivity(intent)
        }
    }
}