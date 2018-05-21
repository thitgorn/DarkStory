package com.example.thitiwat.darkstory

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onCurrentClick(view: View) {
        val intent = Intent(this,question::class.java)
        startActivity(intent)
    }

    fun onChooseLevelClick(view: View) {

    }

}
