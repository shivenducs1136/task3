package com.example.instagram


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.post.view.*

class HorizontalAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{

    private var items: List<instapost> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return InstaViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.post,parent,false)
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
    fun submitList(instapost: List<instapost>){
        items = instapost
    }
    class InstaViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        val insta_post_image: ImageView = itemView.post_pic
        val insta_user_name:TextView = itemView.username
        val insta_dp:ImageView = itemView.dp_profile
        val comment:TextView = itemView.commented

        fun bind(instapost: instapost){
            insta_user_name.setText(instapost.instaidz)
            comment.setText(instapost.commenterz)

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.dpdp)
                .error(R.drawable.ic_instagram)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(instapost.imagepostz)
                .into(insta_post_image)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(instapost.imagedpz)
                .into(insta_dp)
        }
    }

}