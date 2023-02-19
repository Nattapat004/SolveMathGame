package com.example.a24mathgame

import android.app.Application
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.core.content.ContextCompat

class ep1stage1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ep1stage1)
        val no1 = findViewById<Button>(R.id.no1)
        val no2 = findViewById<Button>(R.id.no2)
        val no3 = findViewById<Button>(R.id.no3)
        val no4 = findViewById<Button>(R.id.no4)
        val plus = findViewById<ImageButton>(R.id.plus)
        val minus = findViewById<ImageButton>(R.id.minus)
        val multiply = findViewById<ImageButton>(R.id.multiply)
        val divide = findViewById<ImageButton>(R.id.divide)
        val sqrRoot = findViewById<ImageButton>(R.id.root)
        val submit = findViewById<Button>(R.id.submitButton)
        val power = findViewById<ImageButton>(R.id.power)
        val backtoep1_1 = findViewById<ImageButton>(R.id.backtoep1_1)
        val home1_1 = findViewById<ImageButton>(R.id.home1_1)

        submit.isEnabled = false
        submit.text = 10.toString()
        var no1Clicked = false
        var no2Clicked = false
        var no3Clicked = false
        var no4Clicked = false
        var result = 0.00
        var latestPressed = 0.00
        val calculationList = mutableListOf<Double>()
        val operatorList = mutableListOf<String>()
        plus.isEnabled = false
        minus.isEnabled = false
        multiply.isEnabled = false
        divide.isEnabled = false
        sqrRoot.isEnabled = false
        power.isEnabled = false

        fun enableOperators(){
            plus.isEnabled = true
            minus.isEnabled = true
            multiply.isEnabled = true
            divide.isEnabled = true
            sqrRoot.isEnabled = true
            power.isEnabled = true
        }

        fun disableOperators(){
            plus.isEnabled = false
            minus.isEnabled = false
            multiply.isEnabled = false
            divide.isEnabled = false
            sqrRoot.isEnabled = false
            power.isEnabled = false
        }

        fun no1Enabled(){
            no1.isEnabled = true

        }

        fun no2Enabled(){
            no2.isEnabled = true

        }

        fun no3Enabled(){
            no3.isEnabled = true

        }

        fun no4Enabled(){
            no4.isEnabled = true

        }

        fun no1Disabled(){
            no1.isEnabled = false

        }

        fun no2Disabled(){
            no2.isEnabled = false

        }

        fun no3Disabled(){
            no3.isEnabled = false
        }

        fun no4Disabled(){
            no4.isEnabled = false
        }



        fun operatorReady(){
            plus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_plus1))
            minus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_minus1))
            multiply.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_multiple1))
            divide.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_divide))
            sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_sqrt1))
            power.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_expo1))
        }

        fun operatorUnReady(){
            plus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.plusclicked))
            minus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.minusclicked))
            multiply.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.multiclicked))
            divide.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.divideclicked))
            power.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.expoclicked))
        }

        fun changeText(no0 : Button){
            no0.tag = result
            no0.text = String.format("%.2f", result)
            calculationList.clear()
            operatorList.clear()
            submit.tag = result
        }

        fun operatorNumSwitch(){
            if (no1Clicked){
                no1Enabled()
                no2Disabled()
                no3Disabled()
                no4Disabled()
            }

            if (no2Clicked){
                no2Enabled()
                no1Disabled()
                no3Disabled()
                no4Disabled()
            }

            if (no3Clicked){
                no3Enabled()
                no1Disabled()
                no2Disabled()
                no4Disabled()
            }

            if (no4Clicked){
                no4Enabled()
                no1Disabled()
                no2Disabled()
                no3Disabled()
            }
        }

        fun buttonSwitch(){
            if (!no1Clicked){
                no1Enabled()
            }else {
                no1Disabled()
            }
            if (!no2Clicked){
                no2Enabled()
            }else {
                no2Disabled()
            }
            if (!no3Clicked){
                no3Enabled()
            }else {
                no3Disabled()
            }
            if (!no4Clicked){
                no4Enabled()
            }else {
                no4Disabled()
            }
        }



        fun onNumberButtonClicked() {
            if (no1Clicked and no2Clicked and no3Clicked and no4Clicked) {
                submit.isEnabled = true
                plus.isEnabled = false
                minus.isEnabled = false
                multiply.isEnabled = false
                divide.isEnabled = false
                operatorUnReady()
            }
        }

        fun submitResult() {
            submit.setOnClickListener() {
                if (calculationList[0] == 10.00) {
                    val intent = Intent(this, Victory::class.java)
                    startActivity(intent)
                    val stage1Cleared = applicationContext as StageCheck
                    stage1Cleared.stage1Cleared = true
                    val stageCleared = applicationContext as StageCheck
                    stageCleared.stageCleared = 1
                } else {
                    val intent = Intent(this, Defeated::class.java)
                    startActivity(intent)
                    val stageLost = applicationContext as StageCheck
                    stageLost.stageLost = 1
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
                }
            }
        }

        fun initialize() {
            no1.tag = 1.00
            no2.tag = 2.00
            no3.tag = 3.00
            no4.tag = 4.00
            no1.text = no1.tag.toString()
            no2.text = no2.tag.toString()
            no3.text = no3.tag.toString()
            no4.text = no4.tag.toString()
            no1.setOnClickListener() {
                enableOperators()
                operatorReady()
                no2Disabled()
                no3Disabled()
                no4Disabled()
                if (calculationList.size != 0) {
                    if ((calculationList[0] == no1.tag as Double) and (latestPressed == 1.00)){
                        no1.setBackgroundResource(R.drawable.number__4_)
                        calculationList.clear()
                        disableOperators()
                        if (!no2Clicked){
                            no2Enabled()
                        }
                        if (!no3Clicked){
                            no3Enabled()
                        }
                        if (!no4Clicked){
                            no4Enabled()
                        }
                        no1Clicked = false
                    } else{
                        calculationList.add(no1.tag as Double)
                        performCalculation()
                        changeText(no1)
                        disableOperators()
                        if (!no2Clicked){
                            no2Enabled()
                        }
                        if (!no3Clicked){
                            no3Enabled()
                        }
                        if (!no4Clicked){
                            no4Enabled()
                        }
                        no1Clicked = false
                    }

                } else if (calculationList.size == 0) {
                    no1.setBackgroundResource(R.drawable.number__5_)
                    calculationList.add(no1.tag as Double)
                    no1Clicked = true
                    onNumberButtonClicked()
                    submitResult()
                }
                latestPressed = 1.00
            }
            no2.setOnClickListener() {
                enableOperators()
                operatorReady()
                no1Disabled()
                no3Disabled()
                no4Disabled()
                if (calculationList.size != 0) {
                    if ((calculationList[0] == no2.tag as Double) and (latestPressed == 2.00)){
                        no2.setBackgroundResource(R.drawable.number__4_)
                        calculationList.clear()
                        disableOperators()
                        if (!no1Clicked){
                            no1Enabled()
                        }
                        if (!no3Clicked){
                            no3Enabled()
                        }
                        if (!no4Clicked){
                            no4Enabled()
                        }
                        no2Clicked = false
                    }else {
                        calculationList.add(no2.tag as Double)
                        performCalculation()
                        changeText(no2)
                        disableOperators()
                        if (!no1Clicked){
                            no1Enabled()
                        }
                        if (!no3Clicked){
                            no3Enabled()
                        }
                        if (!no4Clicked){
                            no4Enabled()
                        }
                        no2Clicked = false

                    }
                } else if (calculationList.size == 0) {
                    no2.setBackgroundResource(R.drawable.number__5_)
                    calculationList.add(no2.tag as Double)
                    no2Clicked = true
                    onNumberButtonClicked()
                    submitResult()
                }

                latestPressed = 2.00
            }
            no3.setOnClickListener() {
                enableOperators()
                operatorReady()
                no2Disabled()
                no1Disabled()
                no4Disabled()
                if (calculationList.size != 0) {
                    if ((calculationList[0] == no3.tag as Double) and (latestPressed == 3.00)) {
                        no3.setBackgroundResource(R.drawable.number__4_)
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
                        no3Clicked = false

                    } else {
                        calculationList.add(no3.tag as Double)
                        performCalculation()
                        changeText(no3)
                        disableOperators()
                        no3Clicked = false
                        if (!no1Clicked){
                            no1Enabled()
                        }
                        if (!no2Clicked){
                            no2Enabled()
                        }
                        if (!no4Clicked){
                            no4Enabled()
                        }
                    }
                } else if (calculationList.size == 0) {
                    no3.setBackgroundResource(R.drawable.number__5_)
                    calculationList.add(no3.tag as Double)
                    no3Clicked = true
                    onNumberButtonClicked()
                    submitResult()
                }
                latestPressed = 3.00
            }

            no4.setOnClickListener() {
                enableOperators()
                operatorReady()
                no2Disabled()
                no3Disabled()
                no1Disabled()
                if (calculationList.size != 0) {
                    if ((calculationList[0] == no4.tag as Double) and (latestPressed == 4.00)) {
                        no4.setBackgroundResource(R.drawable.number__4_)
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
                        no4Clicked = false
                    } else {
                        calculationList.add(no4.tag as Double)
                        performCalculation()
                        changeText(no4)
                        disableOperators()
                        no4Clicked = false
                        if (!no1Clicked){
                            no1Enabled()
                        }
                        if (!no2Clicked){
                            no2Enabled()
                        }
                        if (!no3Clicked){
                            no3Enabled()
                        }
                    }

                } else if (calculationList.size == 0) {
                    no4.setBackgroundResource(R.drawable.number__5_)
                    calculationList.add(no4.tag as Double)
                    no4Clicked = true
                    onNumberButtonClicked()
                    submitResult()

                }
                latestPressed = 4.00
            }
        }

        fun operator() {
            plus.setOnClickListener {
                plus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.plusclicked))
                if((operatorList.size != 0)){
                    if (operatorList[0] == "+"){
                        operatorList.clear()
                        plus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_plus1))
                        minus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_minus1))
                        multiply.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_multiple1))
                        divide.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_divide))
                        sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_sqrt1))
                        power.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_expo1))
                        operatorNumSwitch()

                    }else {
                        operatorList.clear()
                        minus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_minus1))
                        multiply.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_multiple1))
                        divide.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_divide))
                        sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_sqrt1))
                        power.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_expo1))
                        operatorList.add("+")
                        buttonSwitch()
                    }
                }else if (operatorList.size == 0){
                    operatorList.add("+")
                    buttonSwitch()
                }


            }
            minus.setOnClickListener {
                minus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.minusclicked))
                if((operatorList.size != 0)){
                    if (operatorList[0] == "-"){
                        operatorList.clear()
                        plus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_plus1))
                        minus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_minus1))
                        multiply.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_multiple1))
                        divide.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_divide))
                        sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_sqrt1))
                        power.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_expo1))
                        operatorNumSwitch()

                    }else {
                        operatorList.clear()
                        plus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_plus1))
                        multiply.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_multiple1))
                        divide.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_divide))
                        sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_sqrt1))
                        power.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_expo1))
                        operatorList.add("-")
                        buttonSwitch()
                    }
                }else if (operatorList.size == 0){
                    operatorList.add("-")
                    buttonSwitch()
                }
            }
            multiply.setOnClickListener {
                multiply.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.multiclicked))
                if((operatorList.size != 0)){
                    if (operatorList[0] == "*"){
                        operatorList.clear()
                        plus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_plus1))
                        minus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_minus1))
                        multiply.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_multiple1))
                        divide.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_divide))
                        sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_sqrt1))
                        power.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_expo1))
                        operatorNumSwitch()

                    }else {
                        operatorList.clear()
                        minus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_minus1))
                        plus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_plus1))
                        divide.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_divide))
                        sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_sqrt1))
                        power.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_expo1))
                        operatorList.add("*")
                        buttonSwitch()
                    }
                }else if (operatorList.size == 0){
                    operatorList.add("*")
                    buttonSwitch()
                }
            }
            divide.setOnClickListener {
                divide.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.divideclicked))
                if((operatorList.size != 0)){
                    if (operatorList[0] == "/"){
                        operatorList.clear()
                        plus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_plus1))
                        minus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_minus1))
                        multiply.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_multiple1))
                        divide.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_divide))
                        sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_sqrt1))
                        power.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_expo1))
                        operatorNumSwitch()

                    }else {
                        operatorList.clear()
                        minus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_minus1))
                        multiply.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_multiple1))
                        plus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_plus1))
                        sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_sqrt1))
                        power.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_expo1))
                        operatorList.add("/")
                        buttonSwitch()
                    }
                }else if (operatorList.size == 0){
                    operatorList.add("/")
                    buttonSwitch()
                }
            }
            backtoep1_1.setOnClickListener {
                val intent = Intent(this, LevelSelect1::class.java)
                startActivity(intent)
            }
            home1_1.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        initialize()
        operator()
    }
}

class StageCheck : Application() {
    var stage1Cleared = false
    var stageCleared = 0
    var stageLost = 0
}
