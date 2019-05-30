package com.example.classadaptdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    Map<String, Object> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView lv_show_text = findViewById(R.id.lv_show_text);
        //ArrayAdapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getData());

        //SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this
                , getData2()
                , R.layout.activity_show
                , new String[]{"image", "title", "info"}
                , new int[]{R.id.my_image, R.id.tv_title, R.id.tv_info});

        //lv_show_text.setAdapter(simpleAdapter);
        lv_show_text.setAdapter(arrayAdapter);
        lv_show_text.setOnItemClickListener(this);

    }

    private List<String> getData() {
        List<String> list = new ArrayList<>();
        list.add("语文");
        list.add("数学");
        list.add("英语");
        list.add("物理");
        list.add("化学");
        list.add("政治");
        list.add("历史");
        list.add("生物");
        list.add("地理");
        list.add("语文");
        list.add("数学");
        list.add("英语");
        list.add("物理");
        list.add("化学");
        list.add("政治");
        list.add("历史");
        list.add("生物");
        list.add("地理");

        return list;
    }

    private ArrayList<Map<String, Object>> getData2() {
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        map = new HashMap<>();
        map.put("image", R.drawable.cap);
        map.put("title", "美队");
        map.put("info", "我是美队");
        list.add(map);

        map = new HashMap<>();
        map.put("image", R.drawable.thor);
        map.put("title", "雷神");
        map.put("info", "我是雷神");
        list.add(map);

        map = new HashMap<>();
        map.put("image", R.drawable.iron_man);
        map.put("title", "钢铁侠");
        map.put("info", "我是钢铁侠");
        list.add(map);

        map = new HashMap<>();
        map.put("image", R.drawable.logi);
        map.put("title", "洛基");
        map.put("info", "我是洛基");
        list.add(map);

        return list;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(MainActivity.this, getData().get(position) + "onClick", Toast.LENGTH_SHORT).show();
    }

}
