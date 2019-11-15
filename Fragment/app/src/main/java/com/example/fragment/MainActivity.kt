package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        A_btn.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.fragment,A_fragment()).commit()
        }
        B_btn.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.fragment,B_fragment()).commit()
        }

    }
}
