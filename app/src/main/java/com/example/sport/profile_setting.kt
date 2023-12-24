package com.example.sport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class profile_setting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_setting)

        val set = findViewById<Button>(R.id.set)
        set.setOnClickListener {
            val intent = Intent(this, profile::class.java)
            startActivity(intent)
        }
    }
}