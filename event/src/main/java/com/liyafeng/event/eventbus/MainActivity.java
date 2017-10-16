package com.liyafeng.event.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.liyafeng.event.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends Activity {

    public static final String TAG = "test";

    /**
     * eventbus的线程模式
     * <p>
     * sticky模式 注解要加上条件，这个是一直在内存中，除非remove
     *
     * 优先级和事件的取消
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            int count= 0;
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(new Event("hi"+count++));
                Log.i(TAG, "onClick: " + Thread.currentThread().getName());
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void doSomething(Event event) {

        Log.i(TAG, "doSomething: " + Thread.currentThread().getName());
//        Toast.makeText(this, event.msg+ " do !", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public static class Event {
        public String msg;

        public Event(String msg) {
            this.msg = msg;
        }
    }
}
