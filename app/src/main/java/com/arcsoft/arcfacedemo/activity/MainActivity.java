package com.arcsoft.arcfacedemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.arcsoft.arcfacedemo.R;
import com.arcsoft.arcfacedemo.page.HomePageActivity;
import com.arcsoft.arcfacedemo.page.LoginActivity;
import com.arcsoft.arcfacedemo.page.SplashActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = (TextView)findViewById(R.id.textView);

        handler=new Handler();
//        handler.postDelayed(new Runnable() {
////            @Override
////            public void run() {
////                Intent intent=new Intent(MainActivity.this, HomePageActivity.class);
////                startActivity(intent);
////                finish();
////            }
////        },3000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textview.setText("支付成功！2");
            }
        },1000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                textview.setText("支付成功！1");
            }
        },2000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this, HomePageActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }

    @Override
    public void onBackPressed(){
        Intent intent=new Intent(MainActivity.this, HomePageActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
