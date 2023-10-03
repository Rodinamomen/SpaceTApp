package com.example.spacetapp.Authentiaction.SignUp.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.spacetapp.Authentiaction.SignUp.Repo.signUpRepo
import com.example.spacetapp.Authentiaction.SignUp.Repo.signUpRepoImp
import com.example.spacetapp.Authentiaction.SignUp.viewmodel.signUpViewModel
import com.example.spacetapp.Authentiaction.SignUp.viewmodel.signUpViewModelFactory
import com.example.spacetapp.R
import com.example.spacetapp.dataBase.User
import com.example.spacetapp.localDataBase.localDataBase
import com.example.spacetapp.localDataBase.localDataBaseImp
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout


class SignUpFragment : Fragment() {
    lateinit var userName: TextInputLayout
    lateinit var userEmail: TextInputLayout
    lateinit var userPassword: TextInputLayout
    lateinit var signupBtn: Button
    lateinit var logintxt: TextView
    lateinit var SignUpViewModel: signUpViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userName=view.findViewById(R.id.username_textinput_signup)
        userEmail=view.findViewById(R.id.email_textinput_signup)
        userPassword=view.findViewById(R.id.password_textinput_signup)
        signupBtn= view.findViewById(R.id.signup_btn)
        logintxt=view.findViewById(R.id.login_txt)
        gettingViewModelReady(requireContext())
       SignUpViewModel.isEmailExists.observe(requireActivity()){ data ->
            if(data){
                MaterialAlertDialogBuilder(requireContext()).setTitle("The Account Is Signed In").setMessage("That email address is associated with a user account.").setPositiveButton("Ok", null)
                    .show()
            } else {
                isValidData(userEmail.editText?.text.toString(), userName.editText?.text.toString(), userPassword.editText?.text.toString())
            }
        }
        signupBtn.setOnClickListener {
            SignUpViewModel.isEmailExists(userEmail.editText?.text.toString())
        }
        logintxt.setOnClickListener {
            findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }


    }
    private fun gettingViewModelReady(context:Context){
       val SignUpViewModelFactory = signUpViewModelFactory(signUpRepoImp(localDataBaseImp(context)))
        SignUpViewModel= ViewModelProvider(this,SignUpViewModelFactory).get(signUpViewModel::class.java)
    }
    private fun isValidEmail(email :String):Boolean{
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        return email.matches(emailRegex.toRegex())
    }
    private fun isValidName(name:String):Boolean{
        val nameRegex="^[A-Za-z]{3,30}\$"
        return name.matches(nameRegex.toRegex())
    }
    private fun isValidPassword(password:String):Boolean{
        val passwordRegex="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,8}$"
        return password.matches(passwordRegex.toRegex())
    }
    private fun isValidData(email:String,userName:String,password: String){
        if( isValidName(userName)&& isValidPassword(password) &&isValidEmail(email)){
            SignUpViewModel.insertUser(
               User(userName =userName, userPassword = password, userEmail = email , userScore = 0)
            )
            Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
            view?.findNavController()?.navigate(R.id.action_signUpFragment_to_homeActivity)
            requireActivity().finish()
        }
        if(!isValidName(userName)) {
            MaterialAlertDialogBuilder(requireContext()).setTitle("Invalid Username").setMessage("In the first name, there must be 3 to 30 letters, either capital or small").setPositiveButton("Ok", null)
                .show()
        }
        if(!isValidPassword(password)){
            MaterialAlertDialogBuilder(requireContext()).setTitle("Invalid Password").setMessage("A password must have between four and eight letters, both lowercase and uppercase letters, and contain special characters.").setPositiveButton("Ok", null)
                .show()
        }
        if(!isValidEmail(email)){
            Toast.makeText(context, "invalid Email", Toast.LENGTH_SHORT).show()
            MaterialAlertDialogBuilder(requireContext()).setTitle("Invalid Email").setMessage("Check that the email you entered is a valid email").setPositiveButton("Ok", null)
                .show()
        }
    }


}