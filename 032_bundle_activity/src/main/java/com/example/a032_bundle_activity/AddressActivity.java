package com.example.a032_bundle_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class AddressActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String name = bundle.getString("name");
        String phone = bundle.getString("phone");
        String site = bundle.getString("site");

        TextView t_name = (TextView)findViewById(R.id.name);
        TextView t_phone = (TextView)findViewById(R.id.phone);
        TextView t_site = (TextView)findViewById(R.id.site);

        t_name.setText(name);
        t_phone.setText(phone);
        t_site.setText(site);


    }
}
