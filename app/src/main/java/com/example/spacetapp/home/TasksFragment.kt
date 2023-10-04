package com.example.spacetapp.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.spacetapp.R

class TasksFragment : Fragment() {


    private lateinit var cbArticle: CheckBox
    private lateinit var cbVideo: CheckBox
    private lateinit var cbQuiz: CheckBox
    private lateinit var btn: Button
    private lateinit var tvError: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cbArticle = view.findViewById(R.id.cb_article)
        cbVideo = view.findViewById(R.id.cb_video)
        cbQuiz = view.findViewById(R.id.cb_quiz)
        tvError = view.findViewById(R.id.tv_error)
        btn = view.findViewById(R.id.btn_submit_tasks)

        btn.setOnClickListener {
            if (cbQuiz.isChecked && cbVideo.isChecked && cbArticle.isChecked) {
                tvError.visibility = View.GONE

                Toast.makeText(requireContext(), "Accepted", Toast.LENGTH_SHORT).show()
            } else {

                if (!cbQuiz.isChecked) {
                    tvError.visibility = View.VISIBLE

                }
                if (!cbArticle.isChecked) {
                    tvError.visibility = View.VISIBLE


                }
                if (!cbVideo.isChecked) {
//                    cbVideo.text = "Please complete the video"
//                    cbVideo.setTextColor(Color.parseColor("#FF0000"))
                    tvError.visibility = View.VISIBLE

                }
            }
        }

        cbArticle.setOnClickListener {
            findNavController().navigate(R.id.action_tasksFragment_to_articleFragment)
        }

        cbVideo.setOnClickListener {
            findNavController().navigate(R.id.action_tasksFragment_to_videoFragment)

        }

        cbQuiz.setOnClickListener {
            findNavController().navigate(R.id.action_tasksFragment_to_quizFragment)

        }
    }
}