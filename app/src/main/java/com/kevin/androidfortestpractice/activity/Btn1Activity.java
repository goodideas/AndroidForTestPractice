package com.kevin.androidfortestpractice.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kevin.androidfortestpractice.R;
import com.kevin.androidfortestpractice.views.ArrayWheelAdapter;
import com.kevin.androidfortestpractice.views.NumericWheelAdapter;
import com.kevin.androidfortestpractice.views.OnWheelChangedListener;
import com.kevin.androidfortestpractice.views.OnWheelScrollListener;
import com.kevin.androidfortestpractice.views.WheelView;

import java.util.Stack;

public class Btn1Activity extends AppCompatActivity {

    private static final String TAG = "Btn1Activity";
    private WheelView wheel;
    private Toast toast;
    private Button btnTest;
    private EditText etNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn1);
        btnTest = (Button) findViewById(R.id.btnTest);
        etNumber = (EditText) findViewById(R.id.etNumber);
        wheel = (WheelView) findViewById(R.id.wheel);
        String n[] = new String[5];
        if (n == null || (n != null && n.length == 0)) {

            Log.e(TAG, "长度为空");
        }
        wheel.setAdapter(new ArrayWheelAdapter<>(new String[]{
                "位置:1 速度:1 内容:前进 RFID:1234567980123456",
                "位置:2 速度:1 内容:左转 RFID:sadasdasddasdasd",
                "位置:3 速度:1 内容:左转 RFID:fcfhgfhgfuydrgdr",
                "位置:4 速度:1 内容:前进 RFID:fdsf45ds4fsd4f3s",
                "位置:5 速度:1 内容:右转 RFID:gdf31g32fd1gfd13",
                "位置:6 速度:1 内容:前进 RFID:dsf13esfds13f1ds",
                "位置:7 速度:1 内容:左转 RFID:ds4yt44g5d4g5r4t",
                "位置:8 速度:1 内容:左转 RFID:grtg5f4g8r4de54d",
                "位置:9 速度:1 内容:前进 RFID:esryt8kj87awwtf4",
                "位置:10 速度:1 内容:前进 RFID:asd45s4f5ds4fs4",
                "位置:11 速度:1 内容:右转 RFID:r4g5464fds4g4gg",
                "位置:12 速度:1 内容:前进 RFID:sad5456fd4f4ds6"
        }));
//        wheel.setAdapter(new ArrayWheelAdapter<>(n));
        wheel.setCyclic(true);
        wheel.TEXT_SIZE = 20;

        wheel.addChangingListener(new OnWheelChangedListener() {
            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                showInfo("newValue=" + newValue + " oldValue=" + oldValue);
                Log.e(TAG, "newValue=" + newValue + " oldValue=" + oldValue);
            }
        });


        wheel.setCurrentItem(5);

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wheel.setCurrentItem(Integer.parseInt(etNumber.getText().toString()));
                String m = wheel.getAdapter().getItem(wheel.getCurrentItem());
                Log.e(TAG, "m=" + m);
            }
        });

        wheel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                showInfo("2s1d3as1d");
                return true;
            }
        });
        wheel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfo(wheel.getAdapter().getItem(wheel.getCurrentItem()));
            }
        });

    }

    private void showInfo(String data) {
        if (toast == null) {
            toast = Toast.makeText(this, data, Toast.LENGTH_SHORT);
        } else {
            toast.setText(data);
        }
        toast.show();
    }

}
