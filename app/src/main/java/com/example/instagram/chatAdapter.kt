package com.example.instagram

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.chat_single_row.view.*
import kotlinx.android.synthetic.main.post.view.*

class chatAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{

    private var items: List<InstaChat> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return InstaViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.chat_single_row,parent,false)
        )
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is InstaViewHolder -> {
                holder.bind(items.get(position))
            }
        }

    }
    override fun getItemCount(): Int {
        return  items.size
    }
    fun submitList(InstaChat: List<InstaChat>){
        items = InstaChat
    }
    class InstaViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        val insta_chat_image: ImageView = itemView.chat_dp_img
        val insta_chat_name:TextView = itemView.chat_name_txt
        val insta_chat_seen:TextView = itemView.chat_last_seen

        fun bind(instapost: InstaChat){
            insta_chat_name.setText(instapost.chat_name)
            insta_chat_seen.setText(instapost.chat_content)
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.dpdp)
                .error(R.drawable.ic_instagram)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(instapost.chat_dp)
                .into(insta_chat_image)

        }
    }

}