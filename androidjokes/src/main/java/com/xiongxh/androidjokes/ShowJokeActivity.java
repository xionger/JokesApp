package com.xiongxh.androidjokes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowJokeActivity extends AppCompatActivity {

    public final static String INTENT_MAIN_JOKE = "INTENT_MAIN_JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);

        String jokeFromMain = getIntent().getStringExtra(INTENT_MAIN_JOKE);
        TextView jokeView = (TextView) findViewById(R.id.tv_intent_joke);

        //Toast.makeText(this, jokeFromMain, Toast.LENGTH_SHORT).show();
        jokeView.setText(jokeFromMain);
    }
}
