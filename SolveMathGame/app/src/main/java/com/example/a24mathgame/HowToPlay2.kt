package com.example.a24mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HowToPlay2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_to_play2)


        val back = findViewById<Button>(R.id.back)
        back.setOnClickListener(){
            val intent = Intent(this, HowToPlay::class.java)
            startActivity(intent)
        }

        val next = findViewById<Button>(R.id.next2)
        next.setOnClickListener(){
            val intent = Intent(this, HowToPlay3::class.java)
            startActivity(intent)
        }

    }
}