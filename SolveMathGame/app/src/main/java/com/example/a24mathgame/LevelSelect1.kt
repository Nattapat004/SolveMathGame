package com.example.a24mathgame

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.view.isVisible

class LevelSelect1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_select1)
        val sharedPreferences = applicationContext.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        var stars11 = sharedPreferences.getInt("stars11", 0)
        var prevStars11 = sharedPreferences.getInt("prevStars11", 0)
        var stage11Cleared = sharedPreferences.getBoolean("stage11Cleared", false)
        var stars12 = sharedPreferences.getInt("stars12", 0)
        var prevStars12 = sharedPreferences.getInt("prevStars12", 0)
        var stage12Cleared = sharedPreferences.getBoolean("stage12Cleared", false)
        var stars13 = sharedPreferences.getInt("stars13", 0)
        var prevStars13 = sharedPreferences.getInt("prevStars13", 0)
        var stage13Cleared = sharedPreferences.getBoolean("stage13Cleared", false)
        var stars14 = sharedPreferences.getInt("stars14", 0)
        var prevStars14 = sharedPreferences.getInt("prevStars14", 0)
        var stage14Cleared = sharedPreferences.getBoolean("stage14Cleared", false)
        var stars15 = sharedPreferences.getInt("stars15", 0)
        var prevStars15 = sharedPreferences.getInt("prevStars15", 0)
        var stage15Cleared = sharedPreferences.getBoolean("stage15Cleared", false)
        var stars16 = sharedPreferences.getInt("stars16", 0)
        var prevStars16 = sharedPreferences.getInt("prevStars16", 0)
        var stage16Cleared = sharedPreferences.getBoolean("stage16Cleared", false)
        var stars17 = sharedPreferences.getInt("stars17", 0)
        var prevStars17 = sharedPreferences.getInt("prevStars17", 0)
        var stage17Cleared = sharedPreferences.getBoolean("stage17Cleared", false)
        var stars18 = sharedPreferences.getInt("stars18", 0)
        var prevStars18 = sharedPreferences.getInt("prevStars18", 0)
        var stage18Cleared = sharedPreferences.getBoolean("stage18Cleared", false)
        var stars19 = sharedPreferences.getInt("stars19", 0)
        var prevStars19 = sharedPreferences.getInt("prevStars19", 0)
        var stage19Cleared = sharedPreferences.getBoolean("stage19Cleared", false)
        var stars110 = sharedPreferences.getInt("stars110", 0)
        var prevStars110 = sharedPreferences.getInt("prevStars110", 0)
        var stage110Cleared = sharedPreferences.getBoolean("stage110Cleared", false)
        val backtoep = findViewById<ImageButton>(R.id.backtoep)
        val shared = applicationContext as SharedVar
        val stage1 = findViewById<Button>(R.id.stage1)
        val stage2 = findViewById<Button>(R.id.stage2)
        val stage3 = findViewById<Button>(R.id.stage3)
        val stage4 = findViewById<Button>(R.id.stage4)
        val stage5 = findViewById<Button>(R.id.stage5)
        val stage6 = findViewById<Button>(R.id.stage6)
        val stage7 = findViewById<Button>(R.id.stage7)
        val stage8 = findViewById<Button>(R.id.stage8)
        val stage9 = findViewById<Button>(R.id.stage9)
        val stage10 = findViewById<Button>(R.id.stage10)
        val bigStar1 = findViewById<ImageView>(R.id.bStar1)
        val bigStar2 = findViewById<ImageView>(R.id.bStar2)
        val bigStar3 = findViewById<ImageView>(R.id.bStar3)
        val bigStar4 = findViewById<ImageView>(R.id.bStar4)
        val bigStar5 = findViewById<ImageView>(R.id.bStar5)
        val bigStar6 = findViewById<ImageView>(R.id.bStar6)
        val bigStar7 = findViewById<ImageView>(R.id.bStar7)
        val bigStar8 = findViewById<ImageView>(R.id.bStar8)
        val bigStar9 = findViewById<ImageView>(R.id.bStar9)
        val bigStar10 = findViewById<ImageView>(R.id.bStar10)
        val smallStar11 = findViewById<ImageView>(R.id.star11)
        val smallStar12 = findViewById<ImageView>(R.id.star12)
        val smallStar21 = findViewById<ImageView>(R.id.star13)
        val smallStar22 = findViewById<ImageView>(R.id.star14)
        val smallStar31 = findViewById<ImageView>(R.id.star15)
        val smallStar32 = findViewById<ImageView>(R.id.star16)
        val smallStar41 = findViewById<ImageView>(R.id.star17)
        val smallStar42 = findViewById<ImageView>(R.id.star18)
        val smallStar51 = findViewById<ImageView>(R.id.star19)
        val smallStar52 = findViewById<ImageView>(R.id.star20)
        val smallStar61 = findViewById<ImageView>(R.id.star21)
        val smallStar62 = findViewById<ImageView>(R.id.star22)
        val smallStar71 = findViewById<ImageView>(R.id.star23)
        val smallStar72 = findViewById<ImageView>(R.id.star24)
        val smallStar81 = findViewById<ImageView>(R.id.star25)
        val smallStar82 = findViewById<ImageView>(R.id.star26)
        val smallStar91 = findViewById<ImageView>(R.id.star27)
        val smallStar92 = findViewById<ImageView>(R.id.star28)
        val smallStar101 = findViewById<ImageView>(R.id.star29)
        val smallStar102 = findViewById<ImageView>(R.id.star30)
        val stars = mutableListOf<ImageView>(
            bigStar1,
            bigStar2,
            bigStar3,
            bigStar4,
            bigStar5,
            bigStar6,
            bigStar7,
            bigStar8,
            bigStar9,
            bigStar10,
            smallStar11,
            smallStar12,
            smallStar21,
            smallStar22,
            smallStar31,
            smallStar32,
            smallStar41,
            smallStar42,
            smallStar51,
            smallStar52,
            smallStar61,
            smallStar62,
            smallStar71,
            smallStar72,
            smallStar81,
            smallStar82,
            smallStar91,
            smallStar92,
            smallStar91,
            smallStar101,
            smallStar102
        )
        for (i: ImageView in stars) {
            i.isVisible = false
        }


        if (stars11 == 3){
            bigStar1.isVisible = true
            smallStar11.isVisible = true
            smallStar12.isVisible = true
            editor.putInt("prevStars11", 3)
        } else if (stars11 == 2){
            if (prevStars11 == 3){
                bigStar1.isVisible = true
                smallStar11.isVisible = true
                smallStar12.isVisible = true
                editor.putInt("prevStars11", 3)
            } else {
                bigStar1.isVisible = true
                smallStar11.isVisible = true
                editor.putInt("prevStars11", 2)
            }
        } else if (stars11 == 1){
            if (prevStars11 == 2){
                bigStar1.isVisible = true
                smallStar11.isVisible = true
                editor.putInt("prevStars11", 2)
            } else if (prevStars11 == 3){
                bigStar1.isVisible = true
                smallStar11.isVisible = true
                smallStar12.isVisible = true
                editor.putInt("prevStars11", 3)
            } else {
                bigStar1.isVisible = true
                editor.putInt("prevStars11", 1)
            }
        }


        if (stars12 == 3){
            bigStar2.isVisible = true
            smallStar21.isVisible = true
            smallStar22.isVisible = true
            editor.putInt("prevStars12", 3)
        } else if (stars12 == 2){
            if (prevStars12 == 3){
                bigStar2.isVisible = true
                smallStar21.isVisible = true
                smallStar22.isVisible = true
                editor.putInt("prevStars12", 3)
            } else {
                bigStar2.isVisible = true
                smallStar21.isVisible = true
                editor.putInt("prevStars12", 2)
            }
        } else if (stars12 == 1){
            if (prevStars12 == 2){
                bigStar2.isVisible = true
                smallStar21.isVisible = true
                editor.putInt("prevStars12", 2)
            } else if (prevStars12 == 3){
                bigStar2.isVisible = true
                smallStar21.isVisible = true
                smallStar22.isVisible = true
                editor.putInt("prevStars12", 3)
            } else {
                bigStar2.isVisible = true
                editor.putInt("prevStars12", 1)
            }
        }

        if (stars13 == 3){
            bigStar3.isVisible = true
            smallStar31.isVisible = true
            smallStar32.isVisible = true
            editor.putInt("prevStars13", 3)
        } else if (stars13 == 2){
            if (prevStars13 == 3){
                bigStar3.isVisible = true
                smallStar31.isVisible = true
                smallStar32.isVisible = true
                editor.putInt("prevStars13", 3)
            } else {
                bigStar3.isVisible = true
                smallStar31.isVisible = true
                editor.putInt("prevStars13", 2)
            }
        } else if (stars13 == 1){
            if (prevStars13 == 2){
                bigStar3.isVisible = true
                smallStar31.isVisible = true
                editor.putInt("prevStars13", 2)
            } else if (prevStars13 == 3){
                bigStar3.isVisible = true
                smallStar31.isVisible = true
                smallStar32.isVisible = true
                editor.putInt("prevStars13", 3)
            } else {
                bigStar3.isVisible = true
                editor.putInt("prevStars13", 1)
            }
        }

        if (stars14 == 3){
            bigStar4.isVisible = true
            smallStar41.isVisible = true
            smallStar42.isVisible = true
            editor.putInt("prevStars14", 3)
        } else if (stars14 == 2){
            if (prevStars14 == 3){
                bigStar4.isVisible = true
                smallStar41.isVisible = true
                smallStar42.isVisible = true
                editor.putInt("prevStars14", 3)
            } else {
                bigStar4.isVisible = true
                smallStar41.isVisible = true
                editor.putInt("prevStars14", 2)
            }
        } else if (stars14 == 1){
            if (prevStars14 == 2){
                bigStar4.isVisible = true
                smallStar41.isVisible = true
                editor.putInt("prevStars14", 2)
            } else if (prevStars14 == 3){
                bigStar4.isVisible = true
                smallStar41.isVisible = true
                smallStar42.isVisible = true
                editor.putInt("prevStars14", 3)
            } else {
                bigStar1.isVisible = true
                editor.putInt("prevStars14", 1)
            }
        }

        if (stars15 == 3){
            bigStar5.isVisible = true
            smallStar51.isVisible = true
            smallStar52.isVisible = true
            editor.putInt("prevStars15", 3)
        } else if (stars15 == 2){
            if (prevStars15 == 3){
                bigStar5.isVisible = true
                smallStar51.isVisible = true
                smallStar52.isVisible = true
                editor.putInt("prevStars15", 3)
            } else {
                bigStar5.isVisible = true
                smallStar51.isVisible = true
                editor.putInt("prevStars15", 2)
            }
        } else if (stars15 == 1){
            if (prevStars15 == 2){
                bigStar5.isVisible = true
                smallStar51.isVisible = true
                editor.putInt("prevStars15", 2)
            } else if (prevStars15 == 3){
                bigStar5.isVisible = true
                smallStar51.isVisible = true
                smallStar52.isVisible = true
                editor.putInt("prevStars15", 3)
            } else {
                bigStar5.isVisible = true
                editor.putInt("prevStars15", 1)
            }
        }

        if (stars16 == 3){
            bigStar6.isVisible = true
            smallStar61.isVisible = true
            smallStar62.isVisible = true
            editor.putInt("prevStars16", 3)
        } else if (stars16 == 2){
            if (prevStars16 == 3){
                bigStar6.isVisible = true
                smallStar61.isVisible = true
                smallStar62.isVisible = true
                editor.putInt("prevStars16", 3)
            } else {
                bigStar6.isVisible = true
                smallStar61.isVisible = true
                editor.putInt("prevStars16", 2)
            }
        } else if (stars16 == 1){
            if (prevStars16 == 2){
                bigStar6.isVisible = true
                smallStar61.isVisible = true
                editor.putInt("prevStars16", 2)
            } else if (prevStars16 == 3){
                bigStar1.isVisible = true
                smallStar61.isVisible = true
                smallStar62.isVisible = true
                editor.putInt("prevStars16", 3)
            } else {
                bigStar6.isVisible = true
                editor.putInt("prevStars16", 1)
            }
        }

        if (stars17 == 3){
            bigStar7.isVisible = true
            smallStar71.isVisible = true
            smallStar72.isVisible = true
            editor.putInt("prevStars17", 3)
        } else if (stars17 == 2){
            if (prevStars17 == 3){
                bigStar7.isVisible = true
                smallStar71.isVisible = true
                smallStar72.isVisible = true
                editor.putInt("prevStars17", 3)
            } else {
                bigStar7.isVisible = true
                smallStar71.isVisible = true
                editor.putInt("prevStars17", 2)
            }
        } else if (stars17 == 1){
            if (prevStars17 == 2){
                bigStar7.isVisible = true
                smallStar71.isVisible = true
                editor.putInt("prevStars17", 2)
            } else if (prevStars17 == 3){
                bigStar7.isVisible = true
                smallStar71.isVisible = true
                smallStar72.isVisible = true
                editor.putInt("prevStars17", 3)
            } else {
                bigStar7.isVisible = true
                editor.putInt("prevStars17", 1)
            }
        }

        if (stars18 == 3){
            bigStar8.isVisible = true
            smallStar81.isVisible = true
            smallStar82.isVisible = true
            editor.putInt("prevStars18", 3)
        } else if (stars18 == 2){
            if (prevStars18 == 3){
                bigStar8.isVisible = true
                smallStar81.isVisible = true
                smallStar82.isVisible = true
                editor.putInt("prevStars18", 3)
            } else {
                bigStar8.isVisible = true
                smallStar81.isVisible = true
                editor.putInt("prevStars18", 2)
            }
        } else if (stars18 == 1){
            if (prevStars18 == 2){
                bigStar8.isVisible = true
                smallStar81.isVisible = true
                editor.putInt("prevStars18", 2)
            } else if (prevStars18 == 3){
                bigStar8.isVisible = true
                smallStar81.isVisible = true
                smallStar82.isVisible = true
                editor.putInt("prevStars18", 3)
            } else {
                bigStar8.isVisible = true
                editor.putInt("prevStars18", 1)
            }
        }

        if (stars19 == 3){
            bigStar9.isVisible = true
            smallStar91.isVisible = true
            smallStar92.isVisible = true
            editor.putInt("prevStars19", 3)
        } else if (stars19 == 2){
            if (prevStars19 == 3){
                bigStar9.isVisible = true
                smallStar91.isVisible = true
                smallStar92.isVisible = true
                editor.putInt("prevStars19", 3)
            } else {
                bigStar9.isVisible = true
                smallStar91.isVisible = true
                editor.putInt("prevStars19", 2)
            }
        } else if (stars19 == 1){
            if (prevStars19 == 2){
                bigStar9.isVisible = true
                smallStar91.isVisible = true
                editor.putInt("prevStars19", 2)
            } else if (prevStars19 == 3){
                bigStar9.isVisible = true
                smallStar91.isVisible = true
                smallStar92.isVisible = true
                editor.putInt("prevStars19", 3)
            } else {
                bigStar9.isVisible = true
                editor.putInt("prevStars19", 1)
            }
        }

        if (stars110 == 3){
            bigStar10.isVisible = true
            smallStar101.isVisible = true
            smallStar102.isVisible = true
            editor.putInt("prevStars110", 3)
        } else if (stars110 == 2){
            if (prevStars110 == 3){
                bigStar10.isVisible = true
                smallStar101.isVisible = true
                smallStar102.isVisible = true
                editor.putInt("prevStars110", 3)
            } else {
                bigStar10.isVisible = true
                smallStar101.isVisible = true
                editor.putInt("prevStars110", 2)
            }
        } else if (stars110 == 1){
            if (prevStars110 == 2){
                bigStar10.isVisible = true
                smallStar101.isVisible = true
                editor.putInt("prevStars110", 2)
            } else if (prevStars110 == 3){
                bigStar10.isVisible = true
                smallStar101.isVisible = true
                smallStar102.isVisible = true
                editor.putInt("prevStars110", 3)
            } else {
                bigStar10.isVisible = true
                editor.putInt("prevStars110", 1)
            }
        }






        backtoep.setOnClickListener {
            val intent = Intent(this, Episode::class.java)
            startActivity(intent)
        }
        val homeButton = findViewById<ImageButton>(R.id.homeButton)
        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        stage1.setOnClickListener {
            val intent = Intent(this, Ep1stage1::class.java)
            startActivity(intent)
        }


        stage2.isEnabled = stage11Cleared
        if (stage2.isEnabled){
            stage2.setBackgroundResource(R.drawable.component_1__1_)
        }
        stage2.setOnClickListener(){
            val intent = Intent(this, Ep1Stage2::class.java)
            startActivity(intent)
        }

        stage3.isEnabled = stage12Cleared
        if (stage3.isEnabled){
            stage3.setBackgroundResource(R.drawable.component_1__1_)
        }
        stage3.setOnClickListener(){
            val intent = Intent(this, Ep1Stage3::class.java)
            startActivity(intent)
        }

        stage4.isEnabled = stage13Cleared
        if (stage4.isEnabled){
            stage4.setBackgroundResource(R.drawable.component_1__1_)
        }
        stage4.setOnClickListener(){
            val intent = Intent(this, Ep1Stage4::class.java)
            startActivity(intent)
        }

        stage5.isEnabled = stage14Cleared
        if (stage5.isEnabled){
            stage5.setBackgroundResource(R.drawable.component_1__1_)
        }
        stage5.setOnClickListener(){
            val intent = Intent(this, Ep1Stage5::class.java)
            startActivity(intent)
        }

        stage6.isEnabled = stage15Cleared
        if (stage6.isEnabled){
            stage6.setBackgroundResource(R.drawable.component_1__1_)
        }
        stage6.setOnClickListener(){
            val intent = Intent(this, Ep1Stage6::class.java)
            startActivity(intent)
        }

        stage7.isEnabled = stage16Cleared
        if (stage7.isEnabled){
            stage7.setBackgroundResource(R.drawable.component_1__1_)
        }
        stage7.setOnClickListener(){
            val intent = Intent(this, Ep1Stage7::class.java)
            startActivity(intent)
        }

        stage8.isEnabled = stage17Cleared
        if (stage8.isEnabled){
            stage8.setBackgroundResource(R.drawable.component_1__1_)
        }
        stage8.setOnClickListener(){
            val intent = Intent(this, Ep1Stage8::class.java)
            startActivity(intent)
        }

        stage9.isEnabled = stage18Cleared
        if (stage9.isEnabled){
            stage9.setBackgroundResource(R.drawable.component_1__1_)
        }
        stage9.setOnClickListener(){
            val intent = Intent(this, Ep1Stage9::class.java)
            startActivity(intent)
        }

        stage10.isEnabled = stage19Cleared
        if (stage10.isEnabled){
            stage10.setBackgroundResource(R.drawable.component_1__1_)
        }
        stage10.setOnClickListener(){
            val intent = Intent(this, Ep1Stage10::class.java)
            startActivity(intent)
        }

        editor.apply()





    }
    override fun onBackPressed() {
        // do nothing
    }
}