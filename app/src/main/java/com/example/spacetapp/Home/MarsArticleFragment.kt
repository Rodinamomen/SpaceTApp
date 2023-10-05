package com.example.spacetapp.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.spacetapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MarsArticleFragment : Fragment() {
    private lateinit var ivNext: ImageView
    private lateinit var tvPlanetName: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article_mars, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivNext = view.findViewById(R.id.iv_next_video)
        tvPlanetName = view.findViewById(R.id.tv_planet_name)
        tvPlanetName.text = "Mars"

        ivNext.setOnClickListener {
            findNavController().navigate(R.id.action_marsArticleFragment_to_marsVideoFragment)
        }
    }
}