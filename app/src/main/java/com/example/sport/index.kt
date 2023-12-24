package com.example.sport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.sport.index_adapter.Adapter
import com.example.sport.index_data.Datasource
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController


class index : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)

        // Initialize data.

        //滾軸顯示
        val fat = Datasource().fat()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = Adapter(this, fat)


        // 找到 BottomNavigationView 並設置 NavController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    // Handle Home item click
                    // 可以使用 Intent 或其他適當的方法來執行對應頁面的跳轉

                    true
                }
                R.id.navigation_cart -> {
                    // Handle Search item click
                    true
                }
                R.id.navigation_profile -> {
                    // Handle Profile item click
                    val intent = Intent(this, profile::class.java)
                    startActivity(intent)
                    true
                }
                // Handle more items...
                else -> false
            }
        }
    }
}