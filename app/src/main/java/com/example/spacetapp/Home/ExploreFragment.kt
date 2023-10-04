package com.example.spacetapp.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.spacetapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class ExploreFragment : Fragment() {
    lateinit var exploreBtn: FloatingActionButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exploreBtn= view.findViewById(R.id.explore_btn)
        exploreBtn.setOnClickListener {
            findNavController().navigate(R.id.action_exploreFragment_to_articleFragment)
        }
    }
}