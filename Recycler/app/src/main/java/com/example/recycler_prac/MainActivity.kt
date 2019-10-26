package com.example.recycler_prac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var nameLIst = arrayListOf<Data>(
        Data("sadfdafas석준","dog"),
        Data("준","miki"),
        Data("ddd",""),
        Data("adfa", ""),
        Data("dafa",""),
        Data("cccc",""),
        Data("bbb",""),
        Data("rrr","")
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
