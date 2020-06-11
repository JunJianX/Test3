package com.example.a025_list_view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int [] imageid =new int[]{R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04,R.drawable.img05,
                R.drawable.img06,R.drawable.img07,R.drawable.img08,R.drawable.img09,};
        String []title = new String[]{"六一","陈二","张三","李四","王五","赵六","孙七","周八","吴九"};

        List<Map<String,Object>> listitem = new ArrayList<Map<String,Object>>();
        for(int i = 0;i<imageid.length;i++)
        {
            Map<String,Object>  map = new HashMap<String, Object>() ;
            map.put("image",imageid[i]);
            map.put("name",title[i]);
            listitem.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this,listitem,R.layout.main,new String[]{"name","image"},new int[]{R.id.title,R.id.image});
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String,Object> map =(Map<String, Object>) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,map.get("name").toString(),Toast.LENGTH_LONG).show();
            }
        });

        /*
        //使用Java代码创建ListView的方法
        String[] ctype = new String[]{"全部","图书","游戏","电视"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ctype);

        ListView listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);*/


    }
}
