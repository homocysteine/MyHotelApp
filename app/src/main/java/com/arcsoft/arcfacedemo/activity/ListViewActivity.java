package com.arcsoft.arcfacedemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.arcsoft.arcfacedemo.MyAdapter;
import com.arcsoft.arcfacedemo.R;
public class ListViewActivity extends AppCompatActivity {

    private ListView mLV1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        mLV1 = (ListView)findViewById(R.id.lv_1_Id);
        mLV1.setAdapter(new MyAdapter(ListViewActivity.this));
        mLV1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //设置一个弹窗，显示是哪个被点击了
                //此处执行动作，跳转到Wait
                //Toast.makeText(ListViewActivity.this,"点击位置"+position,Toast.LENGTH_SHORT).show();
                //checkLibraryAndJump(WaitActivity.class);
                startActivity(new Intent(ListViewActivity.this, WaitActivity.class));
            }
        });
    }
}
