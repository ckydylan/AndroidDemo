package com.hooli.adaptdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.view.menu.MenuAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<MenuItem> dataList ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridViewMenu = findViewById(R.id.grid_view_menu);

        dataList = new ArrayList<>();
        dataList.add(new MenuItem("11",R.drawable.ic_launcher_background));
        dataList.add(new MenuItem("122",R.drawable.ic_launcher_background));
        dataList.add(new MenuItem("133",R.drawable.ic_launcher_background));

        MemuAdapt memuAdapt = new MemuAdapt();
        gridViewMenu.setAdapter(memuAdapt);
    }

     class MemuAdapt extends BaseAdapter {
        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public Object getItem(int position) {
            return dataList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View menuView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item,null);
            TextView tvMenuName = menuView.findViewById(R.id.tv_menu);
            tvMenuName.setText(dataList.get(position).menuName);

            ImageView imageView = menuView.findViewById(R.id.img_menu);
            imageView.setImageResource(dataList.get(position).menuDrawableId);

            return menuView;
        }
    }

    class MenuItem {
        String menuName;
        int menuDrawableId;

        MenuItem(String menuName, int menuDrawableId) {
            this.menuName = menuName;
            this.menuDrawableId = menuDrawableId;
        }
    }
}
