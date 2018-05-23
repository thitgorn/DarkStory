package com.example.thitiwat.darkstory.controller

import com.example.thitiwat.darkstory.model.entities.Question
import com.example.thitiwat.darkstory.model.repository.MockupRepository
import com.example.thitiwat.darkstory.model.repository.NetworkRepository
import com.example.thitiwat.darkstory.model.repository.Repository

class MainController private constructor() {

    private var currentQuestion : Int = 1
    private var questionRepository: Repository = MockupRepository()

    fun loadRepository() {
        questionRepository.loadQuestion()
    }

    fun getCurrentQuestion(): Question {
        return questionRepository.getQuestion().get(this.currentQuestion - 1)
    }

    fun getQuestion(id:Int): Question? {
        val question: Question?
        question = questionRepository.getQuestion().get(id)
        return question
    }

    fun setRepository(repos: Repository) {
        this.questionRepository = repos
    }

    fun setCurrentQuestion(id : Int) {
        this.currentQuestion = id
    }

    companion object {
        private val mInstance:MainController = MainController()

        @Synchronized
        fun getInstance():MainController {
            return mInstance
        }

    }
}