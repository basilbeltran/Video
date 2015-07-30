package com.just8.apps.hellomoon;

import android.support.v4.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

public class MoonVideoFragment extends Fragment {
    VideoView mVideoView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_moon_video, container, false);

        mVideoView = (VideoView) v.findViewById(R.id.moon_videoView);
        //Uri resourceUri = Uri.parse("android.resource://com.just8.apps.hellomoon/raw/apollo_17_stroll");
        Uri resourceUri = Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.apollo_17_stroll);

        mVideoView.setVideoURI(resourceUri);
        mVideoView.start();

        return v;
    }
}
