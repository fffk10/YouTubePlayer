package com.example.youtubeplayer2

import android.os.Bundle
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class MainActivity : YouTubeBaseActivity() {

    private val API_KEY = "AIzaSyByf0iOXgeOjPDKgDPgnnTfBV_hwWMOzJY"
    private val YOUTUBE_ID = "yXZd7xVdpJ0"
    private val PLAYLIST_ID = "PLeLvSt3A0Ddk9lGjNqmzT0ctVPA5xfinn"

    lateinit var mYouTubePlayerView: YouTubePlayerView
    lateinit var mOnInitializedListener: YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mYouTubePlayerView = findViewById(R.id.Youtube_view)

        mOnInitializedListener = object: YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(provider: YouTubePlayer.Provider, youTubePlayer: YouTubePlayer, b: Boolean) {
                // 指定した動画を再生
                // youTubePlayer.loadVideo(YOUTUBE_ID)

                // プレイリストを再生
                youTubePlayer.cuePlaylist(PLAYLIST_ID)
            }

            override fun onInitializationFailure(provider: YouTubePlayer.Provider, result: YouTubeInitializationResult) {
            }
        }

        mYouTubePlayerView.initialize(API_KEY, this.mOnInitializedListener)
    }
}