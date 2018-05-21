package com.example.thitiwat.darkstory.controller

import com.example.thitiwat.darkstory.model.Question

class MainController {
    private val question = ArrayList<Question>()

//    TODO
    fun setQuestion() {

    }

//    Can be null if not found
    fun getQuestion(id : Int): Question? {
        return question.filter { it.id == id }.get(0)
    }
}