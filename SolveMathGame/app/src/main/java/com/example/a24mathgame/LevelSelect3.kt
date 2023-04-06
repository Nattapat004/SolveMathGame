package com.example.a24mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.view.isVisible

class LevelSelect3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_select3)

        val backtoep = findViewById<ImageButton>(R.id.backtoep3)
        val shared = application as SharedVar
        val stage21 = findViewById<Button>(R.id.stage21)
        val stage22 = findViewById<Button>(R.id.stage22)
        val stage23 = findViewById<Button>(R.id.stage23)
        val stage24 = findViewById<Button>(R.id.stage24)
        val stage25 = findViewById<Button>(R.id.stage25)
        val stage26 = findViewById<Button>(R.id.stage26)
        val stage27 = findViewById<Button>(R.id.stage27)
        val stage28 = findViewById<Button>(R.id.stage28)
        val stage29 = findViewById<Button>(R.id.stage29)
        val stage30 = findViewById<Button>(R.id.stage30)
        val bigStar1 = findViewById<ImageView>(R.id.bStar21)
        val bigStar2 = findViewById<ImageView>(R.id.bStar22)
        val bigStar3 = findViewById<ImageView>(R.id.bStar23)
        val bigStar4 = findViewById<ImageView>(R.id.bStar24)
        val bigStar5 = findViewById<ImageView>(R.id.bStar25)
        val bigStar6 = findViewById<ImageView>(R.id.bStar26)
        val bigStar7 = findViewById<ImageView>(R.id.bStar27)
        val bigStar8 = findViewById<ImageView>(R.id.bStar28)
        val bigStar9 = findViewById<ImageView>(R.id.bStar29)
        val bigStar10 = findViewById<ImageView>(R.id.bStar30)
        val smallStar11 = findViewById<ImageView>(R.id.star211)
        val smallStar12 = findViewById<ImageView>(R.id.star212)
        val smallStar21 = findViewById<ImageView>(R.id.star221)
        val smallStar22 = findViewById<ImageView>(R.id.star222)
        val smallStar31 = findViewById<ImageView>(R.id.star231)
        val smallStar32 = findViewById<ImageView>(R.id.star232)
        val smallStar41 = findViewById<ImageView>(R.id.star241)
        val smallStar42 = findViewById<ImageView>(R.id.star242)
        val smallStar51 = findViewById<ImageView>(R.id.star251)
        val smallStar52 = findViewById<ImageView>(R.id.star252)
        val smallStar61 = findViewById<ImageView>(R.id.star261)
        val smallStar62 = findViewById<ImageView>(R.id.star262)
        val smallStar71 = findViewById<ImageView>(R.id.star271)
        val smallStar72 = findViewById<ImageView>(R.id.star272)
        val smallStar81 = findViewById<ImageView>(R.id.star281)
        val smallStar82 = findViewById<ImageView>(R.id.star282)
        val smallStar91 = findViewById<ImageView>(R.id.star291)
        val smallStar92 = findViewById<ImageView>(R.id.star292)
        val smallStar101 = findViewById<ImageView>(R.id.star301)
        val smallStar102 = findViewById<ImageView>(R.id.star302)
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


        if (shared.stars31 == 3){
            bigStar1.isVisible = true
            smallStar11.isVisible = true
            smallStar12.isVisible = true
            shared.prevStars31 = 3
        } else if (shared.stars31 == 2){
            if (shared.prevStars31 == 3){
                bigStar1.isVisible = true
                smallStar11.isVisible = true
                smallStar12.isVisible = true
                shared.prevStars31 = 3
            } else {
                bigStar1.isVisible = true
                smallStar11.isVisible = true
                shared.prevStars31 = 2
            }
        } else if (shared.stars31 == 1){
            if (shared.prevStars31 == 2){
                bigStar1.isVisible = true
                smallStar11.isVisible = true
                shared.prevStars31 = 2
            } else if (shared.prevStars31 == 3){
                bigStar1.isVisible = true
                smallStar11.isVisible = true
                smallStar12.isVisible = true
                shared.prevStars31 = 3
            } else {
                bigStar1.isVisible = true
                shared.prevStars31 = 1
            }
        }


        if (shared.stars32 == 3){
            bigStar2.isVisible = true
            smallStar21.isVisible = true
            smallStar22.isVisible = true
            shared.prevStars32 = 3
        } else if (shared.stars32 == 2){
            if (shared.prevStars32 == 3) {
                bigStar2.isVisible = true
                smallStar21.isVisible = true
                smallStar22.isVisible = true
                shared.prevStars32 = 3
            } else {
                bigStar2.isVisible = true
                smallStar21.isVisible = true
                shared.prevStars32 = 2
            }
        } else if (shared.stars32 == 1){
            if (shared.prevStars32 == 2){
                bigStar2.isVisible = true
                smallStar21.isVisible = true
                shared.prevStars32 = 2
            } else if (shared.prevStars32 == 3){
                bigStar2.isVisible = true
                smallStar21.isVisible = true
                smallStar22.isVisible = true
                shared.prevStars32 = 3
            } else {
                bigStar2.isVisible = true
                shared.prevStars32 = 1
            }
        }

        if (shared.stars33 == 3){
            bigStar3.isVisible = true
            smallStar31.isVisible = true
            smallStar32.isVisible = true
            shared.prevStars33 = 3
        } else if (shared.stars33 == 2){
            if (shared.prevStars33 == 3) {
                bigStar3.isVisible = true
                smallStar31.isVisible = true
                smallStar32.isVisible = true
                shared.prevStars33 = 3
            } else {
                bigStar3.isVisible = true
                smallStar31.isVisible = true
                shared.prevStars33 = 2
            }
        } else if (shared.stars33 == 1){
            if (shared.prevStars33 == 3){
                bigStar3.isVisible = true
                smallStar31.isVisible = true
                smallStar32.isVisible = true
                shared.prevStars33 = 3
            } else if (shared.prevStars33 == 2){
                bigStar3.isVisible = true
                smallStar31.isVisible = true
                shared.prevStars33 = 2
            } else {
                bigStar3.isVisible = true
                shared.prevStars33 = 1
            }
        }

        if (shared.stars34 == 3){
            bigStar4.isVisible = true
            smallStar41.isVisible = true
            smallStar42.isVisible = true
            shared.prevStars34 = 3
        } else if (shared.stars34 == 2){
            if (shared.prevStars34 == 3) {
                bigStar4.isVisible = true
                smallStar41.isVisible = true
                smallStar42.isVisible = true
                shared.prevStars34 = 3

            } else {
                bigStar4.isVisible = true
                smallStar41.isVisible = true
                shared.prevStars34 = 2
            }
        } else if (shared.stars34 == 1){
            if (shared.prevStars34 == 3){
                bigStar4.isVisible = true
                smallStar41.isVisible = true
                smallStar42.isVisible = true
                shared.prevStars34 = 3
            } else if (shared.prevStars34 == 2){
                bigStar4.isVisible = true
                smallStar41.isVisible = true
                shared.prevStars34 = 2
            } else {
                bigStar4.isVisible = true
                shared.prevStars34 = 1
            }
        }

        if (shared.stars35 == 3){
            bigStar5.isVisible = true
            smallStar51.isVisible = true
            smallStar52.isVisible = true
            shared.prevStars35 = 3
        } else if (shared.stars35 == 2){
            if (shared.prevStars35 == 3) {
                bigStar5.isVisible = true
                smallStar51.isVisible = true
                smallStar52.isVisible = true
                shared.prevStars35 = 3
            } else {
                bigStar5.isVisible = true
                smallStar51.isVisible = true
                shared.prevStars35 = 2
            }
        } else if (shared.stars35 == 1){
            if (shared.prevStars35 == 3){
                bigStar5.isVisible = true
                smallStar51.isVisible = true
                smallStar52.isVisible = true
                shared.prevStars35 = 3

            } else if (shared.prevStars35 == 2){
                bigStar5.isVisible = true
                smallStar51.isVisible = true
                shared.prevStars35 = 2
            } else {
                bigStar5.isVisible = true
                shared.prevStars35 = 1
            }
        }

        if (shared.stars36 == 3){
            bigStar6.isVisible = true
            smallStar61.isVisible = true
            smallStar62.isVisible = true
            shared.prevStars36 = 3
        } else if (shared.stars36 == 2){
            if (shared.prevStars36 == 3) {
                bigStar6.isVisible = true
                smallStar61.isVisible = true
                smallStar62.isVisible = true
                shared.prevStars36 = 3
            } else {
                bigStar6.isVisible = true
                smallStar61.isVisible = true
                shared.prevStars36 = 2
            }
        } else if (shared.stars36 == 1){
            if (shared.prevStars36 == 3){
                bigStar6.isVisible = true
                smallStar61.isVisible = true
                smallStar62.isVisible = true
                shared.prevStars36 = 3
            } else if (shared.prevStars36 == 2){
                bigStar6.isVisible = true
                smallStar61.isVisible = true
                shared.prevStars36 = 2
            } else {
                bigStar6.isVisible = true
                shared.prevStars36 = 1
            }
        }

        if (shared.stars37 == 3){
            bigStar7.isVisible = true
            smallStar71.isVisible = true
            smallStar72.isVisible = true
            shared.prevStars37 = 3
        } else if (shared.stars37 == 2){
            if (shared.prevStars37 == 3) {
                bigStar7.isVisible = true
                smallStar71.isVisible = true
                smallStar72.isVisible = true
                shared.prevStars37 = 3
            } else {
                bigStar7.isVisible = true
                smallStar71.isVisible = true
                shared.prevStars37 = 2
            }
        } else if (shared.stars37 == 1){
            if (shared.prevStars37 == 3){
                bigStar7.isVisible = true
                smallStar71.isVisible = true
                smallStar72.isVisible = true
                shared.prevStars37 = 3
            } else if (shared.prevStars37 == 2){
                bigStar7.isVisible = true
                smallStar71.isVisible = true
                shared.prevStars37 = 2
            } else {
                bigStar7.isVisible = true
                shared.prevStars37 = 1
            }
        }

        if (shared.stars38 == 3){
            bigStar8.isVisible = true
            smallStar81.isVisible = true
            smallStar82.isVisible = true
            shared.prevStars38 = 3
        } else if (shared.stars38 == 2){
            if (shared.prevStars38 == 3) {
                bigStar8.isVisible = true
                smallStar81.isVisible = true
                smallStar82.isVisible = true
                shared.prevStars38 = 3
            } else {
                bigStar8.isVisible = true
                smallStar81.isVisible = true
                shared.prevStars38 = 2
            }
        } else if (shared.stars38 == 1){
            if (shared.prevStars38 == 3){
                bigStar8.isVisible = true
                smallStar81.isVisible = true
                smallStar82.isVisible = true
                shared.prevStars38 = 3

            } else if (shared.prevStars38 == 2){
                bigStar8.isVisible = true
                smallStar81.isVisible = true
                shared.prevStars38 = 2
            } else {
                bigStar8.isVisible = true
                shared.prevStars38 = 1
            }
        }

        if (shared.stars39 == 3){
            bigStar9.isVisible = true
            smallStar91.isVisible = true
            smallStar92.isVisible = true
            shared.prevStars39 = 3
        } else if (shared.stars39 == 2){
            if (shared.prevStars39 == 3) {
                bigStar9.isVisible = true
                smallStar91.isVisible = true
                smallStar92.isVisible = true
                shared.prevStars39 = 3
            } else {
                bigStar9.isVisible = true
                smallStar91.isVisible = true
                shared.prevStars39 = 2
            }
        } else if (shared.stars39 == 1){
            if (shared.prevStars39 == 3){
                bigStar9.isVisible = true
                smallStar91.isVisible = true
                smallStar92.isVisible = true
                shared.prevStars39 = 3
            } else if (shared.prevStars39 == 2){
                bigStar9.isVisible = true
                smallStar91.isVisible = true
                shared.prevStars39 = 2
            } else {
                bigStar9.isVisible = true
                shared.prevStars39 = 1
            }
        }

        if (shared.stars310 == 3){
            bigStar10.isVisible = true
            smallStar101.isVisible = true
            smallStar102.isVisible = true
            shared.prevStars310 = 3
        } else if (shared.stars310 == 2){
            if (shared.prevStars310 == 3) {
                bigStar10.isVisible = true
                smallStar101.isVisible = true
                smallStar102.isVisible = true
                shared.prevStars310 = 3

            } else {
                bigStar10.isVisible = true
                smallStar101.isVisible = true
                shared.prevStars310 = 2
            }
        } else if (shared.stars310 == 1){
            if (shared.prevStars310 == 3){
                bigStar10.isVisible = true
                smallStar101.isVisible = true
                smallStar102.isVisible = true
                shared.prevStars310 = 3
            } else if (shared.prevStars310 == 2){
                bigStar10.isVisible = true
                smallStar101.isVisible = true
                shared.prevStars310 = 2
            } else {
                bigStar10.isVisible = true
                shared.prevStars310 = 1
            }
        }






        backtoep.setOnClickListener {
            val intent = Intent(this, Episode::class.java)
            startActivity(intent)
        }
        val homeButton = findViewById<ImageButton>(R.id.homeButton3)
        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        stage21.isEnabled = shared.stage210Cleared
        if (stage21.isEnabled){
            stage21.setBackgroundResource(R.drawable.ellipse_1__2_)
        }
        stage21.setOnClickListener(){
            val intent = Intent(this, Ep3Stage1::class.java)
            startActivity(intent)
        }


        stage22.isEnabled = shared.stage31Cleared
        if (stage22.isEnabled){
            stage22.setBackgroundResource(R.drawable.ellipse_1__2_)
        }
        stage22.setOnClickListener(){
            val intent = Intent(this, Ep3Stage2::class.java)
            startActivity(intent)
        }

        stage23.isEnabled = shared.stage32Cleared
        if (stage23.isEnabled){
            stage23.setBackgroundResource(R.drawable.ellipse_1__2_)
        }
        stage23.setOnClickListener(){
            val intent = Intent(this, Ep3Stage3::class.java)
            startActivity(intent)
        }

        stage24.isEnabled = shared.stage33Cleared
        if (stage24.isEnabled){
            stage24.setBackgroundResource(R.drawable.ellipse_1__2_)
        }
        stage24.setOnClickListener(){
            val intent = Intent(this, Ep3Stage4::class.java)
            startActivity(intent)
        }

        stage25.isEnabled = shared.stage34Cleared
        if (stage25.isEnabled){
            stage25.setBackgroundResource(R.drawable.ellipse_1__2_)
        }
        stage25.setOnClickListener(){
            val intent = Intent(this, Ep3Stage5::class.java)
            startActivity(intent)
        }

        stage26.isEnabled = shared.stage35Cleared
        if (stage26.isEnabled){
            stage26.setBackgroundResource(R.drawable.ellipse_1__2_)
        }
        stage26.setOnClickListener(){
            val intent = Intent(this, Ep3Stage6::class.java)
            startActivity(intent)
        }

        stage27.isEnabled = shared.stage36Cleared
        if (stage27.isEnabled){
            stage27.setBackgroundResource(R.drawable.ellipse_1__2_)
        }
        stage27.setOnClickListener(){
            val intent = Intent(this, Ep3Stage7::class.java)
            startActivity(intent)
        }

        stage28.isEnabled = shared.stage37Cleared
        if (stage28.isEnabled){
            stage28.setBackgroundResource(R.drawable.ellipse_1__2_)
        }
        stage28.setOnClickListener(){
            val intent = Intent(this, Ep3Stage8::class.java)
            startActivity(intent)
        }

        stage29.isEnabled = shared.stage38Cleared
        if (stage29.isEnabled){
            stage29.setBackgroundResource(R.drawable.ellipse_1__2_)
        }
        stage29.setOnClickListener(){
            val intent = Intent(this, Ep3Stage9::class.java)
            startActivity(intent)
        }

        stage30.isEnabled = shared.stage39Cleared
        if (stage30.isEnabled){
            stage30.setBackgroundResource(R.drawable.ellipse_1__2_)
        }
        stage30.setOnClickListener(){
            val intent = Intent(this, Ep3Stage10::class.java)
            startActivity(intent)
        }
    }
}