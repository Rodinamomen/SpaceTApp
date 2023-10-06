package com.example.spacetapp.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.spacetapp.R

class AboutFragment : Fragment() {
    private lateinit var ivBack: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_about, container, false)
        ivBack.setOnClickListener {
            findNavController().navigate(R.id.action_aboutFragment_to_solarMapFragment)
        }
        return v
    }

}