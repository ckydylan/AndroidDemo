package com.example.radiobuttonhomework;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    RadioGroup rGroup1;
    RadioGroup rGroup2;
    ImageView changeImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rGroup1 = findViewById(R.id.rgroup_1);
        rGroup2 = findViewById(R.id.rgroup_2);
        changeImg = findViewById(R.id.img_change);
        rGroup1.setOnCheckedChangeListener(listener1);
        rGroup2.setOnCheckedChangeListener(listener2);
    }

    RadioGroup.OnCheckedChangeListener listener1 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1){
                rGroup2.setOnCheckedChangeListener(null);
                rGroup2.clearCheck();
                rGroup2.setOnCheckedChangeListener(listener2);
            }

            switch (checkedId){
            case R.id.rbtn_spider:
                changeImg.setImageResource(R.drawable.spider);
                break;
            case R.id.rbtn_cap:
                changeImg.setImageResource(R.drawable.cap);
                break;
            case R.id.rbtn_ironMan:
                changeImg.setImageResource(R.drawable.iron_man);
                break;
            }
        }
    };

    RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId != -1){
                rGroup1.setOnCheckedChangeListener(null);
                rGroup1.clearCheck();
                rGroup1.setOnCheckedChangeListener(listener1);
            }
            switch (checkedId){
                case R.id.rbtn_thor:
                    changeImg.setImageResource(R.drawable.thor);
                    break;
                case R.id.rbtn_logi:
                    changeImg.setImageResource(R.drawable.logi);
                    break;
                case R.id.rbtn_doc:
                    changeImg.setImageResource(R.drawable.doc);
            }
        }
    };

//    @Override
//    public void onCheckedChanged(RadioGroup group, int checkedId) {
//        changeImg.setImageBitmap(BitmapFactory.decodeStream(getClass().getResourceAsStream("/res/drawable/"+findViewById(checkedId).getTransitionName()+".jpeg")));
//
//    }
}
