package com.example.greendaodemo.app;

import android.app.Application;

import com.example.greendaodemo.sqlit.entity.DaoMaster;
import com.example.greendaodemo.sqlit.entity.DaoSession;
import com.example.greendaodemo.sqlit.helper.SQLiteDBOpenHelper;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Administrator on 2018/1/15.
 * Copyright (c) 2018 . All rights reserved.
 */

public class DaoApp extends Application {
    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        configureDb(this);
    }

    private void configureDb(DaoApp daoApp) {
        SQLiteDBOpenHelper helper = new SQLiteDBOpenHelper(this, "test_db");
        Database db = helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
