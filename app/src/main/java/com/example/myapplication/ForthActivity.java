package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ForthActivity extends Activity {
    ImageView imgHead;
    TextView showIpText;
    EditText editTextIp;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);

        imgHead = findViewById(R.id.head_img);
        showIpText = findViewById(R.id.tv_showIp);
        editTextIp = findViewById(R.id.ed_ip);

        //限制edittext输入9个字符
        editTextIp.setFilters(new InputFilter[]{new InputFilter.LengthFilter(9)});

        editTextIp.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                switch (event.getAction()){
                    case KeyEvent.ACTION_UP:
                        String ip = editTextIp.getText().toString();
                        String newIp = "";
                        int size = ((ip.length())%3 == 0) ? ((ip.length())/3):((ip.length())/3 + 1);
                        for(int i=0;i<size ;i++){
                            int endIndex = (i+1)*3;
                            if((i+1)==size){
                                endIndex = ip.length();
                            }
                            if(i==0){
                                newIp += ip.substring(i,endIndex);
                            }else{
                                newIp += ","+ip.substring(i*3, endIndex);
                            }
                        }
                        showIpText.setText(newIp);
                        break;
                    case KeyEvent.ACTION_DOWN:
                        break;
                }
                return false;
            }
        });


    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            String pos = "";
            float x = event.getX();
            float y = event.getY();
            pos = "x轴坐标:" + x + "y轴坐标:" + y;
            Toast.makeText(this,pos,Toast.LENGTH_SHORT).show();
        }else if (event.getAction() == MotionEvent.ACTION_UP){
            Toast.makeText(this,"手指抬起",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
