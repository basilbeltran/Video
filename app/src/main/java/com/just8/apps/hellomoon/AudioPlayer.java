package com.just8.apps.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * BB
 * Created by kandinski on 2015-07-29.
 */
public class AudioPlayer {

    private MediaPlayer mPlayer;
    private boolean isPaused = false;


    public void play(Context c){
        if(isPaused) {
            isPaused = false;
            mPlayer.start();
            return;
        }

        stop();
        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                stop();
            }
        });
        mPlayer.start();
    }

    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void pause() {
        isPaused = true;
        mPlayer.pause();
    }

}
