package com.example.thitiwat.darkstory.controller

import android.os.AsyncTask
import com.example.thitiwat.darkstory.model.Question
import org.json.JSONArray
import java.net.URL

class MainController {
    private val questions = ArrayList<Question>()

    fun loadQuestion() {
        var questionLoader = QuestionLoader()
        questionLoader.execute()
    }

    fun setQuestion(jsonArray: JSONArray) {
        questions.clear()
        for( i in 0..(jsonArray.length() - 1)) {
            var jsObj = jsonArray.getJSONObject(i)
//            add manually
            var keywords = JSONArray(jsObj.getString("keyword"))
            var arrKeywords = Array<String>(keywords.length()) { "" }
            for( i in 0..(keywords.length() - 1)) {
                arrKeywords[i] = keywords[i].toString()
            }
            var question = Question(jsObj.getString("id").toInt() , jsObj.getString("topic") , arrKeywords , jsObj.getString("answer") , jsObj.getString("story"))
            questions.add(question)
        }
    }

//    Can be null if not found
    fun getQuestion(id : Int): Question? {
        return questions.filter { it.id == id }.get(0)
    }


    //    sync real data
    inner class QuestionLoader : AsyncTask<String, String, String>() {
        private val URL: String = "http://35.197.154.253:3000/questions"
        override fun doInBackground(vararg p0: String?): String {
            return URL(this.URL).readText()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if(result!=null) {
                var JSON = JSONArray(result)
                setQuestion(JSON)
            }
        }
    }
}