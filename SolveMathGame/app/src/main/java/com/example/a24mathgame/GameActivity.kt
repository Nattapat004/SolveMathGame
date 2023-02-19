package com.example.a24mathgame

import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import kotlin.math.pow

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gamelayout)
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
        submit.isEnabled = false
        var no1Clicked = false
        var no2Clicked = false
        var no3Clicked = false
        var no4Clicked = false
        var sqrtClicked = false
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
        no1.setBackgroundColor(Color.rgb(192, 127, 245))
        no2.setBackgroundColor(Color.rgb(192, 127, 245))
        no3.setBackgroundColor(Color.rgb(192, 127, 245))
        no4.setBackgroundColor(Color.rgb(192, 127, 245))
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
            no1.setBackgroundColor(Color.rgb(192, 127, 245))
        }

        fun no2Enabled(){
            no2.isEnabled = true
            no2.setBackgroundColor(Color.rgb(192, 127, 245))
        }

        fun no3Enabled(){
            no3.isEnabled = true
            no3.setBackgroundColor(Color.rgb(192, 127, 245))
        }

        fun no4Enabled(){
            no4.isEnabled = true
            no4.setBackgroundColor(Color.rgb(192, 127, 245))
        }

        fun no1Disabled(){
            no1.isEnabled = false
            no1.setBackgroundColor(Color.rgb(201, 185, 240))
        }

        fun no2Disabled(){
            no2.isEnabled = false
            no2.setBackgroundColor(Color.rgb(201, 185, 240))
        }

        fun no3Disabled(){
            no3.isEnabled = false
            no3.setBackgroundColor(Color.rgb(201, 185, 240))
        }

        fun no4Disabled(){
            no4.isEnabled = false
            no4.setBackgroundColor(Color.rgb(201, 185, 240))
        }



        fun operatorReady(){
            plus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_plus1))
            minus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_minus1))
            multiply.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_multiple1))
            divide.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_divide))
            sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_sqrt1))
            power.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_expo1))
        }



        fun onNumberButtonClicked() {
            if (no1Clicked and no2Clicked and no3Clicked and no4Clicked) {
                submit.isEnabled = true
            }
        }

        fun submitResult() {
            submit.setOnClickListener() {
                if (calculationList[0] == 10.00) {
                    val intent = Intent(this, Victory::class.java)
                    startActivity(intent)
                } else {
                    val intent = Intent(this, Defeated::class.java)
                    startActivity(intent)
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
                    "sqrt" -> result = kotlin.math.sqrt(result)
                    "**" -> result = result.pow(calculationList[i])
                }
            }
        }

        fun initialize() {
            no1.tag = 1.00
            no2.tag = 2.00
            no3.tag = 3.00
            no4.tag = 4.00
            no1.setOnClickListener() {
                enableOperators()
                operatorReady()
                no2Disabled()
                no3Disabled()
                no4Disabled()
                if (calculationList.size != 0) {
                    if ((calculationList[0] == no1.tag as Double) and (latestPressed == 1.00) and (!sqrtClicked)){
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
                        no1.tag = result
                        submit.tag = result
                        no1.text = String.format("%.2f", result)
                        submit.text = String.format("%.2f", result)
                        calculationList.clear()
                        operatorList.clear()
                        disableOperators()
                        no1Clicked = false
                        sqrtClicked = false
                        if (!no2Clicked){
                            no2Enabled()
                        }
                        if (!no3Clicked){
                            no3Enabled()
                        }
                        if (!no4Clicked){
                            no4Enabled()
                        }
                    }

                } else if (calculationList.size == 0) {
                        calculationList.add(no1.tag as Double)
                        no1Clicked = true
                    onNumberButtonClicked()
                    submitResult()
                }

                if ((no1.tag as Double) < 0.00){
                    sqrRoot.isEnabled = false
                }else {
                    sqrRoot.isEnabled = true
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
                    if ((calculationList[0] == no2.tag as Double) and (latestPressed == 2.00) and (!sqrtClicked)){
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
                        no2.tag = result
                        no2.text = String.format("%.2f", result)
                        submit.text = String.format("%.2f", result)
                        calculationList.clear()
                        operatorList.clear()
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
                        sqrtClicked = false
                    }
                } else if (calculationList.size == 0) {
                        calculationList.add(no2.tag as Double)
                        no2Clicked = true
                    onNumberButtonClicked()
                    submitResult()
                }

                if ((no2.tag as Double) < 0.00){
                    sqrRoot.isEnabled = false
                }else {
                    sqrRoot.isEnabled = true
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
                    if ((calculationList[0] == no3.tag as Double) and (latestPressed == 3.00) and (!sqrtClicked)) {
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
                        no3.tag = result
                        no3.text = String.format("%.2f", result)
                        submit.text = String.format("%.2f", result)
                        calculationList.clear()
                        operatorList.clear()
                        disableOperators()
                        no3Clicked = false
                        sqrtClicked = false
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
                        calculationList.add(no3.tag as Double)
                        no3Clicked = true
                    onNumberButtonClicked()
                    submitResult()
                }

                if ((no3.tag as Double) < 0.00){
                    sqrRoot.isEnabled = false
                }else {
                    sqrRoot.isEnabled = true
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
                    if ((calculationList[0] == no4.tag as Double) and (latestPressed == 4.00) and (!sqrtClicked)) {
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
                        no4.tag = result
                        no4.text = String.format("%.2f", result)
                        submit.text = String.format("%.2f", result)
                        calculationList.clear()
                        operatorList.clear()
                        disableOperators()
                        no4Clicked = false
                        sqrtClicked = false
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
                        calculationList.add(no4.tag as Double)
                        no4Clicked = true
                    onNumberButtonClicked()
                    submitResult()

                }

                if ((no4.tag as Double) < 0.00){
                    sqrRoot.isEnabled = false
                }else {
                    sqrRoot.isEnabled = true
                }
                latestPressed = 4.00
            }
        }

        fun operator() {
            plus.setOnClickListener {
                plus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.plusclicked))
                if(operatorList.size != 0){
                    operatorList.clear()
                    minus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_minus1))
                    multiply.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_multiple1))
                    divide.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_divide))
                    sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_sqrt1))
                    power.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_expo1))
                    operatorList.add("+")
                }else {
                    operatorList.add("+")
                }
                if (!no1Clicked){
                    no1Enabled()
                } else {
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
            minus.setOnClickListener {
                minus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.minusclicked))
                if(operatorList.size != 0){
                    operatorList.clear()
                    plus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_plus1))
                    multiply.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_multiple1))
                    divide.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_divide))
                    sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_sqrt1))
                    power.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_expo1))
                    operatorList.add("-")
                }else {
                    operatorList.add("-")
                }
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
            multiply.setOnClickListener {
                multiply.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.multiclicked))
                if(operatorList.size != 0){
                    operatorList.clear()
                    plus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_plus1))
                    minus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_minus1))
                    divide.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_divide))
                    sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_sqrt1))
                    power.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_expo1))
                    operatorList.add("*")
                }else {
                    operatorList.add("*")
                }
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
            divide.setOnClickListener {
                divide.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.divideclicked))
                if(operatorList.size != 0){
                    operatorList.clear()
                    plus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_plus1))
                    minus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_minus1))
                    multiply.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_multiple1))
                    sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_sqrt1))
                    power.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_expo1))
                    operatorList.add("/")
                }else {
                    operatorList.add("/")
                }
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
            sqrRoot.setOnClickListener(){
                sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.sqrtclicked))
                sqrtClicked = true
                submit.isEnabled = false
                if(operatorList.size != 0){
                    operatorList.clear()
                    plus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_plus1))
                    minus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_minus1))
                    multiply.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_multiple1))
                    divide.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_divide))
                    power.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_expo1))
                    operatorList.add("sqrt")
                }else {
                    operatorList.add("sqrt")
                }
                if (latestPressed == 1.00){
                    no1Enabled()
                    no2Disabled()
                    no3Disabled()
                    no4Disabled()
                }
                if (latestPressed == 2.00){
                    no2Enabled()
                    no1Disabled()
                    no3Disabled()
                    no4Disabled()
                }
                if (latestPressed == 3.00){
                    no3Enabled()
                    no2Disabled()
                    no1Disabled()
                    no4Disabled()
                }
                if (latestPressed == 4.00){
                    no4Enabled()
                    no2Disabled()
                    no3Disabled()
                    no1Disabled()
                }
            }
            power.setOnClickListener(){
                power.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.expoclicked))
                if(operatorList.size != 0){
                    operatorList.clear()
                    plus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_plus1))
                    minus.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_minus1))
                    multiply.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_multiple1))
                    divide.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_divide))
                    sqrRoot.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.symbol_sqrt1))
                    operatorList.add("**")
                }else {
                    operatorList.add("**")
                }
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

            }
        initialize()
        operator()

        }

        }

















