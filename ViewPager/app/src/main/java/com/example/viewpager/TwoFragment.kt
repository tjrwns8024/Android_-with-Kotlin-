package com.example.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

open class TwoFragment: Fragment()
{
    fun newInstance(): TwoFragment
    {
        val args = Bundle()

        val frag = TwoFragment()
        frag.arguments = args

        return frag
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val v = inflater.inflate(R.layout.activity_content_two, container, false)
        return v
    }
}