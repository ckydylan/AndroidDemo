package com.example.imageviewdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {

    int[] changeImg = new int[]{R.drawable.school,R.drawable.wallet1,R.drawable.wallet2};
    int nowIndex = 0;
    ImageView imageView;
    Button btnUp;
    Button btnDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.img_change);
        btnUp = findViewById(R.id.up_btn);
        btnDown = findViewById(R.id.dowm_btn);
        btnUp.setOnClickListener(this);
        btnDown.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.up_btn){
            if (nowIndex > 0){
                imageView.setImageResource(changeImg[--nowIndex]);
            }else if(nowIndex == 0){
                nowIndex = changeImg.length-1;
                imageView.setImageResource(changeImg[nowIndex]);
            }
        }

        if (v.getId() == R.id.dowm_btn){
            if (nowIndex < changeImg.length-1){
                imageView.setImageResource(changeImg[++nowIndex]);
            }else {
                nowIndex = 0;
                imageView.setImageResource(changeImg[nowIndex]);
            }
        }
    }
}
