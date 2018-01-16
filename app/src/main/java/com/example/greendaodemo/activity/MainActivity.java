package com.example.greendaodemo.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.greendaodemo.R;
import com.example.greendaodemo.app.DaoApp;
import com.example.greendaodemo.sqlit.entity.Users;
import com.example.greendaodemo.sqlit.entity.UsersDao;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private DaoApp mDaoApp;
    private UsersDao mUsersDao;

    private EditText mNameEt;
    private EditText mSexEt;
    private EditText mDescEt;
    private EditText mAddressEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initParamsAndValues();

        initViews();
    }

    private void initParamsAndValues() {
        mContext = this;
        mDaoApp = (DaoApp) getApplication();
        mUsersDao = mDaoApp.getDaoSession().getUsersDao();
    }

    private void initViews() {

        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_display).setOnClickListener(this);

        mNameEt = findViewById(R.id.et_name);
        mSexEt = findViewById(R.id.et_sex);
        mDescEt = findViewById(R.id.et_desc);
        mAddressEt = findViewById(R.id.et_address);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                addUserToDb();
                break;
            case R.id.btn_display:
                Intent intent = new Intent(mContext, DisplayActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * 添加记录
     *
     * @return
     */
    private boolean addUserToDb() {
        final Users users = new Users();
        users.setName(mNameEt.getText().toString().trim());
        users.setSex(mSexEt.getText().toString().trim());
        users.setDesc(mDescEt.getText().toString().trim());
        users.setAddress(mAddressEt.getText().toString().trim());

        if (TextUtils.isEmpty(users.getName())) {
            Toast.makeText(mContext, "添加失败", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, "添加成功", Toast.LENGTH_SHORT).show();
            mUsersDao.insert(users);
            mNameEt.getText().clear();
            mSexEt.getText().clear();
            mDescEt.getText().clear();
            mAddressEt.getText().clear();
        }
        return !TextUtils.isEmpty(users.getName());
    }
}
