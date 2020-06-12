package com.example.a032_bundle_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/*
* Intent为两个Activity之间的信使
* Bundle 是一个键值对的组合
*
* 数据--putXXX()--->Bundle--putExtras()-->Intent--startActivity()-->Activity
*
* */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = ((EditText)findViewById(R.id.name)).getText().toString();
                String site = ((EditText)findViewById(R.id.site)).getText().toString();
                String phone  = ((EditText)findViewById(R.id.phone)).getText().toString();
                if(name.isEmpty()||site.isEmpty()||phone.isEmpty())
                {
                    Toast.makeText(MainActivity.this,"信息不完整",Toast.LENGTH_SHORT).show();
                }else
                {
                    Intent intent = new Intent(MainActivity.this,AddressActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("name",name);
                    bundle.putCharSequence("phone",phone);
                    bundle.putCharSequence("site",site);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }

            }
        });


    }
}
