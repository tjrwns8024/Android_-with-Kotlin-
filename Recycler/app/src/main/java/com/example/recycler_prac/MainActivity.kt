package com.example.recycler_prac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var nameLIst = arrayListOf<Data>(
        Data("sadfdafas석준","17","dog"),
        Data("준","10","miki"),
        Data("ddd","7",""),
        Data("adfa", "2",""),
        Data("dafa","1",""),
        Data("cccc","0",""),
        Data("bbb","5",""),
        Data("rrr","12","")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myAdapter= MainAdapter(this, nameLIst)
        mRecyclerView.adapter = myAdapter

        val lm = LinearLayoutManager(this)
        mRecyclerView.layoutManager = lm
        mRecyclerView.setHasFixedSize(true)
    }
}
