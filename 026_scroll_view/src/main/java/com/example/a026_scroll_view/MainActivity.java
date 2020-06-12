package com.example.a026_scroll_view;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout ll =(LinearLayout)findViewById(R.id.ll);
        LinearLayout ll2 = new LinearLayout(MainActivity.this);
        ll2.setOrientation(LinearLayout.VERTICAL);
        ScrollView scrollView = new ScrollView(MainActivity.this);
        ll.addView(scrollView);
        scrollView.addView(ll2);
        ImageView imageView = new ImageView(MainActivity.this);
        imageView.setImageResource(R.drawable.img03);
        ll2.addView(imageView);
        TextView textView = new TextView(MainActivity.this);
        textView.setText(R.string.content);
        textView.setTextSize(35);
        ll2.addView(textView);

    }
}
