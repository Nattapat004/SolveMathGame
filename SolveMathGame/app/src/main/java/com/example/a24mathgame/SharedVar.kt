package com.example.a24mathgame

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class SharedVar : Application() {
    var stage1Cleared = false
    var stageCleared = 0
    var stageLost = 0
}



