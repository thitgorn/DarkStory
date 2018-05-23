package com.example.thitiwat.darkstory.model.entities

class Question(var id: Int=0 ,var topic:String ,var keyword:Array<String>,var answer:String,var story:String) {

    fun isMatchKeyWord(answer: String):Boolean {
        var userAnswer = answer
        var corrent: Boolean = false
        userAnswer = answer.trim()

        this.keyword.forEach {
            if (userAnswer.contains(it))
                corrent = true
        }
        return corrent
    }

    fun isMatchAnswer(answer: String):Boolean {
        var correct: Boolean = false
        if(answer.contains(this.answer))
            return true
        return false
    }

    override fun toString(): String {
        return this.id.toString() + " " + this.story + " " + this.answer
    }
}