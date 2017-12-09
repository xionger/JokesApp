package com.udacity.gradle.builditbigger.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.async.AsyncResponse;
import com.udacity.gradle.builditbigger.async.RetrieveJokesAsyncTask;
import com.xiongxh.androidjokes.ShowJokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements AsyncResponse {

    protected TextView mInstTextView;
    protected Button mTellJokeButton;
    protected ProgressBar mLoadingBar;

    private RetrieveJokesAsyncTask asyncTask;

    public MainActivityFragment() {
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

        return root;
    }

    public void tellJoke(){
        updateLoading(true);

        asyncTask = new RetrieveJokesAsyncTask(this);
        asyncTask.execute();
    }

    public void updateLoading(boolean loading){
        if (loading){
            mInstTextView.setVisibility(View.INVISIBLE);
            mTellJokeButton.setVisibility(View.INVISIBLE);
            mLoadingBar.setVisibility(View.VISIBLE);
        } else {
            mInstTextView.setVisibility(View.VISIBLE);
            mTellJokeButton.setVisibility(View.VISIBLE);
            mLoadingBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void processJokes(String out) {
        if (getActivity() == null) {
            return;
        }

        Intent intent = new Intent(getActivity(), ShowJokeActivity.class);
        intent.putExtra(ShowJokeActivity.INTENT_MAIN_JOKE, out);
        startActivity(intent);
    }

    @Override
    public void onStart(){
        super.onStart();
        if (asyncTask == null || asyncTask.getStatus() == AsyncTask.Status.FINISHED){
            updateLoading(false);
        }
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        mTellJokeButton.setOnClickListener(null);
        if (asyncTask != null){
            asyncTask.cancel(true);
        }
    }
}
