package com.example.thitiwat.darkstory.model.repository

import com.example.thitiwat.darkstory.model.entities.Question

class MockupRepository: Repository() {

    override fun loadQuestion() {
        val mockQuestion = ArrayList<Question>()
        mockQuestion.add(Question(1, "mockdemo1" , arrayOf("demo","test","example") , "demo1" , "answer : demo1 ,this is mock data for question one it is not everything else:: !! you are just went offline mode"))
        mockQuestion.add(Question(2, "mockdemo2" , arrayOf("demo","test","example") , "demo2" , "answer : demo1 ,this is mock data for question two it is not everything else:: !! you are just went offline mode"))
        super.setQuestion(mockQuestion)
    }

}