package com.example.qinzhu.listttt;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;

import android.view.View;

import android.widget.AdapterView;
import android.widget.Button;

import android.widget.EditText;

import android.widget.ListView;

import android.widget.TextView;


//import com.example.administrator.datademo.R;

//import com.example.administrator.datademo.adapter.mAdapter;

//import com.example.administrator.datademo.data.bean;


import java.util.ArrayList;

import java.util.List;

//import static com.example.qinzhu.list.R.id.id_btn_add;


public class MainActivity extends AppCompatActivity {

    private List<bean> mist = new ArrayList<bean>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        //初始化视图,初始化获取控件

        Button btn_add = (Button) findViewById(R.id.id_btn_add);

        final EditText ed = (EditText) findViewById(R.id.id_ed_data);

        ListView mlistview = (ListView) findViewById(R.id.id_listview);


        //创建ListView的适配器adapter

        final mAdapter adapter = new mAdapter(MainActivity.this, mist);

        //设置ListView的适配器

        mlistview.setAdapter(adapter);


        //设置监听事件

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //用for循环进行遍历添加数据，用Iterator遍历也行

                for (int i = 0; i < mist.size(); i++) {

                    mist.get(i).getTv1().setText(ed.getText());
                }

                //ListView动态添加控件

                mist.add(new bean(new TextView(MainActivity.this)));

            }

        });


        adapter.Reducee(new mAdapter.onItemDeleteListener() {

            @Override

            public void onDeleteClick(int i) {

                mist.remove(i);

                adapter.notifyDataSetChanged();
            }
        });

        //  adapter.setRecomposeClickListener(new mAdapter.onItemDeleteListener() {
        //
        //          @Override
        //        public void onrecomposeClick(int i) {
        //
        //           mist.remove(i);
        //             for (int i = 0; i < mist.size(); i++) {
        //
        //                mist.get(i).getTv1().setText(ed.getText());
        //                }
        //
        //
        //         mist.add(new bean(new TextView(MainActivity.this)));
        //
        //           adapter.notifyDataSetChanged();
        //        }
        //    });



    }

}

