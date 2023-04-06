package com.example.a24mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Episode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episode)
        val back = findViewById<ImageButton>(R.id.back)
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val ep1 = findViewById<ImageButton>(R.id.ep1)
        val ep2 = findViewById<ImageButton>(R.id.ep2)
        val ep3 = findViewById<ImageButton>(R.id.ep3)
        ep1.setOnClickListener {
            val intent = Intent(this, LevelSelect1::class.java)
            startActivity(intent)
        }

        ep2.setOnClickListener(){
            val intent = Intent(this, LevelSelect2::class.java)
            startActivity(intent)
        }

        ep3.setOnClickListener(){
            val intent = Intent(this, LevelSelect3::class.java)
            startActivity(intent)
        }


    }
    override fun onBackPressed() {
        // do nothing
    }
}