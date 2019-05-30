package com.example.ontouchdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView image;
    private TextView tv;
    int screenWidth,screenHeight;
    private long startTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.image);
        tv = findViewById(R.id.text_showLocation);

        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;

        image.setOnTouchListener(new PicOnTouchListenr());
    }



    class PicOnTouchListenr implements View.OnTouchListener{

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            float x = event.getRawX();
            float y = event.getRawY() - 100;
            int left = (int) (x + 0.5);
            int top = (int) (y + 0.5);
            int rignt = screenWidth - left - 100;
            int bottom = screenHeight- top - 100;
            //设置布局参数
            ViewGroup.MarginLayoutParams margin = new ViewGroup.MarginLayoutParams(image.getLayoutParams());
            margin.setMargins(left,top,rignt,bottom);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(margin);
            layoutParams.width = 100;
            layoutParams.height = 100;
            image.setLayoutParams(layoutParams);
            String sInfo = "当前坐标 X:" + x + ",Y:" + y;
            tv.setText(sInfo);
            return false;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if ((System.currentTimeMillis()- startTime) > 2000){
                Toast.makeText(getApplicationContext(),"再按一次退出程序",Toast.LENGTH_LONG).show();
                startTime = System.currentTimeMillis();
            }
            else {
                finish();
                System.exit(0);
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
