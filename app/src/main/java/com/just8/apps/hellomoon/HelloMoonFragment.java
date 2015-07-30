package com.just8.apps.hellomoon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HelloMoonFragment extends Fragment {
    private Button mPlayButton;
    private Button mStopButton;
    private Button mPauseButton;
    private Button mVideoButton;
    private Button mPlayerButton;



    private AudioPlayer mPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPlayer = new AudioPlayer();

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup parent,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);
        mPlayButton = (Button)v.findViewById(R.id.hellomoon_playButton);
        mPlayButton.setOnClickListener(new View.OnClickListener(){
            public  void onClick (View v){
                mPlayer.play(getActivity());
            }
        });

        mStopButton = (Button)v.findViewById(R.id.hellomoon_stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener(){
            public  void onClick (View v){
                mPlayer.stop();
            }
        });

        mPauseButton = (Button)v.findViewById(R.id.hellomoon_pauseButton);
        mPauseButton.setOnClickListener(new View.OnClickListener(){
            public  void onClick (View v){
                mPlayer.pause();
            }
        });

        mVideoButton = (Button)v.findViewById(R.id.hellomoon_videoButton);
        mVideoButton.setOnClickListener(new View.OnClickListener(){
            public  void onClick (View v){
                Intent i = new Intent(getActivity(), com.just8.apps.hellomoon.MoonVideoActivity.class);
                startActivity(i);
            }
        });

        mPlayerButton = (Button)v.findViewById(R.id.hellomoon_playerButton);
        mPlayerButton.setOnClickListener(new View.OnClickListener(){
            public  void onClick (View v){
                Intent i = new Intent(getActivity(), com.just8.apps.hellomoon.MoonPlayerActivity.class);
                startActivity(i);
            }
        });

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }
}
