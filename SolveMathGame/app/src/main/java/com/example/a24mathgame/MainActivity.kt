package com.example.a24mathgame

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences = applicationContext.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()



        val playButton = findViewById<ImageButton>(R.id.playButton)
        playButton.setOnClickListener{
            val intent = Intent(this,Episode::class.java)
            startActivity(intent)
        }

        val howToPlay = findViewById<ImageButton>(R.id.howToPlay)
        howToPlay.setOnClickListener{
            val intent = Intent(this,HowToPlay::class.java)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        // do nothing
    }
}