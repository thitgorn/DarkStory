package com.example.thitiwat.darkstory.model.repository

import com.example.thitiwat.darkstory.model.entities.Question
import java.util.*

abstract class Repository {

    private var question = ArrayList<Question>()

    abstract fun loadQuestion()

    fun getQuestion():ArrayList<Question> {
        return this.question
    }

    fun setQuestion(question: ArrayList<Question>) {
        this.question = question
    }
}