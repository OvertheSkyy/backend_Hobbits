package com.example.chat_gpt_integration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class chat_gpt_integration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val askGPT=findViewById<EditText>(R.id.askGPT)
        val btnSubmit=findViewById<Button>(R.id.btnSubmit)
        val GPTResponse=findViewById<TextView>(R.id.GPTResponse)


        btnSubmit.setOnClickListener {
            val hobby="5 hobby builders for" + askGPT.text
            Toast.makeText(this,hobby,Toast.LENGTH_SHORT).show()
        }
    }
}