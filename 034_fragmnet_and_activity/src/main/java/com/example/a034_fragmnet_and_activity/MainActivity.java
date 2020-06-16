package com.example.a034_fragmnet_and_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

/*Fragmnet 与Activity的生命周期相同,Activity暂停时,Fragment也会暂停.
*
*一个Activity可以包含多个Fragment
* 一个Fragment也可以被多个Activity所包含.
*
* 创建Fragment  继承该类 extends Fragement
*
* 两种在Activity中添加Fragment的方法
* 方法一：直接在布局文件中添加
* 创建三个类,每个类都要有自己对应的布局文件,第一个是程序的入口,第二个和第三个是继承Fragment类的,
* 它们的布局文件中写入要显示的内容.Mainactivity的布局文件要有两个fragment,并且都要指定name和ID
*
* 方法二:Activity运行时动态添加Fragment
*
* */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DetailFragment detailFragment = new DetailFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();//和教程不一样
        ft.add(R.id.fl,detailFragment);
        ft.commit();
    }
}
