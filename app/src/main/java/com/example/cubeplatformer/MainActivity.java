package com.example.cubeplatformer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnStartGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartGame = findViewById(R.id.buttonStart);

    }

    View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.buttonStart:
                    Intent intent = new Intent(MainActivity.this, GameActivity.class);

                    startActivity(intent);
                    break;
                default:

                    break;
            }
        }
    };
}
