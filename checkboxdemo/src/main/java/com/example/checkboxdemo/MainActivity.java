package com.example.checkboxdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    CheckBox cBoxChinese;
    CheckBox cBoxEnglish;
    CheckBox cBoxMaths;
    CheckBox CBoxHistory;
    TextView changeText;
    String course;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cBoxChinese = findViewById(R.id.cbox_chinene);
        cBoxEnglish = findViewById(R.id.cbox_english);
        cBoxMaths = findViewById(R.id.cbox_maths);
        CBoxHistory = findViewById(R.id.cbox_history);
        changeText = findViewById(R.id.textview_change);

        cBoxChinese.setOnCheckedChangeListener(this);
        cBoxEnglish.setOnCheckedChangeListener(this);
        cBoxMaths.setOnCheckedChangeListener(this);
        CBoxHistory.setOnCheckedChangeListener(this);



    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        course = "";
        changeText.setText("");
        if (cBoxChinese.isChecked()){
            course += "  " + cBoxChinese.getText().toString();
        }
        if (cBoxEnglish.isChecked()){
            course += "  " + cBoxEnglish.getText().toString();
        }
        if (cBoxMaths.isChecked()){
            course += "  " + cBoxMaths.getText().toString();
        }
        if (CBoxHistory.isChecked()){
            course += "  " + CBoxHistory.getText().toString();
        }
        changeText.setText(course);
    }


}
