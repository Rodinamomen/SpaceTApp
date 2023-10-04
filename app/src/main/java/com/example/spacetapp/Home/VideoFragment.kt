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
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

class VideoFragment : Fragment() {
    private lateinit var youTubePlayerView: YouTubePlayerView
    private lateinit var ivNext: ImageView
    private lateinit var tvPlanetName: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_video, container, false)
        youTubePlayerView = view.findViewById(R.id.youtube_player_view)
        ivNext = view.findViewById(R.id.iv_next_video)
        tvPlanetName = view.findViewById(R.id.tv_planet_name)
        tvPlanetName.text = "Mercury"
        ivNext.setOnClickListener {
            findNavController().navigate(R.id.action_videoFragment_to_quizFragment)
        }

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer) {
                val videoId = "B588JHKSlEE"
                youTubePlayer.loadVideo(videoId, 0f)
                youTubePlayer.play()
            }
        })
        return view
    }
}
