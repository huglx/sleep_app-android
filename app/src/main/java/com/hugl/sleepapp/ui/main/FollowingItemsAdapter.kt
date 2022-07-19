package com.hugl.sleepapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hugl.sleepapp.databinding.ListFollowingItemBinding
import com.hugl.sleepapp.model.Test

class FollowingItemsAdapter(private val items: List<Test>): RecyclerView.Adapter<ItemsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val itemBinding =ListFollowingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemsViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ItemsViewHolder(private val item: ListFollowingItemBinding): RecyclerView.ViewHolder(item.root) {
    fun bind(test: Test) {
        item.name.text = test.name
        Glide.with(itemView).
            load("https://sleep-app-api.herokuapp.com/image/"+test.name).
                into(item.avatar)
    }

}
