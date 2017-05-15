package com.example.weijunhao.asynctask;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private Button mButton;
    private int mTimes;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    updateText();
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };
    private Handler mHandler2 = new Handler();

    private void updateText() {
        mTextView.setText(mTimes + "");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.text_view);
        mButton = (Button) findViewById(R.id.button);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
               /* Message message = new Message();
                message.what = 1;
                mHandler.sendMessage(message);*/
               mHandler2.post(new Runnable() {
                   @Override
                   public void run() {
                       mTimes++;
                       Log.d("wjh", "run: " + mTimes);
                   }
               });
            }
        }, 1, 5000);
    }
}
