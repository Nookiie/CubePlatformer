package com.example.cubeplatformer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnStartGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartGame = findViewById(R.id.buttonStart);
        btnStartGame.setOnClickListener(MainActivity.this);

        boolean isRetry = getIntent().getBooleanExtra("retry", false);

        if (isRetry) {
            btnStartGame.performClick();

        }

    }

    @Override
    public void onClick(View v) {
        GameFragment gameFragment = new GameFragment();

        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.placeHolder, gameFragment);

        transaction.commit();

    }
}