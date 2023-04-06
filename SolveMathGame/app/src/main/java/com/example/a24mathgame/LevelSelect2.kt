package com.example.a24mathgame

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.view.isVisible

class LevelSelect2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_select2)

        val sharedPreferences = applicationContext.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        var stars21 = sharedPreferences.getInt("stars21", 0)
        var prevStars21 = sharedPreferences.getInt("prevStars21", 0)
        var stage21Cleared = sharedPreferences.getBoolean("stage21Cleared", false)
        var stars22 = sharedPreferences.getInt("stars22", 0)
        var prevStars22 = sharedPreferences.getInt("prevStars22", 0)
        var stage22Cleared = sharedPreferences.getBoolean("stage22Cleared", false)
        var stars23 = sharedPreferences.getInt("stars23", 0)
        var prevStars23 = sharedPreferences.getInt("prevStars23", 0)
        var stage23Cleared = sharedPreferences.getBoolean("stage23Cleared", false)
        var stars24 = sharedPreferences.getInt("stars24", 0)
        var prevStars24 = sharedPreferences.getInt("prevStars24", 0)
        var stage24Cleared = sharedPreferences.getBoolean("stage24Cleared", false)
        var stars25 = sharedPreferences.getInt("stars25", 0)
        var prevStars25 = sharedPreferences.getInt("prevStars25", 0)
        var stage25Cleared = sharedPreferences.getBoolean("stage25Cleared", false)
        var stars26 = sharedPreferences.getInt("stars26", 0)
        var prevStars26 = sharedPreferences.getInt("prevStars26", 0)
        var stage26Cleared = sharedPreferences.getBoolean("stage26Cleared", false)
        var stars27 = sharedPreferences.getInt("stars27", 0)
        var prevStars27 = sharedPreferences.getInt("prevStars27", 0)
        var stage27Cleared = sharedPreferences.getBoolean("stage27Cleared", false)
        var stars28 = sharedPreferences.getInt("stars28", 0)
        var prevStars28 = sharedPreferences.getInt("prevStars28", 0)
        var stage28Cleared = sharedPreferences.getBoolean("stage28Cleared", false)
        var stars29 = sharedPreferences.getInt("stars29", 0)
        var prevStars29 = sharedPreferences.getInt("prevStars29", 0)
        var stage29Cleared = sharedPreferences.getBoolean("stage29Cleared", false)
        var stars210 = sharedPreferences.getInt("stars210", 0)
        var prevStars210 = sharedPreferences.getInt("prevStars210", 0)
        var stage110Cleared = sharedPreferences.getBoolean("stage110Cleared", false)
        val backtoep = findViewById<ImageButton>(R.id.backtoep2)
        val shared = application as SharedVar
        val stage11 = findViewById<Button>(R.id.stage11)
        val stage12 = findViewById<Button>(R.id.stage12)
        val stage13 = findViewById<Button>(R.id.stage13)
        val stage14 = findViewById<Button>(R.id.stage14)
        val stage15 = findViewById<Button>(R.id.stage15)
        val stage16 = findViewById<Button>(R.id.stage16)
        val stage17 = findViewById<Button>(R.id.stage17)
        val stage18 = findViewById<Button>(R.id.stage18)
        val stage19 = findViewById<Button>(R.id.stage19)
        val stage20 = findViewById<Button>(R.id.stage20)
        val bigStar1 = findViewById<ImageView>(R.id.bStar11)
        val bigStar2 = findViewById<ImageView>(R.id.bStar12)
        val bigStar3 = findViewById<ImageView>(R.id.bStar13)
        val bigStar4 = findViewById<ImageView>(R.id.bStar14)
        val bigStar5 = findViewById<ImageView>(R.id.bStar15)
        val bigStar6 = findViewById<ImageView>(R.id.bStar16)
        val bigStar7 = findViewById<ImageView>(R.id.bStar17)
        val bigStar8 = findViewById<ImageView>(R.id.bStar18)
        val bigStar9 = findViewById<ImageView>(R.id.bStar19)
        val bigStar10 = findViewById<ImageView>(R.id.bStar20)
        val smallStar11 = findViewById<ImageView>(R.id.star111)
        val smallStar12 = findViewById<ImageView>(R.id.star112)
        val smallStar21 = findViewById<ImageView>(R.id.star121)
        val smallStar22 = findViewById<ImageView>(R.id.star122)
        val smallStar31 = findViewById<ImageView>(R.id.star131)
        val smallStar32 = findViewById<ImageView>(R.id.star132)
        val smallStar41 = findViewById<ImageView>(R.id.star141)
        val smallStar42 = findViewById<ImageView>(R.id.star142)
        val smallStar51 = findViewById<ImageView>(R.id.star151)
        val smallStar52 = findViewById<ImageView>(R.id.star152)
        val smallStar61 = findViewById<ImageView>(R.id.star161)
        val smallStar62 = findViewById<ImageView>(R.id.star162)
        val smallStar71 = findViewById<ImageView>(R.id.star171)
        val smallStar72 = findViewById<ImageView>(R.id.star172)
        val smallStar81 = findViewById<ImageView>(R.id.star181)
        val smallStar82 = findViewById<ImageView>(R.id.star182)
        val smallStar91 = findViewById<ImageView>(R.id.star191)
        val smallStar92 = findViewById<ImageView>(R.id.star192)
        val smallStar101 = findViewById<ImageView>(R.id.star201)
        val smallStar102 = findViewById<ImageView>(R.id.star202)
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


        if (stars21 == 3){
            bigStar1.isVisible = true
            smallStar11.isVisible = true
            smallStar12.isVisible = true
            editor.putInt("prevStars21", 3)
        } else if (stars21 == 2){
            if (prevStars21 == 3){
                bigStar1.isVisible = true
                smallStar11.isVisible = true
                smallStar12.isVisible = true
                editor.putInt("prevStars21", 3)
            } else {
                bigStar1.isVisible = true
                smallStar11.isVisible = true
                editor.putInt("prevStars21", 2)
            }
        } else if (stars21 == 1){
            if (prevStars21 == 2){
                bigStar1.isVisible = true
                smallStar11.isVisible = true
                editor.putInt("prevStars21", 2)
            } else if (prevStars21 == 3){
                bigStar1.isVisible = true
                smallStar11.isVisible = true
                smallStar12.isVisible = true
                editor.putInt("prevStars21", 3)
            } else {
                bigStar1.isVisible = true
                editor.putInt("prevStars21", 1)
            }
        }


        if (stars22 == 3){
            bigStar2.isVisible = true
            smallStar21.isVisible = true
            smallStar22.isVisible = true
            editor.putInt("prevStars22", 3)
        } else if (stars22 == 2){
            if (prevStars22 == 3){
                bigStar2.isVisible = true
                smallStar21.isVisible = true
                smallStar22.isVisible = true
                editor.putInt("prevStars22", 3)
            } else {
                bigStar2.isVisible = true
                smallStar21.isVisible = true
                editor.putInt("prevStars22", 2)
            }
        } else if (stars22 == 1){
            if (prevStars22 == 2){
                bigStar2.isVisible = true
                smallStar21.isVisible = true
                editor.putInt("prevStars22", 2)
            } else if (prevStars22 == 3){
                bigStar2.isVisible = true
                smallStar21.isVisible = true
                smallStar22.isVisible = true
                editor.putInt("prevStars22", 3)
            } else {
                bigStar2.isVisible = true
                editor.putInt("prevStars22", 1)
            }
        }

        if (stars23 == 3){
            bigStar3.isVisible = true
            smallStar31.isVisible = true
            smallStar32.isVisible = true
            editor.putInt("prevStars23", 3)
        } else if (stars23 == 2){
            if (prevStars23 == 3){
                bigStar3.isVisible = true
                smallStar31.isVisible = true
                smallStar32.isVisible = true
                editor.putInt("prevStars23", 3)
            } else {
                bigStar3.isVisible = true
                smallStar31.isVisible = true
                editor.putInt("prevStars23", 2)
            }
        } else if (stars23 == 1){
            if (prevStars23 == 2){
                bigStar3.isVisible = true
                smallStar31.isVisible = true
                editor.putInt("prevStars23", 2)
            } else if (prevStars23 == 3){
                bigStar3.isVisible = true
                smallStar31.isVisible = true
                smallStar32.isVisible = true
                editor.putInt("prevStars23", 3)
            } else {
                bigStar3.isVisible = true
                editor.putInt("prevStars23", 1)
            }
        }

        if (stars24 == 3){
            bigStar4.isVisible = true
            smallStar41.isVisible = true
            smallStar42.isVisible = true
            editor.putInt("prevStars24", 3)
        } else if (stars24 == 2){
            if (prevStars24 == 3){
                bigStar4.isVisible = true
                smallStar41.isVisible = true
                smallStar42.isVisible = true
                editor.putInt("prevStars24", 3)
            } else {
                bigStar4.isVisible = true
                smallStar41.isVisible = true
                editor.putInt("prevStars24", 2)
            }
        } else if (stars24 == 1){
            if (prevStars24 == 2){
                bigStar4.isVisible = true
                smallStar41.isVisible = true
                editor.putInt("prevStars24", 2)
            } else if (prevStars24 == 3){
                bigStar4.isVisible = true
                smallStar41.isVisible = true
                smallStar42.isVisible = true
                editor.putInt("prevStars24", 3)
            } else {
                bigStar1.isVisible = true
                editor.putInt("prevStars24", 1)
            }
        }

        if (stars25 == 3){
            bigStar5.isVisible = true
            smallStar51.isVisible = true
            smallStar52.isVisible = true
            editor.putInt("prevStars25", 3)
        } else if (stars25 == 2){
            if (prevStars25 == 3){
                bigStar5.isVisible = true
                smallStar51.isVisible = true
                smallStar52.isVisible = true
                editor.putInt("prevStars25", 3)
            } else {
                bigStar5.isVisible = true
                smallStar51.isVisible = true
                editor.putInt("prevStars25", 2)
            }
        } else if (stars25 == 1){
            if (prevStars25 == 2){
                bigStar5.isVisible = true
                smallStar51.isVisible = true
                editor.putInt("prevStars25", 2)
            } else if (prevStars25 == 3){
                bigStar5.isVisible = true
                smallStar51.isVisible = true
                smallStar52.isVisible = true
                editor.putInt("prevStars25", 3)
            } else {
                bigStar5.isVisible = true
                editor.putInt("prevStars25", 1)
            }
        }

        if (stars26 == 3){
            bigStar6.isVisible = true
            smallStar61.isVisible = true
            smallStar62.isVisible = true
            editor.putInt("prevStars26", 3)
        } else if (stars26 == 2){
            if (prevStars26 == 3){
                bigStar6.isVisible = true
                smallStar61.isVisible = true
                smallStar62.isVisible = true
                editor.putInt("prevStars26", 3)
            } else {
                bigStar6.isVisible = true
                smallStar61.isVisible = true
                editor.putInt("prevStars26", 2)
            }
        } else if (stars26 == 1){
            if (prevStars26 == 2){
                bigStar6.isVisible = true
                smallStar61.isVisible = true
                editor.putInt("prevStars26", 2)
            } else if (prevStars26 == 3){
                bigStar1.isVisible = true
                smallStar61.isVisible = true
                smallStar62.isVisible = true
                editor.putInt("prevStars26", 3)
            } else {
                bigStar6.isVisible = true
                editor.putInt("prevStars26", 1)
            }
        }

        if (stars27 == 3){
            bigStar7.isVisible = true
            smallStar71.isVisible = true
            smallStar72.isVisible = true
            editor.putInt("prevStars27", 3)
        } else if (stars27 == 2){
            if (prevStars27 == 3){
                bigStar7.isVisible = true
                smallStar71.isVisible = true
                smallStar72.isVisible = true
                editor.putInt("prevStars27", 3)
            } else {
                bigStar7.isVisible = true
                smallStar71.isVisible = true
                editor.putInt("prevStars27", 2)
            }
        } else if (stars27 == 1){
            if (prevStars27 == 2){
                bigStar7.isVisible = true
                smallStar71.isVisible = true
                editor.putInt("prevStars27", 2)
            } else if (prevStars27 == 3){
                bigStar7.isVisible = true
                smallStar71.isVisible = true
                smallStar72.isVisible = true
                editor.putInt("prevStars27", 3)
            } else {
                bigStar7.isVisible = true
                editor.putInt("prevStars27", 1)
            }
        }

        if (stars28 == 3){
            bigStar8.isVisible = true
            smallStar81.isVisible = true
            smallStar82.isVisible = true
            editor.putInt("prevStars28", 3)
        } else if (stars28 == 2){
            if (prevStars28 == 3){
                bigStar8.isVisible = true
                smallStar81.isVisible = true
                smallStar82.isVisible = true
                editor.putInt("prevStars28", 3)
            } else {
                bigStar8.isVisible = true
                smallStar81.isVisible = true
                editor.putInt("prevStars28", 2)
            }
        } else if (stars28 == 1){
            if (prevStars28 == 2){
                bigStar8.isVisible = true
                smallStar81.isVisible = true
                editor.putInt("prevStars28", 2)
            } else if (prevStars28 == 3){
                bigStar8.isVisible = true
                smallStar81.isVisible = true
                smallStar82.isVisible = true
                editor.putInt("prevStars28", 3)
            } else {
                bigStar8.isVisible = true
                editor.putInt("prevStars28", 1)
            }
        }

        if (stars29 == 3){
            bigStar9.isVisible = true
            smallStar91.isVisible = true
            smallStar92.isVisible = true
            editor.putInt("prevStars29", 3)
        } else if (stars29 == 2){
            if (prevStars29 == 3){
                bigStar9.isVisible = true
                smallStar91.isVisible = true
                smallStar92.isVisible = true
                editor.putInt("prevStars29", 3)
            } else {
                bigStar9.isVisible = true
                smallStar91.isVisible = true
                editor.putInt("prevStars29", 2)
            }
        } else if (stars29 == 1){
            if (prevStars29 == 2){
                bigStar9.isVisible = true
                smallStar91.isVisible = true
                editor.putInt("prevStars29", 2)
            } else if (prevStars29 == 3){
                bigStar9.isVisible = true
                smallStar91.isVisible = true
                smallStar92.isVisible = true
                editor.putInt("prevStars29", 3)
            } else {
                bigStar9.isVisible = true
                editor.putInt("prevStars29", 1)
            }
        }

        if (stars210 == 3){
            bigStar10.isVisible = true
            smallStar101.isVisible = true
            smallStar102.isVisible = true
            editor.putInt("prevStars210", 3)
        } else if (stars210 == 2){
            if (prevStars210 == 3){
                bigStar10.isVisible = true
                smallStar101.isVisible = true
                smallStar102.isVisible = true
                editor.putInt("prevStars210", 3)
            } else {
                bigStar10.isVisible = true
                smallStar101.isVisible = true
                editor.putInt("prevStars210", 2)
            }
        } else if (stars210 == 1){
            if (prevStars210 == 2){
                bigStar10.isVisible = true
                smallStar101.isVisible = true
                editor.putInt("prevStars210", 2)
            } else if (prevStars210 == 3){
                bigStar10.isVisible = true
                smallStar101.isVisible = true
                smallStar102.isVisible = true
                editor.putInt("prevStars210", 3)
            } else {
                bigStar10.isVisible = true
                editor.putInt("prevStars210", 1)
            }
        }






        backtoep.setOnClickListener {
            val intent = Intent(this, Episode::class.java)
            startActivity(intent)
        }
        val homeButton = findViewById<ImageButton>(R.id.homeButton2)
        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        stage11.isEnabled = stage110Cleared
        if (stage11.isEnabled){
            stage11.setBackgroundResource(R.drawable.ellipse_1__1_)
        }
        stage11.setOnClickListener(){
            val intent = Intent(this, Ep2Stage1::class.java)
            startActivity(intent)
        }


        stage12.isEnabled = stage21Cleared
        if (stage12.isEnabled){
            stage12.setBackgroundResource(R.drawable.ellipse_1__1_)
        }
        stage12.setOnClickListener(){
            val intent = Intent(this, Ep2Stage2::class.java)
            startActivity(intent)
        }

        stage13.isEnabled = stage22Cleared
        if (stage13.isEnabled){
            stage13.setBackgroundResource(R.drawable.ellipse_1__1_)
        }
        stage13.setOnClickListener(){
            val intent = Intent(this, Ep2Stage3::class.java)
            startActivity(intent)
        }

        stage14.isEnabled = stage23Cleared
        if (stage14.isEnabled){
            stage14.setBackgroundResource(R.drawable.ellipse_1__1_)
        }
        stage14.setOnClickListener(){
            val intent = Intent(this, Ep2Stage4::class.java)
            startActivity(intent)
        }

        stage15.isEnabled = stage24Cleared
        if (stage15.isEnabled){
            stage15.setBackgroundResource(R.drawable.ellipse_1__1_)
        }
        stage15.setOnClickListener(){
            val intent = Intent(this, Ep2Stage5::class.java)
            startActivity(intent)
        }

        stage16.isEnabled = stage25Cleared
        if (stage16.isEnabled){
            stage16.setBackgroundResource(R.drawable.ellipse_1__1_)
        }
        stage16.setOnClickListener(){
            val intent = Intent(this, Ep2Stage6::class.java)
            startActivity(intent)
        }

        stage17.isEnabled = stage26Cleared
        if (stage17.isEnabled){
            stage17.setBackgroundResource(R.drawable.ellipse_1__1_)
        }
        stage17.setOnClickListener(){
            val intent = Intent(this, Ep2Stage7::class.java)
            startActivity(intent)
        }

        stage18.isEnabled = stage27Cleared
        if (stage18.isEnabled){
            stage18.setBackgroundResource(R.drawable.ellipse_1__1_)
        }
        stage18.setOnClickListener(){
            val intent = Intent(this, Ep2Stage8::class.java)
            startActivity(intent)
        }

        stage19.isEnabled = stage28Cleared
        if (stage19.isEnabled){
            stage19.setBackgroundResource(R.drawable.ellipse_1__1_)
        }
        stage19.setOnClickListener(){
            val intent = Intent(this, Ep2Stage9::class.java)
            startActivity(intent)
        }

        stage20.isEnabled = stage29Cleared
        if (stage20.isEnabled){
            stage20.setBackgroundResource(R.drawable.ellipse_1__1_)
        }
        stage20.setOnClickListener(){
            val intent = Intent(this, Ep2Stage10::class.java)
            startActivity(intent)
        }

        editor.apply()
    }
    override fun onBackPressed() {
        // do nothing
    }
}