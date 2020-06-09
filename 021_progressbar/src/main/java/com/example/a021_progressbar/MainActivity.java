package com.example.a021_progressbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pb;
    private int mProgress = 0;
    private Handler mHandler;//消息处理组件
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        pb =(ProgressBar) findViewById(R.id.progressbar);
        mHandler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                if(msg.what==0)
                {
                    pb.setProgress(mProgress);
                }else
                {
                    pb.setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this,"耗时操作已完成",Toast.LENGTH_LONG).show();
                }
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    mProgress = do_work();
                    Message m = new Message();
                    if (mProgress < 100) {
                        m.what = 0;
                        mHandler.sendMessage(m);
                    } else {
                        m.what = 1;
                        mHandler.sendMessage(m);
                        break;
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            public int do_work()
            {
                mProgress += Math.random()*5;
                return mProgress;
            }
        }).start();
    }
}
