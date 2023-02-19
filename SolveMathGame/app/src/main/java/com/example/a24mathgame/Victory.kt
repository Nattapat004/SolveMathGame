package com.example.a24mathgame

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Victory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_victory)


        val mainScreen = findViewById<ImageButton>(R.id.winMainScreen)
        val next = findViewById<ImageButton>(R.id.next)
        val stageCleared = applicationContext as StageCheck

        mainScreen.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        next.setOnClickListener(){
            if (stageCleared.stageCleared == 1){
                val intent = Intent(this,Ep1Stage2::class.java)
                startActivity(intent)
            }
        }
    }
}