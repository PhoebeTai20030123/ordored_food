package com.example.sport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.login)

        loginButton.setOnClickListener {
            // 在按钮点击时启动另一个活动（SecondActivity）
            val intent = Intent(this, index::class.java)
            startActivity(intent)
        }
    }
}