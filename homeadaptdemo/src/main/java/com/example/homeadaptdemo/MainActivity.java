package com.example.homeadaptdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Map<String, Object> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv_show = findViewById(R.id.lv_show);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this
                , getData()
                , R.layout.activity_show
                , new String[]{"image", "title", "author","rightImg"}
                , new int[]{R.id.my_images, R.id.tv_titles, R.id.tv_authors,R.id.img_right});
        lv_show.setAdapter(simpleAdapter);

    }

    private ArrayList<Map<String, Object>> getData() {
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        map = new HashMap<>();
        map.put("image",R.drawable.img1);
        map.put("title","陪我长大");
        map.put("author","火箭少女101段奥娟");
        map.put("rightImg",R.drawable.img_right);
        list.add(map);

        map = new HashMap<>();
        map.put("image",R.drawable.img2);
        map.put("title","身骑白马");
        map.put("author","徐佳莹");
        map.put("rightImg",R.drawable.img_right);
        list.add(map);

        map = new HashMap<>();
        map.put("image",R.drawable.img3);
        map.put("title","倒数");
        map.put("author","G.E.M.邓紫棋");
        map.put("rightImg",R.drawable.img_right);
        list.add(map);

        map = new HashMap<>();
        map.put("image",R.drawable.img4);
        map.put("title","某某");
        map.put("author","孟凡明");
        map.put("rightImg",R.drawable.img_right);
        list.add(map);

        map = new HashMap<>();
        map.put("image",R.drawable.img5);
        map.put("title","爱殇");
        map.put("author","小时/龚骏");
        map.put("rightImg",R.drawable.img_right);
        list.add(map);


        return list;
    }
}
