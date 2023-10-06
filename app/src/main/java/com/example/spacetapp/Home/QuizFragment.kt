package com.example.spacetapp.Home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.spacetapp.Authentiaction.Login.view.LoginFragment
import com.example.spacetapp.Home.solarmap.repo.solarMapRepoImp
import com.example.spacetapp.Home.solarmap.viewmodel.SolarMapViewModelFactory
import com.example.spacetapp.Home.solarmap.viewmodel.solarMapViewModel
import com.example.spacetapp.R
import com.example.spacetapp.localDataBase.localDataBaseImp

class QuizFragment : Fragment() {

    private lateinit var btnQ1A1: Button
    private lateinit var btnQ1A2: Button
    private lateinit var btnQ2A1: Button
    private lateinit var btnQ2A2: Button
    private lateinit var btnQ3A1: Button
    private lateinit var btnQ3A2: Button
    private lateinit var ivNext: ImageView
    private lateinit var tvPlanetName: TextView
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var scoreViewModel: solarMapViewModel


    companion object {
        var score = 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_quiz, container, false)

        // Find buttons by ID within the fragment's view
        btnQ1A1 = view.findViewById(R.id.btn_q1_a1)
        btnQ1A2 = view.findViewById(R.id.btn_q1_a2)
        btnQ2A1 = view.findViewById(R.id.btn_q2_a1)
        btnQ2A2 = view.findViewById(R.id.btn_q2_a2)
        btnQ3A1 = view.findViewById(R.id.btn_q3_a1)
        btnQ3A2 = view.findViewById(R.id.btn_q3_a2)

        ivNext = view.findViewById(R.id.iv_next_video)
        tvPlanetName = view.findViewById(R.id.tv_planet_name)
        tvPlanetName.text = "Quiz"
        score = 0
        setQ()
//        getEmail()
//        yourDatabase.userDao().updateUserScore("user@example.com", score)
        gettingViewModelReady(requireContext())
        scoreViewModel.updateUserScore(getEmail(), score)
        ivNext.setOnClickListener {
            findNavController().navigate(R.id.action_quizFragment_to_mapFragment)
        }

        return view
    }

    private fun getEmail(): String {
        sharedPreferences = requireActivity().getSharedPreferences(
            LoginFragment.SHARED_PREFS,
            Context.MODE_PRIVATE
        )
        return sharedPreferences.getString(LoginFragment.EMAIL_KEY, "").toString()
    }

    private fun gettingViewModelReady(context: Context) {
        val scoreViewModelFactory =
            SolarMapViewModelFactory(solarMapRepoImp(localDataBaseImp(context)))
        scoreViewModel = ViewModelProvider(
            requireActivity(),
            scoreViewModelFactory
        ).get(solarMapViewModel::class.java)
    }

    private fun setQ() {
        val buttonsQ1 = listOf(btnQ1A2, btnQ1A1)
        val buttonsQ2 = listOf(btnQ2A1, btnQ2A2)
        val buttonsQ3 = listOf(btnQ3A1, btnQ3A2)

        for (button in buttonsQ1) {
            button.setOnClickListener {
                if (button == btnQ1A2) {
                    score++
                    button.setBackgroundResource(R.drawable.shape_true_btn)
                    btnQ1A1.isEnabled = false
                } else {
                    button.setBackgroundResource(R.drawable.shape_wrong_btn)
                    btnQ1A2.isEnabled = false
                }

            }
        }
        for (button in buttonsQ2) {
            button.setOnClickListener {
                if (button == btnQ2A1) {
                    score++
                    button.setBackgroundResource(R.drawable.shape_true_btn)
                    btnQ2A2.isEnabled = false

                } else {
                    button.setBackgroundResource(R.drawable.shape_wrong_btn)
                    btnQ2A1.isEnabled = false
                }
            }
        }
        for (button in buttonsQ3) {
            button.setBackgroundResource(R.drawable.shape_normal_btn)
            button.setOnClickListener {
                if (button == btnQ3A2) {
                    score++
                    button.setBackgroundResource(R.drawable.shape_true_btn)
                    btnQ3A1.isEnabled = false
                } else {
                    button.setBackgroundResource(R.drawable.shape_wrong_btn)
                    btnQ3A2.isEnabled = false
                }
            }
        }

    }
}