package com.example.spacetapp.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.spacetapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ArticleFragment : Fragment() {
    private lateinit var btnNext: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnNext = view.findViewById(R.id.to_video_btn)

        btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_articleFragment_to_videoFragment)
        }
    }
}