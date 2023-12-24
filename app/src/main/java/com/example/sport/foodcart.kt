package com.example.sport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.sport.index_data.Datasource

class foodcart : AppCompatActivity() {
    private var quantity = 1 // 默认数量为1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foodcart)

        val go_back = findViewById<Button>(R.id.back)
        val imageView = findViewById<ImageView>(R.id.imageView) // 要显示图像的ImageView
        val quantityTextView = findViewById<TextView>(R.id.quantityTextView) // 显示数量的TextView
        val increaseButton = findViewById<Button>(R.id.increaseButton) // 增加数量的按钮
        val decreaseButton = findViewById<Button>(R.id.decreaseButton) // 减少数量的按钮
        val yes = findViewById<Button>(R.id.yes)

        go_back.setOnClickListener {
            val intent = Intent(this, index::class.java)
            startActivity(intent)
        }

        yes.setOnClickListener {
            val intent = Intent(this, index::class.java)
            startActivity(intent)
        }

        val position = intent.getIntExtra("position", -1) // 获取点击的图片位置，默认为-1
        quantity = intent.getIntExtra("quantity", 1) // 获取传递的数量，默认为1

        if (position != -1) {
            val dataset = Datasource().fat() // 你的数据源，这里假设是从Datasource获取数据
            if (position < dataset.size) {
                val imageResourceId = dataset[position].imageResourceId
                imageView.setImageResource(imageResourceId) // 设置对应位置的图像资源ID
            } else {
                // 处理超出数据源范围的情况
            }
        } else {
            // 处理没有传递位置信息的情况
        }

        updateQuantityTextView(quantityTextView) // 更新数量显示

        increaseButton.setOnClickListener {
            quantity++
            updateQuantityTextView(quantityTextView)
        }

        decreaseButton.setOnClickListener {
            if (quantity > 1) {
                quantity--
                updateQuantityTextView(quantityTextView)
            }
        }

        go_back.setOnClickListener {
            onBackPressed() // 返回到上一个Activity
        }
    }

    private fun updateQuantityTextView(textView: TextView) {
        textView.text = quantity.toString() // 更新显示的数量
    }
}