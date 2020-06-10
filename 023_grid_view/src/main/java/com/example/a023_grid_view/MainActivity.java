package com.example.a023_grid_view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private  int [] picture = new int[]{R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04,R.drawable.img05,
            R.drawable.img06,R.drawable.img07,R.drawable.img08,R.drawable.img09};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //使用simple Adapter
        GridView gridView = (GridView)findViewById(R.id.gridview);
        List<Map<String,Object>> listitem =new ArrayList<Map<String,Object>>();

        //通过for循环将内容添加到List里面
        for(int i = 0;i<picture.length;i++)
        {
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("image1",picture[i]);
            listitem.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listitem,R.layout.cell,new String[]{"image1"},new int[]{R.id.image});
        gridView.setAdapter(simpleAdapter);

    }
}
