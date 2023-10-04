package com.example.spacetapp.Authentiaction.Login.view

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.spacetapp.Authentiaction.Login.repo.loginRepoImp
import com.example.spacetapp.Authentiaction.Login.viewmodel.loginViewModel
import com.example.spacetapp.Authentiaction.Login.viewmodel.loginViewModelFactory
import com.example.spacetapp.Authentiaction.SignUp.Repo.signUpRepoImp
import com.example.spacetapp.Authentiaction.SignUp.viewmodel.signUpViewModel
import com.example.spacetapp.Authentiaction.SignUp.viewmodel.signUpViewModelFactory
import com.example.spacetapp.R
import com.example.spacetapp.localDataBase.localDataBaseImp
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {
    companion object {
        const val SHARED_PREFS = "shared_prefs"
        const val EMAIL_KEY = "email_key"
        const val PASSWORD_KEY = "password_key"
    }
    lateinit var editor: Editor
    lateinit var sharedPreferences: SharedPreferences
    lateinit var signup_txt:TextView
    lateinit var userEmail: TextInputLayout
    lateinit var userPassword: TextInputLayout
    lateinit var LoginViewModel: loginViewModel
    lateinit var loginBtn:Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences= requireActivity().getSharedPreferences(SHARED_PREFS,Context.MODE_PRIVATE)
        editor=sharedPreferences.edit()
        signup_txt= view.findViewById(R.id.signup_txt)
        userEmail=view.findViewById(R.id.email_textinput)
        userPassword=view.findViewById(R.id.password_textinput)
        loginBtn=view.findViewById(R.id.login_btn)
        gettingViewModelReady(requireContext())
        signup_txt.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
        LoginViewModel.isEmailExists.observe(requireActivity()) { flag ->
            LoginViewModel.isUserWithEmailExists.observe(requireActivity()) { data ->
                if (data != null) {
                    if (data) {
                        editor.putString(EMAIL_KEY,userEmail.editText?.text.toString())
                        editor.putString(PASSWORD_KEY,userPassword.editText?.text.toString())
                        editor.commit()
                        view.findNavController().navigate(R.id.action_loginFragment_to_homeActivity)
                        requireActivity().finish()
                    } else {
                        if (flag) {
                            Toast.makeText(context, "Invalid password", Toast.LENGTH_SHORT).show()
                        } else {
                            MaterialAlertDialogBuilder(requireContext()).setTitle("The Account Is Inactive").setMessage("By signing up, you can establish an account. ").setPositiveButton("Ok", null)
                                .show()
                        }
                    }
                }
            }
        }
        loginBtn.setOnClickListener {
            LoginViewModel.isUserWithEmailExists(userEmail.editText?.text.toString(), userPassword.editText?.text.toString())
            LoginViewModel.isEmailExists(userEmail.editText?.text.toString())
        }

    }
    private fun gettingViewModelReady(context: Context){
        val LoginViewModelFactory =loginViewModelFactory(loginRepoImp(localDataBaseImp(context)))
        LoginViewModel= ViewModelProvider(this,LoginViewModelFactory).get(loginViewModel::class.java)
    }

}