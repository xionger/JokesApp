package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * A simple {@link Fragment} subclass.
 */
public class JokeMainFragment extends MainActivityFragment {

    protected TextView mInstTextView;
    protected Button mTellJokeButton;
    protected ProgressBar mLoadingBar;

    public JokeMainFragment() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @NonNull ViewGroup container,
                             @NonNull Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mInstTextView = (TextView) root.findViewById(R.id.instructions_text_view);
        mTellJokeButton = (Button) root.findViewById(R.id.btn_joke_tell);

        mTellJokeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                tellJoke();
            }
        });

        mLoadingBar = (ProgressBar) root.findViewById(R.id.bar_loading);
        mLoadingBar.setVisibility(View.INVISIBLE);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        mAdView.setVisibility(View.VISIBLE);

        return root;
    }

}
