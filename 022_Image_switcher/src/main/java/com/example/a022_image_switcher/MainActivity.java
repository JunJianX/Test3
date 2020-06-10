package com.example.a022_image_switcher;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    private int[] arrayPic =
            new int[]{R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,R.drawable.img10};
    private ImageSwitcher imageSwitcher;
    private  int index;
    private float touch_down_x,touch_up_x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        imageSwitcher = (ImageSwitcher)findViewById(R.id.imageswitch1);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(arrayPic[index]);
                return imageView;
            }
        });
        imageSwitcher.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN)
                {
                    touch_down_x = event.getX();
                    return true;
                }else if(event.getAction()==MotionEvent.ACTION_UP)
                {
                    touch_up_x = event.getX();
                    if(touch_up_x-touch_down_x>100)//从左向右滑动
                    {
                        index = index==0?arrayPic.length-1:index-1;
                        imageSwitcher.setImageResource(arrayPic[index]);
                    }
                    if(touch_down_x-touch_up_x>100)
                    {
                        index = index ==arrayPic.length-1?0:index+1;
                        imageSwitcher.setImageResource(arrayPic[index]);
                    }
                    return true;
                }
                return false;
            }
        });
    }
}
