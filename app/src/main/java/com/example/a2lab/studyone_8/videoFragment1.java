package com.example.a2lab.studyone_8;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link videoFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class videoFragment1 extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    View myView;
    MediaController mediacontroller;
    VideoView videoView;
    String uriPath;
    public videoFragment1() {
        // Required empty public constructor
    }

       public static videoFragment1 newInstance(String param1, String param2) {
        videoFragment1 fragment = new videoFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedIstanceState) {
        super.onViewCreated(view, savedIstanceState);
        getActivity().setTitle("video1");
        uriPath = "android.resource://com.example.a2lab.studyone_8/" + R.raw.brave360p;
        Uri uri2 = Uri.parse(uriPath);
        videoView.setVideoURI(uri2);
        videoView.setMediaController(mediacontroller);
        mediacontroller.setAnchorView(videoView);
//        videoView.start();
//        videoView.pause();


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        myView = inflater.inflate(R.layout.fragment_video1, container, false);
        videoView = (VideoView) myView.findViewById(R.id.videoView);
        mediacontroller=new MediaController(getActivity());
        return myView;
    }

}
