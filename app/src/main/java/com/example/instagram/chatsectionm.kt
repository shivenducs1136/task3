package com.example.instagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.chat_sectiom.*
import maes.tech.intentanim.CustomIntent

class chatsectionm : AppCompatActivity() {

    private lateinit var chatAdapter: chatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat_sectiom)

        val arrow:ImageView = findViewById(R.id.arrow)
        arrow.setOnClickListener(View.OnClickListener {
            var i = Intent(this,MainActivity::class.java)
            startActivity(i)
            CustomIntent.customType(this,"right-to-left")
        })

        initRecyclerView()
        addDataSet()
    }

    private fun addDataSet(){
        val data =chat_data.createDataSet()
        chatAdapter.submitList(data)
    }

    private  fun initRecyclerView(){
        chat_recview.apply {
            layoutManager = LinearLayoutManager(this@chatsectionm)
            chatAdapter = chatAdapter()
            adapter = chatAdapter
        }

    }

}