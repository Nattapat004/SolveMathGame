package com.example.a24mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.content.ContextCompat

class Defeated : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_defeated)

        val mainScreen = findViewById<ImageButton>(R.id.mainScreen)
        val again = findViewById<ImageButton>(R.id.again)
        val background = findViewById<ImageView>(R.id.background)
        val sharedVar = applicationContext as SharedVar

        mainScreen.setOnClickListener() {
            if (sharedVar.stageLost < 11){
                val intent = Intent(this, LevelSelect1::class.java)
                startActivity(intent)
            } else if (sharedVar.stageLost < 21){
                val intent = Intent(this, LevelSelect2::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, LevelSelect3::class.java)
                startActivity(intent)
            }
        }

        if (sharedVar.stageLost < 11){
            background.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.lose_ep1
                )
            )
        } else if (sharedVar.stageLost < 21){
            background.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.lose_ep2
                )
            )
        } else {
            background.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.lose_ep3
                )
            )
        }

        again.setOnClickListener(){
            when (sharedVar.stageLost) {
                1 -> {
                    val intent = Intent(this,Ep1stage1::class.java)
                    startActivity(intent)
                }
                2 -> {
                    val intent = Intent(this,Ep1Stage2::class.java)
                    startActivity(intent)
                }
                3 -> {
                    val intent = Intent(this,Ep1Stage3::class.java)
                    startActivity(intent)
                }
                4 -> {
                val intent = Intent(this,Ep1Stage4::class.java)
                startActivity(intent)
                }
                5 -> {
                    val intent = Intent(this,Ep1Stage5::class.java)
                    startActivity(intent)
                }
                6 -> {
                    val intent = Intent(this,Ep1Stage6::class.java)
                    startActivity(intent)
                }
                7 -> {
                    val intent = Intent(this,Ep1Stage7::class.java)
                    startActivity(intent)
                }
                8 -> {
                    val intent = Intent(this,Ep1Stage8::class.java)
                    startActivity(intent)
                }
                9 -> {
                    val intent = Intent(this,Ep1Stage9::class.java)
                    startActivity(intent)
                }
                10 -> {
                    val intent = Intent(this,Ep1Stage10::class.java)
                    startActivity(intent)
                }
                11 -> {
                    val intent = Intent(this,Ep2Stage1::class.java)
                    startActivity(intent)
                }
                12 -> {
                    val intent = Intent(this,Ep2Stage2::class.java)
                    startActivity(intent)
                }
                13 -> {
                    val intent = Intent(this,Ep2Stage3::class.java)
                    startActivity(intent)
                }
                14 -> {
                    val intent = Intent(this,Ep2Stage4::class.java)
                    startActivity(intent)
                }
                15 -> {
                    val intent = Intent(this,Ep2Stage5::class.java)
                    startActivity(intent)
                }
                16 -> {
                    val intent = Intent(this,Ep2Stage6::class.java)
                    startActivity(intent)
                }
                17 -> {
                    val intent = Intent(this,Ep2Stage7::class.java)
                    startActivity(intent)
                }
                18 -> {
                    val intent = Intent(this,Ep2Stage8::class.java)
                    startActivity(intent)
                }
                19 -> {
                    val intent = Intent(this,Ep2Stage9::class.java)
                    startActivity(intent)
                }
                20 -> {
                    val intent = Intent(this,Ep2Stage10::class.java)
                    startActivity(intent)
                }
                21 -> {
                    val intent = Intent(this,Ep3Stage1::class.java)
                    startActivity(intent)
                }
                22 -> {
                    val intent = Intent(this,Ep3Stage2::class.java)
                    startActivity(intent)
                }
                23 -> {
                    val intent = Intent(this,Ep3Stage3::class.java)
                    startActivity(intent)
                }
                24 -> {
                    val intent = Intent(this,Ep3Stage4::class.java)
                    startActivity(intent)
                }
                25 -> {
                    val intent = Intent(this,Ep3Stage5::class.java)
                    startActivity(intent)
                }
                26 -> {
                    val intent = Intent(this,Ep3Stage6::class.java)
                    startActivity(intent)
                }
                27 -> {
                    val intent = Intent(this,Ep3Stage7::class.java)
                    startActivity(intent)
                }
                28 -> {
                    val intent = Intent(this,Ep3Stage8::class.java)
                    startActivity(intent)
                }
                29 -> {
                    val intent = Intent(this,Ep3Stage9::class.java)
                    startActivity(intent)
                }
                30 -> {
                    val intent = Intent(this,Ep3Stage10::class.java)
                    startActivity(intent)
                }
            }
        }


    }
}