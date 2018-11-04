package com.example.qinzhu.listttt;


import android.content.Context;

import android.util.Log;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.BaseAdapter;

import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;

//import com.example.administrator.datademo.R;

//import com.example.administrator.datademo.data.bean;


import java.nio.DoubleBuffer;
import java.util.List;


@SuppressWarnings("ALL")
public class mAdapter extends BaseAdapter {

    public List<bean> mList;

    public Context mcontect;

    public LayoutInflater layoutInflater;

    public View view1;

    public EditText ed;


    public mAdapter(Context context, List<bean> list) {

        this.mcontect = context;

        this.mList = list;

        layoutInflater = LayoutInflater.from(context);

    }

    public int getCount() {

        return mList.size();

    }

    @Override

    public Object getItem(int i) {

        return mList.get(i);

    }

    @Override

    public long getItemId(int i) {

        return i;

    }


    /**
     * 绘制这个ListView
     *
     * @param i
     * @param view
     * @param viewGroup
     * @return
     */

    @Override

    public View getView(final int i, View view, ViewGroup viewGroup) {


        ViewHolder holder;

        if (view == null) {

            //用layoutInflater.inflate获取到bean.xml

            holder = new ViewHolder();

            view = layoutInflater.inflate(R.layout.bean, null, true);

            holder.textView1 = view.findViewById(R.id.id_todo);

            holder.button1 = (Button) view.findViewById(R.id.id_btn_reduce);

            holder.button2 = (Button) view.findViewById(R.id.id_btn_recompose);


            view.setTag(holder);


            //设置TextView获取List集合里new好的控件和得到里面的数据


            holder.textView1.setText(mList.get(i).getTv1().getText());

            //刷新

            notifyDataSetChanged();


        } else {
            holder = (ViewHolder) view.getTag();

        }


        holder.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteListener.onDeleteClick(i);
            }
        });


        return view;

    }

    //创建接口

    public interface onItemDeleteListener {

        void onDeleteClick(int i);
    }


    private onItemDeleteListener deleteListener;

    public void Reducee(onItemDeleteListener m) {
        this.deleteListener= m;
    }


    static class ViewHolder {

        TextView textView1;

        Button button1;

        Button button2;

    }


}
