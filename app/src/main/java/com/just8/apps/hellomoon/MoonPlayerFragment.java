package com.just8.apps.hellomoon;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

public class MoonPlayerFragment extends Fragment {
    SurfaceView mSurfaceView;
    MediaPlayer mPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_moon_player, container, false);
            mSurfaceView = (SurfaceView) v.findViewById(R.id.moon_surfaceView);
            SurfaceHolder mSurfaceHolder = mSurfaceView.getHolder();
            mSurfaceHolder.addCallback(new SurfaceHolderCallback());
        return v;
    }

    class SurfaceHolderCallback implements SurfaceHolder.Callback {
        @Override
        public void surfaceCreated(SurfaceHolder mSurfaceHolder)
        {
            mPlayer = MediaPlayer.create(getActivity(), R.raw.apollo_17_stroll);
            mPlayer.setDisplay(mSurfaceHolder);
            mPlayer.setOnCompletionListener(new VideoCompletionListener());
            mPlayer.setOnPreparedListener(new VideoPreparedListener());
        }

        @Override public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) { }
        @Override public void surfaceDestroyed(SurfaceHolder surfaceHolder) { }
    }

    class VideoCompletionListener implements MediaPlayer.OnCompletionListener {
        @Override public void onCompletion(MediaPlayer mediaPlayer) {getActivity().finish();}
    }

    class VideoPreparedListener implements MediaPlayer.OnPreparedListener {
        @Override public void onPrepared(MediaPlayer mediaPlayer) {mPlayer.start();}
    }

    @Override
    public void onDestroy() {

        mPlayer.release();
        mPlayer = null;
        super.onDestroy();
    }

}
