package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //使用匿名内部类为按钮设置

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"单击了按钮1",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void myClick(View view){
        Toast.makeText(MainActivity.this,"单击了按钮2",Toast.LENGTH_SHORT).show();
    }
}
