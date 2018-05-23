package com.example.thitiwat.darkstory.model.repository

import android.os.AsyncTask
import com.example.thitiwat.darkstory.model.entities.Question
import org.json.JSONArray

class NetworkRepository:Repository() {


    override fun loadQuestion() {
        val questionLoader = QuestionLoader()
        questionLoader.execute()
    }

    fun setQuestion(jsonArray: JSONArray) {
        var questions = ArrayList<Question>()
        for( i in 0..(jsonArray.length() - 1)) {
            var jsObj = jsonArray.getJSONObject(i)
            var keywords = JSONArray(jsObj.getString("keyword"))
            var arrKeywords = Array<String>(keywords.length()) { "" }
            for( i in 0..(keywords.length() - 1)) {
                arrKeywords[i] = keywords[i].toString()
            }
            println("Story = " + jsObj.getString("story"))
            var question = Question(jsObj.getString("id").toInt(), jsObj.getString("topic"), arrKeywords, jsObj.getString("answer"), jsObj.getString("story"))
            questions.add(question)
        }
        super.setQuestion(questions)
    }


    //    sync real data
    inner class QuestionLoader : AsyncTask<String, String, String>() {
        private val URL: String = "http://35.197.154.253:3000/questions"
        override fun doInBackground(vararg p0: String?): String {
            return java.net.URL(this.URL).readText()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if(result!=null) {
                var json = JSONArray(result)
                setQuestion(json)
            }
        }
    }
}