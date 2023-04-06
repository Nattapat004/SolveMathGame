package com.example.a24mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlin.math.pow
import kotlin.math.sqrt

class Ep3Stage7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ep3_stage7)

        val no1 = findViewById<Button>(R.id.no1)
        val no2 = findViewById<Button>(R.id.no2)
        val no3 = findViewById<Button>(R.id.no3)
        val no4 = findViewById<Button>(R.id.no4)
        val no5 = findViewById<Button>(R.id.no5)
        val plus = findViewById<ImageButton>(R.id.plus)
        val minus = findViewById<ImageButton>(R.id.minus)
        val multiply = findViewById<ImageButton>(R.id.multiply)
        val divide = findViewById<ImageButton>(R.id.divide)
        val sqrRoot = findViewById<ImageButton>(R.id.Root)
        val submit = findViewById<Button>(R.id.submitButton)
        val power = findViewById<ImageButton>(R.id.expo2)
        val home1_1 = findViewById<ImageButton>(R.id.home1_1)
        submit.isEnabled = false
        submit.text = 10.toString()
        var no1Clicked = false
        var no2Clicked = false
        var no3Clicked = false
        var no4Clicked = false
        var no5Clicked = false
        var sqrtClicked = false
        var result = 0.00
        var latestPressed = 0.00
        val calculationList = mutableListOf<Double>()
        val operatorList = mutableListOf<String>()
        val numSet = mutableListOf<Int>(1,2,3,4)
        var problem = numSet.random()
        var allDone = false
        var objective = 0.00
        var elapsedTime: Long = 0
        val handler = Handler()
        val runnable = object : Runnable {
            override fun run() {
                // Increment elapsed time by one second
                elapsedTime += 1000
                // Update UI with elapsed time
                val time: TextView = findViewById(R.id.time)
                time.text = "${elapsedTime / 1000} s."
                handler.postDelayed(this, 1000)
            }
        }
        handler.post(runnable)
        plus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol__8_ ))
        minus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol__2_))
        multiply.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol__3_ ))
        divide.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol__4_ ))
        sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol__5_ ))
        power.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol__6_ ))


        fun startOperators() {
            plus.isEnabled = false
            minus.isEnabled = false
            multiply.isEnabled = false
            divide.isEnabled = false
            sqrRoot.isEnabled = false
            power.isEnabled = false
        }


        fun enableOperators() {
            plus.isEnabled = true
            minus.isEnabled = true
            multiply.isEnabled = true
            divide.isEnabled = true
            sqrRoot.isEnabled = true
            power.isEnabled = true
        }

        fun disableOperators() {
            plus.isEnabled = false
            minus.isEnabled = false
            multiply.isEnabled = false
            divide.isEnabled = false
            sqrRoot.isEnabled = false
            power.isEnabled = false
        }

        fun no1Enabled() {
            no1.isEnabled = true

        }

        fun no2Enabled() {
            no2.isEnabled = true

        }

        fun no3Enabled() {
            no3.isEnabled = true

        }

        fun no4Enabled() {
            no4.isEnabled = true

        }

        fun no5Enabled(){
            no5.isEnabled = true
        }

        fun no1Disabled() {
            no1.isEnabled = false

        }

        fun no2Disabled() {
            no2.isEnabled = false

        }

        fun no3Disabled() {
            no3.isEnabled = false
        }

        fun no4Disabled() {
            no4.isEnabled = false
        }

        fun no5Disabled(){
            no5.isEnabled = false
        }


        fun operatorReady() {
            plus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol__8_ ))
            minus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol__2_))
            multiply.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol__3_ ))
            divide.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol__4_ ))
            sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol__5_ ))
            power.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol__6_ ))
        }

        fun operatorUnReady() {
            plus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.plusclicked))
            minus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.minusclicked))
            multiply.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.multiclicked))
            divide.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.divideclicked))
            if (!submit.isEnabled){
                sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.sqrtclicked))
            }
            power.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.expoclicked))
        }

        fun changeText(no0: Button) {
            no0.tag = result
            no0.text = String.format("%.2f", result)
            calculationList.clear()
            operatorList.clear()
            submit.tag = result
        }

        fun operatorNumSwitch() {
            if (latestPressed == 1.00) {
                no1Enabled()
                no2Disabled()
                no3Disabled()
                no4Disabled()
                no5Disabled()
            }

            if (latestPressed == 2.00) {
                no2Enabled()
                no1Disabled()
                no3Disabled()
                no4Disabled()
                no5Disabled()
            }

            if (latestPressed == 3.00) {
                no3Enabled()
                no1Disabled()
                no2Disabled()
                no4Disabled()
                no5Disabled()
            }

            if (latestPressed == 4.00) {
                no4Enabled()
                no1Disabled()
                no2Disabled()
                no3Disabled()
                no5Disabled()
            }

            if (latestPressed == 5.00) {
                no5Enabled()
                no2Disabled()
                no3Disabled()
                no4Disabled()
                no1Disabled()
            }
        }

        fun buttonSwitch() {
            if (!no1Clicked) {
                no1Enabled()
            } else {
                no1Disabled()
            }
            if (!no2Clicked) {
                no2Enabled()
            } else {
                no2Disabled()
            }
            if (!no3Clicked) {
                no3Enabled()
            } else {
                no3Disabled()
            }
            if (!no4Clicked) {
                no4Enabled()
            } else {
                no4Disabled()
            }
            if (!no5Clicked){
                no5Enabled()
            } else {
                no5Disabled()
            }
        }


        fun onNumberButtonClicked() {
            if (no1Clicked and no2Clicked and no3Clicked and no4Clicked and no5Clicked) {
                submit.isEnabled = true
                allDone = true
                submit.setBackgroundResource(R.drawable.rectangle_4)
                plus.isEnabled = false
                minus.isEnabled = false
                multiply.isEnabled = false
                divide.isEnabled = false
                power.isEnabled = false
                operatorUnReady()
            }
        }

        fun submitResult() {
            submit.setOnClickListener() {
                submit.setBackgroundResource(R.drawable.ans)
                if (calculationList[0] == objective) {
                    val shared = applicationContext as SharedVar
                    shared.stage37Cleared = true
                    shared.stageCleared = 27
                    shared.timeElapsed = elapsedTime/1000
                    handler.removeCallbacks(runnable)
                    if (elapsedTime <= 150000){
                        val level1star = applicationContext as SharedVar
                        val intent = Intent(this, threeStarWin::class.java)
                        startActivity(intent)
                        level1star.stars37 = 3
                    } else if (elapsedTime <= 300000){
                        val level1star = applicationContext as SharedVar
                        val intent = Intent(this, twoStarWin::class.java)
                        startActivity(intent)
                        level1star.stars37 = 2
                    } else {
                        val level1star = applicationContext as SharedVar
                        val intent = Intent(this, oneStarWin::class.java)
                        startActivity(intent)
                        level1star.stars37 = 1
                    }
                } else {
                    val intent = Intent(this, Defeated::class.java)
                    startActivity(intent)
                    val stageLost = applicationContext as SharedVar
                    stageLost.stageLost = 27
                    handler.removeCallbacks(runnable)
                }
            }
        }

        fun performCalculation() {
            result = calculationList[0]
            for (i in 1 until calculationList.size) {
                when (operatorList[i - 1]) {
                    "+" -> result += calculationList[i]
                    "-" -> result -= calculationList[i]
                    "*" -> result *= calculationList[i]
                    "/" -> result /= calculationList[i]
                    "sqrt" -> result = sqrt(result)
                    "**" -> result = result.pow(calculationList[i])
                }
            }
        }



        fun initialize() {
            if (problem == 1) {
                no1.tag = 7.00
                no2.tag = 4.00
                no3.tag = 8.00
                no4.tag = 4.00
                no5.tag = 9.00
                objective = 108.00
                submit.tag = objective

            } else if (problem == 2){
                no1.tag = 2.00
                no2.tag = 4.00
                no3.tag = 7.00
                no4.tag = 7.00
                no5.tag = 1.00
                objective = 113.00
                submit.tag = objective
            } else if (problem == 3){
                no1.tag = 6.00
                no2.tag = 3.00
                no3.tag = 4.00
                no4.tag = 5.00
                no5.tag = 9.00
                objective = 126.00
                submit.tag = objective
            } else if (problem == 4){
                no1.tag = 3.00
                no2.tag = 5.00
                no3.tag = 6.00
                no4.tag = 4.00
                no5.tag = 8.00
                objective = 112.00
                submit.tag = objective
            }
            no1.text = no1.tag.toString()
            no2.text = no2.tag.toString()
            no3.text = no3.tag.toString()
            no4.text = no4.tag.toString()
            no5.text = no5.tag.toString()
            submit.text = submit.tag.toString()
            no1.setOnClickListener() {
                enableOperators()
                operatorReady()
                no2Disabled()
                no3Disabled()
                no4Disabled()
                no5Disabled()
                if (calculationList.size != 0) {
                    if ((calculationList[0] == no1.tag as Double) and (latestPressed == 1.00) and !sqrtClicked) {
                        no1.setBackgroundResource(R.drawable.number__8_)
                        calculationList.clear()
                        disableOperators()
                        if (!no2Clicked) {
                            no2Enabled()
                        }
                        if (!no3Clicked) {
                            no3Enabled()
                        }
                        if (!no4Clicked) {
                            no4Enabled()
                        }
                        if (!no5Clicked) {
                            no5Enabled()
                        }
                        no1Clicked = false
                        submit.isEnabled = false
                    }else {
                        calculationList.add(no1.tag as Double)
                        performCalculation()
                        changeText(no1)
                        disableOperators()
                        if (!no2Clicked) {
                            no2Enabled()
                        }
                        if (!no3Clicked) {
                            no3Enabled()
                        }
                        if (!no4Clicked) {
                            no4Enabled()
                        }
                        if (!no5Clicked) {
                            no5Enabled()
                        }
                        no1Clicked = false
                        if (sqrtClicked){
                            no1.setBackgroundResource(R.drawable.number__8_)
                        }
                        sqrtClicked = false
                        sqrRoot.isEnabled = false
                    }
                    if (allDone){
                        disableOperators()
                        sqrRoot.isEnabled = true
                    }

                } else if (calculationList.size == 0) {
                    no1.setBackgroundResource(R.drawable.number__9_)
                    calculationList.add(no1.tag as Double)
                    no1Clicked = true
                    onNumberButtonClicked()
                    submitResult()
                    if ((no1.tag as Double) < 0.00){
                        sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.sqrtclicked))
                    }
                    sqrRoot.isEnabled = (no1.tag as Double) >= 0.00
                }


                latestPressed = 1.00
            }
            no2.setOnClickListener() {
                enableOperators()
                operatorReady()
                no1Disabled()
                no3Disabled()
                no4Disabled()
                no5Disabled()
                if (calculationList.size != 0) {
                    if ((calculationList[0] == no2.tag as Double) and (latestPressed == 2.00) and !sqrtClicked) {
                        no2.setBackgroundResource(R.drawable.number__8_)
                        calculationList.clear()
                        disableOperators()
                        if (!no1Clicked) {
                            no1Enabled()
                        }
                        if (!no3Clicked) {
                            no3Enabled()
                        }
                        if (!no4Clicked) {
                            no4Enabled()
                        }
                        if (!no5Clicked) {
                            no5Enabled()
                        }
                        no2Clicked = false
                        submit.isEnabled = false
                    } else {
                        calculationList.add(no2.tag as Double)
                        performCalculation()
                        changeText(no2)
                        disableOperators()
                        if (!no1Clicked) {
                            no1Enabled()
                        }
                        if (!no3Clicked) {
                            no3Enabled()
                        }
                        if (!no4Clicked) {
                            no4Enabled()
                        }
                        if (!no5Clicked) {
                            no5Enabled()
                        }
                        no2Clicked = false
                        if (sqrtClicked){
                            no2.setBackgroundResource(R.drawable.number__8_)
                        }
                        sqrtClicked = false

                    }
                    if (allDone){
                        disableOperators()
                        sqrRoot.isEnabled = true
                    }
                } else if (calculationList.size == 0) {
                    no2.setBackgroundResource(R.drawable.number__9_)
                    calculationList.add(no2.tag as Double)
                    no2Clicked = true
                    onNumberButtonClicked()
                    submitResult()
                    if ((no2.tag as Double) < 0.00){
                        sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.sqrtclicked))
                    }
                    sqrRoot.isEnabled = (no2.tag as Double) >= 0.00
                }
                latestPressed = 2.00
            }
            no3.setOnClickListener() {
                enableOperators()
                operatorReady()
                no2Disabled()
                no1Disabled()
                no4Disabled()
                no5Disabled()
                if (calculationList.size != 0) {
                    if ((calculationList[0] == no3.tag as Double) and (latestPressed == 3.00) and !sqrtClicked) {
                        no3.setBackgroundResource(R.drawable.number__8_)
                        calculationList.clear()
                        disableOperators()
                        if (!no2Clicked) {
                            no2Enabled()
                        }
                        if (!no1Clicked) {
                            no1Enabled()
                        }
                        if (!no4Clicked) {
                            no4Enabled()
                        }
                        if (!no5Clicked) {
                            no5Enabled()
                        }
                        no3Clicked = false
                        submit.isEnabled = false

                    } else {
                        calculationList.add(no3.tag as Double)
                        performCalculation()
                        changeText(no3)
                        disableOperators()
                        no3Clicked = false
                        if (sqrtClicked){
                            no3.setBackgroundResource(R.drawable.number__8_)
                        }
                        sqrtClicked = false
                        if (!no1Clicked) {
                            no1Enabled()
                        }
                        if (!no2Clicked) {
                            no2Enabled()
                        }
                        if (!no4Clicked) {
                            no4Enabled()
                        }
                        if (!no5Clicked) {
                            no5Enabled()
                        }
                    }
                    if (allDone){
                        disableOperators()
                        sqrRoot.isEnabled = true
                    }
                } else if (calculationList.size == 0) {
                    no3.setBackgroundResource(R.drawable.number__9_)
                    calculationList.add(no3.tag as Double)
                    no3Clicked = true
                    onNumberButtonClicked()
                    submitResult()
                    if ((no3.tag as Double) < 0.00){
                        sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.sqrtclicked))
                    }
                    sqrRoot.isEnabled = (no3.tag as Double) >= 0.00
                }
                latestPressed = 3.00
            }

            no4.setOnClickListener() {
                enableOperators()
                operatorReady()
                no2Disabled()
                no3Disabled()
                no1Disabled()
                no5Disabled()
                if (calculationList.size != 0) {
                    if ((calculationList[0] == no4.tag as Double) and (latestPressed == 4.00) and !sqrtClicked ) {
                        no4.setBackgroundResource(R.drawable.number__8_)
                        calculationList.clear()
                        disableOperators()
                        if (!no2Clicked) {
                            no2Enabled()
                        }
                        if (!no1Clicked) {
                            no1Enabled()
                        }
                        if (!no3Clicked) {
                            no3Enabled()
                        }
                        if (!no5Clicked) {
                            no5Enabled()
                        }
                        no4Clicked = false
                        submit.isEnabled = false
                    } else {
                        calculationList.add(no4.tag as Double)
                        performCalculation()
                        changeText(no4)
                        disableOperators()
                        no4Clicked = false
                        if (sqrtClicked){
                            no4.setBackgroundResource(R.drawable.number__8_)
                        }
                        sqrtClicked = false
                        if (!no1Clicked) {
                            no1Enabled()
                        }
                        if (!no2Clicked) {
                            no2Enabled()
                        }
                        if (!no3Clicked) {
                            no3Enabled()
                        }
                        if (!no5Clicked) {
                            no5Enabled()
                        }
                    }
                    if (allDone){
                        disableOperators()
                        sqrRoot.isEnabled = true
                    }

                } else if (calculationList.size == 0) {
                    no4.setBackgroundResource(R.drawable.number__9_)
                    calculationList.add(no4.tag as Double)
                    no4Clicked = true
                    onNumberButtonClicked()
                    submitResult()
                    if ((no4.tag as Double) < 0.00){
                        sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.sqrtclicked))
                    }
                    sqrRoot.isEnabled = (no4.tag as Double) >= 0.00
                }

                latestPressed = 4.00
            }
            no5.setOnClickListener() {
                enableOperators()
                operatorReady()
                no2Disabled()
                no3Disabled()
                no1Disabled()
                no4Disabled()
                if (calculationList.size != 0) {
                    if ((calculationList[0] == no5.tag as Double) and (latestPressed == 5.00) and !sqrtClicked ) {
                        no5.setBackgroundResource(R.drawable.number__8_)
                        calculationList.clear()
                        disableOperators()
                        if (!no2Clicked) {
                            no2Enabled()
                        }
                        if (!no1Clicked) {
                            no1Enabled()
                        }
                        if (!no3Clicked) {
                            no3Enabled()
                        }
                        if (!no4Clicked) {
                            no4Enabled()
                        }
                        no5Clicked = false
                        submit.isEnabled = false
                    } else {
                        calculationList.add(no5.tag as Double)
                        performCalculation()
                        changeText(no5)
                        disableOperators()
                        no5Clicked = false
                        if (sqrtClicked){
                            no5.setBackgroundResource(R.drawable.number__8_)
                        }
                        sqrtClicked = false
                        if (!no1Clicked) {
                            no1Enabled()
                        }
                        if (!no2Clicked) {
                            no2Enabled()
                        }
                        if (!no3Clicked) {
                            no3Enabled()
                        }
                        if (!no4Clicked) {
                            no4Enabled()
                        }
                    }
                    if (allDone){
                        disableOperators()
                        sqrRoot.isEnabled = true
                    }

                } else if (calculationList.size == 0) {
                    no5.setBackgroundResource(R.drawable.number__9_)
                    calculationList.add(no5.tag as Double)
                    no5Clicked = true
                    onNumberButtonClicked()
                    submitResult()
                    if ((no5.tag as Double) < 0.00){
                        sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.sqrtclicked))
                        no5Clicked = false
                        if (sqrtClicked){
                            no5.setBackgroundResource(R.drawable.number__8_)
                        }
                        sqrtClicked = false
                    }
                    sqrRoot.isEnabled = (no5.tag as Double) >= 0.00
                }


                latestPressed = 5.00
            }
        }

        fun operator() {
            plus.setOnClickListener {
                plus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.plusclicked))
                if ((operatorList.size != 0)) {
                    if (operatorList[0] == "+") {
                        operatorList.clear()
                        plus.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__8_
                            )
                        )
                        minus.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__2_
                            )
                        )
                        multiply.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__3_
                            )
                        )
                        divide.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__4_
                            )
                        )
                        sqrRoot.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__5_
                            )
                        )
                        power.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol_expo1
                            )
                        )
                        operatorNumSwitch()

                    } else {
                        operatorList.clear()
                        minus.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__2_
                            )
                        )
                        multiply.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__3_
                            )
                        )
                        divide.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__4_
                            )
                        )
                        sqrRoot.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__5_
                            )
                        )
                        power.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__6_
                            )
                        )
                        operatorList.add("+")
                        buttonSwitch()
                    }
                } else if (operatorList.size == 0) {
                    operatorList.add("+")
                    buttonSwitch()
                }


            }
            minus.setOnClickListener {
                minus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.minusclicked))
                if ((operatorList.size != 0)) {
                    if (operatorList[0] == "-") {
                        operatorList.clear()
                        plus.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__8_
                            )
                        )
                        minus.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__2_
                            )
                        )
                        multiply.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__3_
                            )
                        )
                        divide.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__4_
                            )
                        )
                        sqrRoot.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__5_
                            )
                        )
                        power.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__6_
                            )
                        )
                        operatorNumSwitch()

                    } else {
                        operatorList.clear()
                        plus.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__8_
                            )
                        )
                        multiply.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__3_
                            )
                        )
                        divide.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__4_
                            )
                        )
                        sqrRoot.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__5_
                            )
                        )
                        power.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__6_
                            )
                        )
                        operatorList.add("-")
                        buttonSwitch()
                    }
                } else if (operatorList.size == 0) {
                    operatorList.add("-")
                    buttonSwitch()
                }
            }
            multiply.setOnClickListener {
                multiply.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.multiclicked))
                if ((operatorList.size != 0)) {
                    if (operatorList[0] == "*") {
                        operatorList.clear()
                        plus.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__8_
                            )
                        )
                        minus.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__2_
                            )
                        )
                        multiply.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__3_
                            )
                        )
                        divide.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__4_
                            )
                        )
                        sqrRoot.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__5_
                            )
                        )
                        power.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__6_
                            )
                        )
                        operatorNumSwitch()

                    } else {
                        operatorList.clear()
                        minus.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__2_
                            )
                        )
                        plus.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__8_
                            )
                        )
                        divide.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__4_
                            )
                        )
                        sqrRoot.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__5_
                            )
                        )
                        power.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__6_
                            )
                        )
                        operatorList.add("*")
                        buttonSwitch()
                    }
                } else if (operatorList.size == 0) {
                    operatorList.add("*")
                    buttonSwitch()
                }
            }
            divide.setOnClickListener {
                divide.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.divideclicked))
                if ((operatorList.size != 0)) {
                    if (operatorList[0] == "/") {
                        operatorList.clear()
                        plus.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__8_
                            )
                        )
                        minus.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__2_
                            )
                        )
                        multiply.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__3_
                            )
                        )
                        divide.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__4_
                            )
                        )
                        sqrRoot.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__5_
                            )
                        )
                        power.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__6_
                            )
                        )
                        operatorNumSwitch()

                    } else {
                        operatorList.clear()
                        minus.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__2_
                            )
                        )
                        multiply.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__3_
                            )
                        )
                        plus.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__8_
                            )
                        )
                        sqrRoot.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__5_
                            )
                        )
                        power.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__6_
                            )
                        )
                        operatorList.add("/")
                        buttonSwitch()
                    }
                } else if (operatorList.size == 0) {
                    operatorList.add("/")
                    buttonSwitch()
                }
            }
            sqrRoot.setOnClickListener() {
                sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.sqrtclicked))
                sqrtClicked = true
                submit.isEnabled = false
                if (operatorList.size != 0) {
                    if (operatorList[0] == "sqrt") {
                        operatorList.clear()
                        if (!allDone) {
                            plus.setImageDrawable(
                                ContextCompat.getDrawable(
                                    this,
                                    R.drawable.symbol__8_
                                )
                            )
                            minus.setImageDrawable(
                                ContextCompat.getDrawable(
                                    this,
                                    R.drawable.symbol__2_
                                )
                            )
                            multiply.setImageDrawable(
                                ContextCompat.getDrawable(
                                    this,
                                    R.drawable.symbol__3_
                                )
                            )
                            divide.setImageDrawable(
                                ContextCompat.getDrawable(
                                    this,
                                    R.drawable.symbol__4_
                                )
                            )
                            power.setImageDrawable(
                                ContextCompat.getDrawable(
                                    this,
                                    R.drawable.symbol__6_
                                )
                            )
                        }
                        sqrRoot.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__5_
                            )
                        )
                        operatorNumSwitch()
                        sqrtClicked = false
                    } else {
                        operatorList.clear()
                        plus.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__8_
                            )
                        )
                        minus.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__2_
                            )
                        )
                        multiply.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__3_
                            )
                        )
                        divide.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__4_
                            )
                        )
                        power.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__6_
                            )
                        )
                        operatorList.add("sqrt")
                        sqrtClicked = true
                    }
                } else {
                    operatorList.add("sqrt")
                    sqrtClicked = true
                }
                if (latestPressed == 1.00) {
                    no1Enabled()
                    no2Disabled()
                    no3Disabled()
                    no4Disabled()
                    no5Disabled()
                }
                if (latestPressed == 2.00) {
                    no2Enabled()
                    no1Disabled()
                    no3Disabled()
                    no4Disabled()
                    no5Disabled()
                }
                if (latestPressed == 3.00) {
                    no3Enabled()
                    no2Disabled()
                    no1Disabled()
                    no4Disabled()
                    no5Disabled()
                }
                if (latestPressed == 4.00) {
                    no4Enabled()
                    no2Disabled()
                    no3Disabled()
                    no1Disabled()
                    no5Disabled()
                }
                if (latestPressed == 5.00) {
                    no5Enabled()
                    no2Disabled()
                    no3Disabled()
                    no1Disabled()
                    no4Disabled()
                }

            }
            power.setOnClickListener {
                power.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.expoclicked))
                if ((operatorList.size != 0)) {
                    if (operatorList[0] == "**") {
                        operatorList.clear()
                        plus.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__8_
                            )
                        )
                        minus.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__2_
                            )
                        )
                        multiply.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__3_
                            )
                        )
                        divide.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__4_
                            )
                        )
                        sqrRoot.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__5_
                            )
                        )
                        power.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__6_
                            )
                        )
                        operatorNumSwitch()

                    } else {
                        operatorList.clear()
                        plus.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__8_
                            )
                        )
                        multiply.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__3_
                            )
                        )
                        divide.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__4_
                            )
                        )
                        sqrRoot.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__5_
                            )
                        )
                        minus.setImageDrawable(
                            ContextCompat.getDrawable(
                                this,
                                R.drawable.symbol__2_
                            )
                        )
                        operatorList.add("-")
                        buttonSwitch()
                    }
                } else if (operatorList.size == 0) {
                    operatorList.add("**")
                    buttonSwitch()
                }
            }
            home1_1.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        startOperators()
        initialize()
        operator()
    }
}