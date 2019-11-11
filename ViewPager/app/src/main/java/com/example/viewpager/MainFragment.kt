package com.example.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

open class MainFragment : Fragment()
{
    companion object{
        fun newInstance():MainFragment
        {
            val args = Bundle()

            val frags = MainFragment()
            frags.arguments = args

            return frags
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val v = inflater.inflate(R.layout.activity_content_main, container, false)
        return v
    }
}