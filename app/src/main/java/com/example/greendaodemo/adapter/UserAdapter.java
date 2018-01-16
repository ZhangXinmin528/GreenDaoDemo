package com.example.greendaodemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.greendaodemo.R;
import com.example.greendaodemo.sqlit.entity.Users;

import java.util.List;

/**
 * Created by Administrator on 2018/1/16.
 * Copyright (c) 2018 . All rights reserved.
 */

public class UserAdapter extends BaseAdapter {
    private List<Users> mDataList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public UserAdapter(Context context, List<Users> dataList) {
        this.mDataList = dataList;
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Users getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.layout_list_item, null);
            holder = new ViewHolder();

            holder.name = convertView.findViewById(R.id.tv_item_name);
            holder.sex = convertView.findViewById(R.id.tv_item_sex);
            holder.desc = convertView.findViewById(R.id.tv_item_desc);
            holder.address = convertView.findViewById(R.id.tv_item_address);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Users users = getItem(position);
        holder.name.setText(mContext.getString(R.string.main_user_name_, users.getName()));
        holder.sex.setText(mContext.getString(R.string.main_user_sex_, users.getSex()));
        holder.desc.setText(mContext.getString(R.string.main_user_desc_, users.getDesc()));
        holder.address.setText(mContext.getString(R.string.main_user_address_, users.getAddress()));
        return convertView;
    }

    private class ViewHolder {
        private TextView name;
        private TextView sex;
        private TextView address;
        private TextView desc;
    }
}
