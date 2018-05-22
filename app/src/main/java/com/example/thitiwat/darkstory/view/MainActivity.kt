package com.example.thitiwat.darkstory.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.thitiwat.darkstory.R
import com.example.thitiwat.darkstory.controller.MainController

class MainActivity : AppCompatActivity() {

    private val controller: MainController = MainController()

//    TODO CHECK CURRENT STAGE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        controller.loadQuestion()
    }

//    clean up later
//    FOR NOW LET'S ASSUME IT starts at 1
    fun onCurrentClick(view: View) {
        val currentStage = 1
        val intent = Intent(this, QuestionActivity::class.java)
        startActivity(intent)
    }

    fun onChooseLevelClick(view: View) {
        val intent = Intent(this, ChooseLevelActivity::class.java)
        startActivity(intent)
    }

}
