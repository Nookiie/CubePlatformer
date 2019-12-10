package com.example.cubeplatformer;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

public class GameActivity extends AppCompatActivity {

    private MainThread thead;

    public GameActivity(Context context){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
}
