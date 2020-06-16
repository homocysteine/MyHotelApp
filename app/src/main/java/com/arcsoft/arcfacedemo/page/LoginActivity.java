package com.arcsoft.arcfacedemo.page;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.arcsoft.arcfacedemo.R;
import com.arcsoft.arcfacedemo.activity.ListViewActivity;
import com.arcsoft.arcfacedemo.activity.WaitActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = (Button)findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, WaitActivity.class));
                finish();
            }
        });
    }
}
