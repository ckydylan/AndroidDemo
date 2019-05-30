package com.example.classspinnerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SpinnerAdaptActivity extends Activity {
    Map<String, Object> map;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_adapt);

        Spinner sp_show = findViewById(R.id.sp_show);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this
                , getData()
                , R.layout.list_show_data
                , new String[]{"img", "city"}
                , new int[]{R.id.img_left, R.id.tv_city});
        sp_show.setAdapter(simpleAdapter);


        sp_show.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(SpinnerAdaptActivity.this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private ArrayList<Map<String, Object>> getData() {
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        map = new HashMap<>();
        map.put("img", R.drawable.cap);
        map.put("city", "江宁区");
        list.add(map);

        map = new HashMap<>();
        map.put("img", R.drawable.doc);
        map.put("city", "栖霞区");
        list.add(map);

        map = new HashMap<>();
        map.put("img", R.drawable.iron_man);
        map.put("city", "栖霞区");
        list.add(map);

        map = new HashMap<>();
        map.put("img", R.drawable.logi);
        map.put("city", "栖霞区");
        list.add(map);

        map = new HashMap<>();
        map.put("img", R.drawable.thor);
        map.put("city", "栖霞区");
        list.add(map);

        return list;
    }
}
