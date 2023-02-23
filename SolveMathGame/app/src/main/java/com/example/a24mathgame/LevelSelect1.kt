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
        val stage1Cleared = applicationContext as SharedVar
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
            val intent = Intent(this, Ep1stage1::class.java)
            startActivity(intent)
        }

        val stage2 = findViewById<Button>(R.id.stage2)
        stage2.isEnabled = stage1Cleared.stage1Cleared
        if (stage2.isEnabled){
            stage2.setBackgroundResource(R.drawable.component_1__1_)
        }
        stage2.setOnClickListener(){
            val intent = Intent(this, Ep1Stage2::class.java)
            startActivity(intent)
        }



    }
}