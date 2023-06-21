package com.example.chat_gpt_integration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import okhttp3.OkHttpClient
import okhttp3.Request

class chat_gpt_integration : AppCompatActivity() {

    private val client = OkHttpClient()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val askGPT=findViewById<EditText>(R.id.askGPT)
        val btnSubmit=findViewById<Button>(R.id.btnSubmit)
        val GPTResponse=findViewById<TextView>(R.id.GPTResponse)


        btnSubmit.setOnClickListener {
            val hobby="5 hobby builders for " + askGPT.toString()
            Toast.makeText(this,hobby,Toast.LENGTH_SHORT).show()
            getResponse(hobby){response ->
                runOnUiThread{
                    GPTResponse.text=response
                }
            }
        }
    }
    fun getResponse(hobby:String, callback: (String) -> Unit) {
        val apiKey = "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"
        val url = "https://api.openai.com/v1/completions"

        val requestBody = """
            {
            "model": "text-davinci-003",
            "prompt": "$hobby",
            "max_tokens": 7,
            "temperature": 0,
            }
        """.trimIndent()

        val request = Request.Builder()
            .url(url)
            .header("User-Agent", "OkHttp Headers.java")
            .addHeader("Accept", "application/json; q=0.5")
            .addHeader("Accept", "application/vnd.github.v3+json")
            .build()
    }
}