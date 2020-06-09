package com.example.radio_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg =(RadioGroup) findViewById(R.id.radioGroup1);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton r = (RadioButton)findViewById(checkedId);

                Toast.makeText(MainActivity.this,"性别："+r.getText(),Toast.LENGTH_LONG).show();
            }
        });

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0;i <rg.getChildCount();i++)
                {
                    RadioButton r = (RadioButton)rg.getChildAt(i);
                    if(r.isChecked())
                    {
                        Toast.makeText(MainActivity.this,r.getText(),Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }
        });
    }
}
