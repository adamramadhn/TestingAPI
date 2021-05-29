package com.example.testingapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testingapi.databinding.ItemListBinding
import com.example.testingapi.model.Post

class Adapter(private val list:ArrayList<Post>) :RecyclerView.Adapter<Adapter.PostViewHolder>(){
    fun setData(newListData:  ArrayList<Post>?) {
        if (newListData == null) return
        list.clear()
        list.addAll(newListData)
        notifyDataSetChanged()
    }
    inner class PostViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        private val ibinding = ItemListBinding.bind(itemView)
        fun bind(myTrainRespone : Post){
            with(ibinding) {
                tvItemTitle.text = myTrainRespone.age.toString()
                tvItemSubtitle.text = myTrainRespone.id.toString()
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return PostViewHolder(view)
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list[position])
    }
    override fun getItemCount(): Int = list.size
}