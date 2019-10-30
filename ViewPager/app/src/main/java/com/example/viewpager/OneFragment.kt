package com.example.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

open class OneFragment: Fragment()
{
    fun newInstance(): OneFragment
    {
        val args = Bundle()

        val frag = OneFragment()
        frag.arguments = args

        return frag
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        val v = inflater.inflate(R.layout.activity_content_one, container, false)
        return v
    }
}