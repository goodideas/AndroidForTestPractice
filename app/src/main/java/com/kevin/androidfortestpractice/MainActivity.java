package com.kevin.androidfortestpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kevin.androidfortestpractice.activity.Btn1Activity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);


        intent = new Intent();
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                intent.setClass(MainActivity.this, Btn1Activity.class);
                startActivity(intent);
                break;
        }
    }
}
