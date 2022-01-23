package com.example.youtubekids;

/*
    implementation 'com.github.bumptech.glide:glide:4.8.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.8.0'*/

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity {
    private static final String TAG="MainActivity";
    YouTubePlayerView mYouTubePlayerView;
    Button playBtn;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mYouTubePlayerView =  findViewById(R.id.youtubeplayerView);
        playBtn = findViewById(R.id.btnPlay);
        Log.d(TAG,"OnCreate: Starting");

        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG,"onInitializationSuccess: Starting");
                youTubePlayer.cueVideo("W4hTJybfU7s");
               // loadVideo("W4hTJybfU7s");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG,"onInitializationFailure: Starting");
            }
        };
        mYouTubePlayerView.initialize(YoutubeConfig.getApiKey(),mOnInitializedListener);


        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mYouTubePlayerView.initialize(YoutubeConfig.getApiKey(),mOnInitializedListener);
                Log.d(TAG,"setOnClickListenerPlay: Starting");
            }
        });
    }

}
