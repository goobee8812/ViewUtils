package com.example.administrator.viewutils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.viewutils.extendcontrols.MyAdapter;
import com.example.administrator.viewutils.extendcontrols.MyListView;
import com.example.administrator.viewutils.leafloading.LeafLoadingActivity;
import com.example.administrator.viewutils.refreshview.RefreshViewActivity;
import com.example.administrator.viewutils.weekselection.WeekActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //继承控件  ---ListView
    private MyListView myListView;
    private MyAdapter adapter;
    private List<String> contentList = new ArrayList<String>();
    private Button weekBtn = null;
    private Button refreshBtn = null;
    private Button leafLoadingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList();

        myListView = (MyListView) findViewById(R.id.my_list_view);
        myListView.setOnDeleteListener(new MyListView.OnDeleteListener() {
            @Override
            public void onDelete(int index) {
                contentList.remove(index);
                adapter.notifyDataSetChanged();  //更新控件显示
            }
        });
        //初始化按键控件
        weekBtn = (Button)findViewById(R.id.weekBtn);
        refreshBtn = (Button)findViewById(R.id.refreshBtn);
        leafLoadingBtn = (Button)findViewById(R.id.compose);
        weekBtn.setOnClickListener(this);
        refreshBtn.setOnClickListener(this);
        leafLoadingBtn.setOnClickListener(this);

        adapter = new MyAdapter(this, 0, contentList);
        myListView.setAdapter(adapter);

    }
    private void initList() {  //为自定义MyList控件添加item
        contentList.add("Content Item 1");
        contentList.add("Content Item 2");
        contentList.add("Content Item 3");
        contentList.add("Content Item 4");
        contentList.add("Content Item 5");
        contentList.add("Content Item 6");
        contentList.add("Content Item 7");
        contentList.add("Content Item 8");
        contentList.add("Content Item 9");
        contentList.add("Content Item 10");
        contentList.add("Content Item 11");
        contentList.add("Content Item 12");
        contentList.add("Content Item 13");
        contentList.add("Content Item 14");
        contentList.add("Content Item 15");
        contentList.add("Content Item 16");
        contentList.add("Content Item 17");
        contentList.add("Content Item 18");
        contentList.add("Content Item 19");
        contentList.add("Content Item 20");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.weekBtn:  //选择日期
                Intent weekIntent = new Intent(MainActivity.this, WeekActivity.class);
                startActivity(weekIntent);
                break;
            case R.id.refreshBtn:  //下拉刷新，上拉加载
                Intent refreshIntent = new Intent(MainActivity.this, RefreshViewActivity.class);
                startActivity(refreshIntent);
                break;
            case R.id.compose:      //叶子进度条
                Intent leafIntent = new Intent(MainActivity.this, LeafLoadingActivity.class);
                startActivity(leafIntent);
                break;
            default:
                break;
        }
    }
}
