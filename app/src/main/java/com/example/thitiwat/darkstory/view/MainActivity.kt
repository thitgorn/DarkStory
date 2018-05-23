package com.example.thitiwat.darkstory.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.thitiwat.darkstory.R
import com.example.thitiwat.darkstory.controller.MainController
import com.example.thitiwat.darkstory.model.repository.NetworkRepository

class MainActivity : AppCompatActivity() {

    private val controller: MainController = MainController.getInstance()

    init {
//        controller.setRepository(NetworkRepository())
        controller.loadRepository()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onCurrentClick(view: View) {
        val intent = Intent(this, QuestionActivity::class.java)
        startActivity(intent)
    }

    fun onChooseLevelClick(view: View) {
        val intent = Intent(this, ChooseLevelActivity::class.java)
        startActivity(intent)
    }

}
