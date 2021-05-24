package com.sana.ticker

import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageButton
import android.widget.Chronometer
import android.view.animation.Animation
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    lateinit var  b1: ImageButton
    lateinit var b2: ImageButton
    lateinit var b3: ImageButton
    lateinit var counter: Chronometer
    lateinit var anchor_move: Animation
    lateinit var anchor: ImageView
    var stopTime: Long=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b1 = findViewById<View>(R.id.button1) as ImageButton
        b2 = findViewById<View>(R.id.button2) as ImageButton
        b3 = findViewById<View>(R.id.button3) as ImageButton
        anchor = findViewById<View>(R.id.anchor) as ImageView
        counter = findViewById<View>(R.id.counter) as Chronometer
        anchor_move = AnimationUtils.loadAnimation(this, R.anim.anchor_move)
        b1.setOnClickListener {
            counter.base = SystemClock.elapsedRealtime() + stopTime
            counter.start()
            anchor.startAnimation(anchor_move)
        }
        b2.setOnClickListener {
            stopTime = counter.base - SystemClock.elapsedRealtime()
            counter.stop()
            anchor.clearAnimation()
        }
        b3.setOnClickListener {
            counter.base = SystemClock.elapsedRealtime()
            stopTime = 0
            anchor.startAnimation(anchor_move)
        }
    }
}