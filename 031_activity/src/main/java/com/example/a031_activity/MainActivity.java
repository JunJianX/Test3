package com.example.a031_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/*
* 将Activity设置为程序的入口,AndroidManifest.xml
*             <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />作为启动项
            </intent-filter>
            * 或者使用startActivity
* */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Activity生命周期","onCreate()方法调用");

        Button button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Activity生命周期","onStart()方法调用");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Activity生命周期","onResume()方法调用");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Activity生命周期","onPause()方法调用");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Activity生命周期","onStop()方法调用");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Activity生命周期","onDestoroy()方法调用");
    }
}
