package com.example.thitiwat.darkstory.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.thitiwat.darkstory.R

class ChooseLevelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_level)
    }

    fun onLevelButtonClicked(view : View) {
        val but = view as Button
        println(but.text.toString() + " : clicked")
    }
}
