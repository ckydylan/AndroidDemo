package com.example.classfragmentdemo2;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    AnotherRightFragment fragment = new AnotherRightFragment();
    RightFragment fragment2 = new RightFragment();
    Boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (flag){
            transaction.replace(R.id.right_layout, fragment);
            transaction.commit();
        }else {
            transaction.replace(R.id.right_layout,fragment2);
            transaction.commit();
        }
       flag = !flag;

    }
}
