package com.example.greendaodemo.sqlit.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.greendaodemo.sqlit.entity.DaoMaster;
import com.example.greendaodemo.sqlit.entity.UsersDao;


/**
 * Created by Growth on 2016/3/3.
 */
public class SQLiteDBOpenHelper extends DaoMaster.OpenHelper {
    public SQLiteDBOpenHelper(Context context, String name) {
        super(context, name);
    }

    public SQLiteDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    /**
     * 更改版本号即可
     * 新建表；增加字段；减少字段
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        MigrationHelper.DEBUG = true;
        MigrationHelper.migrate(db, UsersDao.class);
    }
}
