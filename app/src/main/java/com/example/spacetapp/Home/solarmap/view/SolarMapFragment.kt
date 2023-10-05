package com.example.spacetapp.Home.solarmap.view

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.spacetapp.Authentiaction.Login.view.LoginFragment
import com.example.spacetapp.Authentiaction.SignUp.Repo.signUpRepoImp
import com.example.spacetapp.Authentiaction.SignUp.viewmodel.signUpViewModel
import com.example.spacetapp.Authentiaction.SignUp.viewmodel.signUpViewModelFactory
import com.example.spacetapp.Home.solarmap.repo.solarMapRepoImp
import com.example.spacetapp.Home.solarmap.viewmodel.SolarMapViewModelFactory
import com.example.spacetapp.Home.solarmap.viewmodel.solarMapViewModel
import com.example.spacetapp.R
import com.example.spacetapp.localDataBase.localDataBaseImp
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import pl.droidsonroids.gif.GifImageView


class SolarMapFragment : Fragment() {
    companion object {
        const val EMAIL_KEY = "email_key"
    }
    lateinit var mercury : GifImageView
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: Editor
    lateinit var SolarMapViewModel: solarMapViewModel
    lateinit var questionImg: ImageView
     var flag: Int = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_solar_map, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mercury= view.findViewById(R.id.mercury)
        questionImg= view.findViewById(R.id.question_img)
        gettingViewModelReady(requireContext())
        sharedPreferences= requireActivity().getSharedPreferences(
            LoginFragment.SHARED_PREFS,
            Context.MODE_PRIVATE)
        editor=sharedPreferences.edit()
        SolarMapViewModel.userScore.observe(requireActivity()){ data ->
           if(flag>=0){
               findNavController().navigate(R.id.action_solarMapFragment_to_exploreFragment)
               flag= -1
           }else if (flag==-1 && data<0){
               MaterialAlertDialogBuilder(requireContext()).setTitle("").setMessage("Your score Must be 0 or more").setPositiveButton("Ok", null)
                   .show()
           }
        }
        mercury.setOnClickListener {
            flag=0
            var emailShared= sharedPreferences.getString(EMAIL_KEY,"null")
            emailShared?.let { it1 -> SolarMapViewModel.getUserScore(it1) }

        }
        questionImg.setOnClickListener{
            MaterialAlertDialogBuilder(requireContext()).setTitle("About Us").setMessage("Your score Must be 0 or more").setPositiveButton("Ok", null)
                .show()
        }
    }
    private fun gettingViewModelReady(context:Context){
        val solarMapViewModelFactory = SolarMapViewModelFactory(solarMapRepoImp(localDataBaseImp(context)))
       SolarMapViewModel= ViewModelProvider(this,solarMapViewModelFactory).get(solarMapViewModel::class.java)
    }
}