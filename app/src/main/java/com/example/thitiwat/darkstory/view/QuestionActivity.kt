package com.example.thitiwat.darkstory.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.thitiwat.darkstory.R
import com.example.thitiwat.darkstory.controller.MainController
import com.example.thitiwat.darkstory.model.entities.Question
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    private var question: Question = MainController.getInstance().getCurrentQuestion()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        println(question)
        loadQuestionToView()
    }

//    set Question to Activity
    private fun loadQuestionToView() {
        level.text = "Level : " + question.id
        story.text = question.story
    }

    fun onButtonClicked(view: View) {
        val answer = answer.text.toString()
        var toastText = ""
        if(question.isMatchAnswer(answer)) {
            toastText = "Correct"
            MainController.getInstance().setCurrentQuestion(question.id + 1)
            question = MainController.getInstance().getCurrentQuestion()
            loadQuestionToView()
        } else if (question.isMatchKeyWord(answer)) {
            toastText = "Keyword matched"
        } else {
            toastText = "Completely wrong"
        }
        Toast.makeText(this,toastText,Toast.LENGTH_LONG).show()
    }
}
