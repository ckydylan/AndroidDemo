package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;

public class ThridActivity extends Activity {

    SeekBar seekBar;
    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        seekBar = findViewById(R.id.my_seek_bar);
        textView = findViewById(R.id.seekbar_value);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        progressBar = findViewById(R.id.progress);
        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setProgress(progressBar.getProgress() +1);
            }
        });

        findViewById(R.id.btn_dec).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setProgress(progressBar.getProgress() -1);
            }
        });

        DatePicker datePicker = findViewById(R.id.my_date_pic);
        datePicker.getYear();
        datePicker.getMonth();
        datePicker.getDayOfMonth();

        TimePicker timePicker = findViewById(R.id.my_time_pic);
        timePicker.getHour();
        timePicker.getMinute();

        Button bt_start = findViewById(R.id.btn_next_4);
        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("for_avtivity");
                startActivity(intent);

            }
        });
    }

}
