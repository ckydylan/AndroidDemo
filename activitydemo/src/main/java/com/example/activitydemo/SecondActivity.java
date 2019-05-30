package com.example.activitydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {

    TextView tv_show_name;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        intent = getIntent();
        tv_show_name = findViewById(R.id.tv_show_name);
        tv_show_name.setText("亲爱的："+intent.getStringExtra("name"));

        findViewById(R.id.btn_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "不能放弃啊", Toast.LENGTH_SHORT).show();
                intent.putExtra("result","有信心");
                setResult(1,intent);
                finish();
            }
        });

        findViewById(R.id.btn_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "有信心就好,继续加油", Toast.LENGTH_SHORT).show();
                intent.putExtra("result","没有信心");
                setResult(1,intent);
                finish();
            }
        });
    }
}
