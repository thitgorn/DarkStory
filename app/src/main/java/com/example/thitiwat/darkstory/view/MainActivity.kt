package com.example.thitiwat.darkstory.view

import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.thitiwat.darkstory.R
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL

class MainActivity : AppCompatActivity() {
    private var questions:String = ""
    private var loadingState:Boolean = false

//    TODO CHECK CURRENT STAGE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loader = QuestionLoader()
        loader.execute()
    }

//    clean up later
//    FOR NOW LET'S ASSUME IT starts at 1
    fun onCurrentClick(view: View) {
        val currentStage = 1
        val intent = Intent(this, QuestionActivity::class.java)
        startActivity(intent)
    }

    fun onChooseLevelClick(view: View) {
        val intent = Intent(this, ChooseLevelActivity::class.java)
        startActivity(intent)
    }

//    sync real data
    inner class QuestionLoader : AsyncTask<String, String, String>() {
        override fun doInBackground(vararg p0: String?): String {
            return URL("http://35.197.154.253:3000/questions").readText()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if(result!=null) {
                questions = result
                loadingState = true
                var JSON = JSONArray(questions)
                for( i in 0..(JSON.length() - 1)) {
                    println(JSON.getJSONObject(i))
                }
            }
        }
    }
}
