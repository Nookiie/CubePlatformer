package com.example.cubeplatformer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cubeplatformer.Common.GameTracker;

public class GameOverActivity extends AppCompatActivity {

    TextView scoreTextView;
    Button btnRetry, btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        scoreTextView = findViewById(R.id.scoreTextView);
        btnRetry = findViewById(R.id.retryBtn);
        btnMenu = findViewById(R.id.menuBtn);

        scoreTextView.setText(String.valueOf(GameTracker.getHighScore()));

        btnRetry.setOnClickListener(onClick);
        btnMenu.setOnClickListener(onClick);
    }

    View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.menuBtn:
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("retry", false);

                    startActivity(intent);
                    break;

                case R.id.retryBtn:
                    Intent retryIntent = new Intent(getApplicationContext(), MainActivity.class);
                    retryIntent.putExtra("retry", true);

                    startActivity(retryIntent);
                    break;
            }
        }
    };
}
