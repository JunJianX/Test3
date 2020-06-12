package com.example.a033_startactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeadActivity extends Activity {
    private int [] pic = new int[]{
        R.drawable.img01,R.drawable.img02,R.drawable.img03,
            R.drawable.img04,R.drawable.img05,R.drawable.img06,
            R.drawable.img07,R.drawable.img08,R.drawable.img09,
            R.drawable.img10
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);

        GridView gridView = (GridView)findViewById(R.id.gd);
//        List<Map<String,Object>> listitem = new ArrayList<Map<String,Object>>();
//        for (int i = 0;i<pic.length;i++)
//        {
//            Map<String ,Object> map = new HashMap<String,Object>();
//            map.put("image",pic[i]);
//            listitem.add(map);
//        }
//
//        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listitem,R.layout.activity_head,new String[]{"image"},new int[]{R.id.imageView});
//        gridView.setAdapter(simpleAdapter);

        BaseAdapter adapter = new BaseAdapter() {

            @Override
            public int getCount() {
                return pic.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView imageView;
                if(convertView==null)
                {
                    imageView = new ImageView(HeadActivity.this);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxWidth(158);
                    imageView.setMaxHeight(150);
                    imageView.setPadding(5,5,5,5);
                }else{
                    imageView = (ImageView)convertView;
                }
                imageView.setImageResource(pic[position]);
                return imageView;
            }
        };

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = getIntent();
                Bundle bundle = new Bundle();
                bundle.putInt("imageId",pic[position]);
                intent.putExtras(bundle);
                setResult(0x11,intent);
                finish();
            }
        });

    }
}
