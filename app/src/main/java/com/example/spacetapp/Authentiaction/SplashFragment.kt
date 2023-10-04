package com.example.spacetapp.Authentiaction

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.spacetapp.Authentiaction.Login.view.LoginFragment
import com.example.spacetapp.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch



class SplashFragment : Fragment() {
    companion object {
        const val EMAIL_KEY = "email_key"
        const val PASSWORD_KEY = "password_key"
    }
    lateinit var editor: SharedPreferences.Editor
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            delay(5000)
            sharedPreferences= requireActivity().getSharedPreferences(
                LoginFragment.SHARED_PREFS,
                Context.MODE_PRIVATE)
            editor=sharedPreferences.edit()
            if(sharedPreferences.getString(EMAIL_KEY,null)==null && sharedPreferences.getString(PASSWORD_KEY,null)==null){
                findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
            }else{
                findNavController().navigate(R.id.action_splashFragment_to_homeActivity)
                requireActivity().finish()
            }
        }
    }

}