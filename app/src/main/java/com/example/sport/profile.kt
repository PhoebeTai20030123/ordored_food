package com.example.sport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView

class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // 找到設定 ImageView
        val settingsIcon = findViewById<ImageView>(R.id.settingsIcon)

        // 設定點擊事件，當點擊設定圖標時觸發跳轉頁面
        settingsIcon.setOnClickListener {
            val intent = Intent(this, profile_setting::class.java)
            startActivity(intent)
        }


        //logout
        val logout = findViewById<Button>(R.id.logout)
        logout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // 找到 BottomNavigationView 並設置 NavController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    // Handle Home item click
                    // 可以使用 Intent 或其他適當的方法來執行對應頁面的跳轉
                    val intent = Intent(this, index::class.java)
                    startActivity(intent)
                    true
                }

                R.id.navigation_cart -> {
                    // Handle Search item click
                    false
                }

                R.id.navigation_profile -> {
                    // Handle Profile item click
                    true
                }
                // Handle more items...
                else -> false
            }
        }
    }
}