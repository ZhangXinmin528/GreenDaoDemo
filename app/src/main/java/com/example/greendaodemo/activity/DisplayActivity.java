package com.example.greendaodemo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.greendaodemo.R;
import com.example.greendaodemo.adapter.UserAdapter;
import com.example.greendaodemo.app.DaoApp;
import com.example.greendaodemo.sqlit.entity.Users;
import com.example.greendaodemo.sqlit.entity.UsersDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/16.
 * Copyright (c) 2018 . All rights reserved.
 */

public class DisplayActivity extends AppCompatActivity {

    private Context mContext;
    private List<Users> mDataList;
    private ListView mListView;
    private UserAdapter mAdapter;
    private UsersDao mUsersDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        initParamsAndValues();

        initViews();

        initData();
    }

    private void initParamsAndValues() {
        mContext = this;
        DaoApp daoApp = (DaoApp) getApplication();
        mUsersDao = daoApp.getDaoSession().getUsersDao();

        mDataList = new ArrayList<>();
        mAdapter = new UserAdapter(mContext, mDataList);

    }

    private void initViews() {
        mListView = findViewById(R.id.listview);
        mListView.setAdapter(mAdapter);
    }

    private void initData() {

        final List<Users> list = mUsersDao.queryBuilder()
                .build().list();

        if (list != null && !list.isEmpty()) {
            mDataList.addAll(list);
            mAdapter.notifyDataSetChanged();
        }
    }
}
