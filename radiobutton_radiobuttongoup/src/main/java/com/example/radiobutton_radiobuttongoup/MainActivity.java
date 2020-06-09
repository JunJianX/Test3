package com.example.radiobutton_radiobuttongoup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.bt1);
        rg = (RadioGroup)findViewById(R.id.radiogroup1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<rg.getChildCount();i++)
                {
                    RadioButton rb = (RadioButton)rg.getChildAt(i);
                    if(rb.isChecked())
                    {
                        if(rb.getText().equals("B:100"))
                        {
                            Toast.makeText(MainActivity.this,"回答正确",Toast.LENGTH_LONG).show();
                        }else
                        {
                            Toast.makeText(MainActivity.this,"回答错误",Toast.LENGTH_LONG).show();
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setMessage("咋又做错了啊？");
                            builder.setPositiveButton("确定",null).show();
//                            builder.setNegativeButton("取消",null).show();
                        }
                        break;
                    }
                }
            }
        });
    }
}
