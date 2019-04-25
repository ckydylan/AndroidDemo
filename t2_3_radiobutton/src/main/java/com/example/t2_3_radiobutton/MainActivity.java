package com.example.t2_3_radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textViewShow;
    RadioButton radioButton20;
    RadioButton radioButton50;
    RadioButton radioButton100;
    Button showButton;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewShow = findViewById(R.id.show);
        radioButton20 = findViewById(R.id.radio_button_20);
        radioButton50 = findViewById(R.id.radio_button_50);
        radioButton100 = findViewById(R.id.radio_button_100);
        showButton = findViewById(R.id.show_btn);
        showButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
//        RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
//        textViewShow.setText(radioButton.getText());
        if (radioButton20.isChecked()){
            textViewShow.setText("20");
        }
        if (radioButton50.isChecked()){
            textViewShow.setText("50");
        }
        if (radioButton100.isChecked()){
            textViewShow.setText("100");
        }
    }
}
