package com.example.dell.recyclerview;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<Map<String,Object>> mdatalist;
    private MyAdapter myadapter;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        initData();
        mLinearLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        myadapter=new MyAdapter(this,mdatalist);
        mRecyclerView.setAdapter(myadapter);

    }

    private void initData() {
        int[] image = {R.drawable.gongbaojiding, R.drawable.shuizhuroupian,
                R.drawable.xihucuyu, R.drawable.yuxiangrousi,
                R.drawable.suanlajidantang};
        String[] title = {"宫保鸡丁", "水煮肉片", "西湖醋鱼", "鱼香肉丝", "酸辣鸡蛋汤"};
        String[] info = {"29.9", "39.0", "38.9", "26.9", "16.9"};
        mdatalist=new ArrayList<>();
        for(int i=0;i<5;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("image",image[i]);
            map.put("title",title[i]);
            map.put("info",info[i]);
            mdatalist.add(map);
        }

    }
}
