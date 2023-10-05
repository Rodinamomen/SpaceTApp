package com.example.spacetapp.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.spacetapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MarsExploreFragment : Fragment() {
    private lateinit var exploreBtn: FloatingActionButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_explore_mars, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exploreBtn= view.findViewById(R.id.explore_btn)
        exploreBtn.setOnClickListener {
            findNavController().navigate(R.id.action_marsExploreFragment_to_marsArticleFragment)
        }
    }
}