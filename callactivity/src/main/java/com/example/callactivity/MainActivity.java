package com.example.callactivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button call_other_activity;
    Button call_this_activity;
    Button call_address_book;
    Button call_web;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        call_other_activity = findViewById(R.id.call_other_activity);
        call_this_activity = findViewById(R.id.call_this_activity);
        call_address_book = findViewById(R.id.call_address_book);
        call_web = findViewById(R.id.call_web);

        //调用其他应用activity
        call_other_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                ComponentName componentName = new ComponentName("com.example.myapplication","com.example.myapplication.MainActivity");
                intent.setComponent(componentName);
                startActivity(intent);
            }
        });

        //调用本应用activity
        call_this_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setAction("com.example.callactivity.IntentActivity");
                startActivity(intent);
            }
        });

        //调用通讯录
        call_address_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:10086");
                intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
        });

        //调用网页
        call_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.baidu.com/");
                intent = new Intent();
//                intent = new Intent(Intent.ACTION_VIEW,uri);
                intent.setAction("android.intent.action.VIEW");
                intent.setData(uri);
                startActivity(intent);
            }
        });

    }

}
