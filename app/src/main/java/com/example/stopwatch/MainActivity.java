package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    private Chronometer timeChrono;
    private boolean running;

    Button btnStart;
    Button btnPause;
    Button btnRestart;
    int second = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeChrono = findViewById(R.id.timeChorno);
        btnStart = findViewById(R.id.btnStart);
        btnPause = findViewById(R.id.btnPause);
        btnRestart = findViewById(R.id.btnRestart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               while (!running) {
                   timeChrono.setBase(SystemClock.elapsedRealtime());
                   timeChrono.start();
                   running = true;
               }
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if(running){
                while(running) {
                    timeChrono.stop();
                    running = false;
                }
              }
              else {


                  timeChrono.start();
                  running = true;
              }
            }
        });
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeChrono.setBase(SystemClock.elapsedRealtime());
                timeChrono.start();
                second=0;
            }
        });

    }
}