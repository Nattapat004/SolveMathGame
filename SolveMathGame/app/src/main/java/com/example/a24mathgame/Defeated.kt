package com.example.a24mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Defeated : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_defeated)

        val mainScreen = findViewById<ImageButton>(R.id.mainScreen)
        val again = findViewById<ImageButton>(R.id.again)
        val stageLost = applicationContext as SharedVar

        mainScreen.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        again.setOnClickListener(){
            if (stageLost.stageLost == 1){
                val intent = Intent(this,Ep1stage1::class.java)
                startActivity(intent)
            }else if (stageLost.stageLost == 2){
                val intent = Intent(this,Ep1Stage2::class.java)
                startActivity(intent)
            }
        }


    }
}