package com.example.splashandcountertimeactivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView txtTimer;
    TextView txtTimerElappsed;
    Button btnReset;
    private final long startTime = 50 * 1000;
    private final long interval = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTimer = (TextView) findViewById(R.id.txt_time);
        txtTimerElappsed = (TextView) findViewById(R.id.txt_time_elappsed);
        btnReset = (Button) findViewById(R.id.btn_reset_timer);
        final CountDownTimer countDownTimer = new CountDownTimer(startTime, interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                txtTimer.setText("Time:" + millisUntilFinished / 1000);
                txtTimerElappsed.setText("Time Elappsed:" + (startTime - millisUntilFinished) / 1000);
            }

            @Override
            public void onFinish() {
                txtTimer.setText("Finished Timer");
            }
        };
        countDownTimer.start();
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                countDownTimer.start();
            }
        });
    }
}