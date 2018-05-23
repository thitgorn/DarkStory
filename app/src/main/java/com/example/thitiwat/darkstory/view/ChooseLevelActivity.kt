package com.example.thitiwat.darkstory.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.thitiwat.darkstory.R
import com.example.thitiwat.darkstory.controller.MainController

class ChooseLevelActivity : AppCompatActivity() {
    private val controller = MainController.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_level)
    }

    fun onLevelButtonClicked(view : View) {
        val but = view as Button
        val id : Int = but.text.substring(6 , but.text.length).toInt()
        controller.setCurrentQuestion(id)

        val intent = Intent(this,QuestionActivity::class.java)
        startActivity(intent)
    }
}
