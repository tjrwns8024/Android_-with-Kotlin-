package com.example.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

open class OneFragment : Fragment() {
    companion object {
        fun newInstance(): OneFragment {
            val args = Bundle()

            args.putString("a", "errwe")

            val frag = OneFragment()
            frag.arguments = args

            frag.arguments?.getString("a")


            return frag
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val v = inflater.inflate(R.layout.activity_content_one, container, false)
        return v
    }
}