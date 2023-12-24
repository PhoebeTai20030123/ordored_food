package com.example.sport.index_adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sport.R
import com.example.sport.foodcart
import com.example.sport.index_modle.Affirmation

class Adapter(
    private val context: Context,
    private val dataset: List<Affirmation>
) : RecyclerView.Adapter<Adapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.index_list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text =  context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)

        // 設置點擊監聽器  點不同運動跳不同畫面
        holder.itemView.setOnClickListener {
            // 根據點擊的位置執行不同的操作
            when (position) {
                0 -> {
                    // 點擊了位置 0 的項目，執行相應的操作（例如啟動新的 Activity）
                    val intent = Intent(context, foodcart::class.java)
                    intent.putExtra("position", position) // 传递图片位置信息
                    intent.putExtra("quantity", 1) // 默认数量为1
                    context.startActivity(intent)
                }
                1 -> {
                    // 點擊了位置 1 的項目，執行相應的操作（例如啟動另一個 Activity）
                    val intent = Intent(context, foodcart::class.java)
                    intent.putExtra("position", position) // 传递图片位置信息
                    intent.putExtra("quantity", 1) // 默认数量为1
                    context.startActivity(intent)
                }
                // Add more cases for other positions as needed
                else -> {
                    // 點擊了其他位置的項目，執行相應的操作（如果需要的話）
                    // 例如，如果需要，可以顯示 Toast 或啟動默認 Activity 等
                }
            }
        }
    }
}