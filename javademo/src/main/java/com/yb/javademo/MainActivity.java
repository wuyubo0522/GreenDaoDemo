package com.yb.javademo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.yb.javademo.entity.StaffEntity;
import com.yb.javademo.helper.GreenDaoHelper;
import java.util.List;

/**
 * 类说明：主界面，主要看整个Demo的效果
 * @author 裕博
 */
public class MainActivity extends AppCompatActivity {

    private Button mBtnAdd,mBtnDelete,mBtnUpdate,mBtnSearch;
    private TextView mTvData;
    private StaffEntity staffEntity1,staffEntity2,staffEntity3,staffEntity4;
    private GreenDaoHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelper = GreenDaoHelper.getInstance(this);
        // 初始化界面
        initView();
        // 初始化点击事件
        initEvent();
        // 初始化数据
        initData();
    }

    private void initData() {
        staffEntity1 = new StaffEntity(null,1,"小明",18,"男生");
        staffEntity2 = new StaffEntity(null,2,"小丽",18,"女生");
        staffEntity3 = new StaffEntity(null,3,"小张",18,"男生");
        staffEntity4 = new StaffEntity(null,4,"小红",18,"女生");
    }

    private void initView() {
        mBtnAdd = findViewById(R.id.mBtnAdd);
        mBtnDelete = findViewById(R.id.mBtnDelete);
        mBtnUpdate = findViewById(R.id.mBtnUpdate);
        mBtnSearch = findViewById(R.id.mBtnSearch);
        mTvData = findViewById(R.id.mTvData);
    }

    private void initEvent() {
        mBtnAdd.setOnClickListener(v -> {
            // 增加数据
            mHelper.insertOrReplace(staffEntity1);
            mHelper.insertOrReplace(staffEntity2);
            mHelper.insertOrReplace(staffEntity3);
            mHelper.insertOrReplace(staffEntity4);
            showDataList();
        });
        mBtnDelete.setOnClickListener(v -> {
            // 删除数据
            mHelper.delete("小张");
            showDataList();
        });
        mBtnUpdate.setOnClickListener(v -> {
            // 修改数据
            mHelper.update(staffEntity1,"王五");
            showDataList();
        });
        mBtnSearch.setOnClickListener(v -> {
            // 查询数据
            showDataList();
        });
    }

    private void showDataList() {
        StringBuilder sb = new StringBuilder();
        List<StaffEntity> staffEntityInfo = mHelper.searchAll();
        for(StaffEntity staffEntity:staffEntityInfo){
            sb.append("系统ID:").append(staffEntity.getId())
                .append("员工编号:").append(staffEntity.getStaffNo())
                .append("员工名称:").append(staffEntity.getStaffName())
                .append("性别:").append(staffEntity.getSex())
                .append("\n");
        }
        mTvData.setText(sb.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 关闭数据库读写
        mHelper.onClose();
    }
}
