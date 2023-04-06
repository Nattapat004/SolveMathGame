package com.example.a24mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class twoStarWin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_star_win)

        val mainScreen = findViewById<ImageButton>(R.id.winMainScreen)
        val next = findViewById<ImageButton>(R.id.next)
        val sharedVar = applicationContext as SharedVar
        val time = findViewById<TextView>(R.id.timeDisplay)
        val background = findViewById<ImageView>(R.id.background)
        time.text = "Time : ${sharedVar.timeElapsed} sec"


        mainScreen.setOnClickListener() {
            if (sharedVar.stageCleared < 11){
                val intent = Intent(this, LevelSelect1::class.java)
                startActivity(intent)
            } else if (sharedVar.stageCleared < 21){
                val intent = Intent(this, LevelSelect2::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, LevelSelect3::class.java)
                startActivity(intent)
            }
        }

        if (sharedVar.stageCleared < 11){
            background.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.win__9_
                )
            )
        } else if (sharedVar.stageCleared < 21){
            background.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.win_2_ep2
                )
            )
        } else {
            background.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    R.drawable.win_2_ep_3
                )
            )
        }

        next.setOnClickListener(){
            when (sharedVar.stageCleared) {
                1 -> {
                    val intent = Intent(this,Ep1Stage2::class.java)
                    startActivity(intent)
                }
                2 -> {
                    val intent = Intent(this,Ep1Stage3::class.java)
                    startActivity(intent)
                }
                3 -> {
                    val intent = Intent(this,Ep1Stage4::class.java)
                    startActivity(intent)
                }
                4 -> {
                    val intent = Intent(this,Ep1Stage5::class.java)
                    startActivity(intent)
                }
                5 -> {
                    val intent = Intent(this,Ep1Stage6::class.java)
                    startActivity(intent)
                }
                6 -> {
                    val intent = Intent(this,Ep1Stage7::class.java)
                    startActivity(intent)
                }
                7 -> {
                    val intent = Intent(this,Ep1Stage8::class.java)
                    startActivity(intent)
                }
                8 -> {
                    val intent = Intent(this,Ep1Stage9::class.java)
                    startActivity(intent)
                }
                9 -> {
                    val intent = Intent(this,Ep1Stage10::class.java)
                    startActivity(intent)
                }
                10 -> {
                    val intent = Intent(this,LevelSelect2::class.java)
                    startActivity(intent)
                }
                11 -> {
                    val intent = Intent(this,Ep2Stage2::class.java)
                    startActivity(intent)
                }
                12 -> {
                    val intent = Intent(this,Ep2Stage3::class.java)
                    startActivity(intent)
                }
                13 -> {
                    val intent = Intent(this,Ep2Stage4::class.java)
                    startActivity(intent)
                }
                14 -> {
                    val intent = Intent(this,Ep2Stage5::class.java)
                    startActivity(intent)
                }
                15 -> {
                    val intent = Intent(this,Ep2Stage6::class.java)
                    startActivity(intent)
                }
                16 -> {
                    val intent = Intent(this,Ep2Stage7::class.java)
                    startActivity(intent)
                }
                17 -> {
                    val intent = Intent(this,Ep2Stage8::class.java)
                    startActivity(intent)
                }
                18 -> {
                    val intent = Intent(this,Ep2Stage9::class.java)
                    startActivity(intent)
                }
                19 -> {
                    val intent = Intent(this,Ep2Stage10::class.java)
                    startActivity(intent)
                }
                20 -> {
                    val intent = Intent(this,LevelSelect3::class.java)
                    startActivity(intent)
                }
                21 -> {
                    val intent = Intent(this,Ep3Stage2::class.java)
                    startActivity(intent)
                }
                22 -> {
                    val intent = Intent(this,Ep3Stage3::class.java)
                    startActivity(intent)
                }
                23 -> {
                    val intent = Intent(this,Ep3Stage4::class.java)
                    startActivity(intent)
                }
                24 -> {
                    val intent = Intent(this,Ep3Stage5::class.java)
                    startActivity(intent)
                }
                25 -> {
                    val intent = Intent(this,Ep3Stage6::class.java)
                    startActivity(intent)
                }
                26 -> {
                    val intent = Intent(this,Ep3Stage7::class.java)
                    startActivity(intent)
                }
                27 -> {
                    val intent = Intent(this,Ep3Stage8::class.java)
                    startActivity(intent)
                }
                28 -> {
                    val intent = Intent(this,Ep3Stage9::class.java)
                    startActivity(intent)
                }
                29 -> {
                    val intent = Intent(this,Ep3Stage10::class.java)
                    startActivity(intent)
                }
                30 -> {
                    val intent = Intent(this,Episode::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}