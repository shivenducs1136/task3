package com.example.instagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import maes.tech.intentanim.CustomIntent

class MainActivity : AppCompatActivity() {

    private lateinit var instaAdapter : HorizontalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSet()
        var msg_btn:ImageView = findViewById(R.id.message_btn)
        msg_btn.setOnClickListener(View.OnClickListener {
            val i =Intent(this,chatsectionm::class.java)
            startActivity(i)
            CustomIntent.customType(this,"left-to-right")
        }
        )
    }

    private fun addDataSet(){
        val data =DataSource.createDataSet()
        instaAdapter.submitList(data)
    }

    private  fun initRecyclerView(){
        stories.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            instaAdapter = HorizontalAdapter()
            adapter = instaAdapter
        }

    }

}