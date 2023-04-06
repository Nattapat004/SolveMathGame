package com.example.a24mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HowToPlay3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_to_play3)

        val back = findViewById<Button>(R.id.back3)
        back.setOnClickListener(){
            val intent = Intent(this, HowToPlay2::class.java)
            startActivity(intent)
        }


    }
    override fun onBackPressed() {
        // do nothing
    }
}