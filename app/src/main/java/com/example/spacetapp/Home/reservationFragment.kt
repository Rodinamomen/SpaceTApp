package com.example.spacetapp.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import com.example.spacetapp.R


class ReservationFragment : Fragment(), AdapterView.OnItemSelectedListener {
    private val planetNames = arrayOf(
        "Mercury", "Venus", "Earth", "Mars",
        "Jupiter", "Saturn", "Uranus"
    )
    private lateinit var spinner: Spinner
    private lateinit var btnBook: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reservation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spinner = view.findViewById(R.id.spinner_planets)
        btnBook = view.findViewById(R.id.btn_book)

        spinner.onItemSelectedListener = this

        btnBook.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "RESERVED",
                Toast.LENGTH_LONG
            ).show()
        }

        val ad: ArrayAdapter<String> = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            planetNames
        )

        ad.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        spinner.adapter = ad
    }

    override fun onItemSelected(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
//        Toast.makeText(
//            requireContext(),
//            planetNames[position],
//            Toast.LENGTH_LONG
//        ).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        // Handle the case where nothing is selected
    }
}