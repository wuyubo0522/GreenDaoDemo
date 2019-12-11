package com.yb.greendaodemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yb.greendaodemo.entity.StaffEntity
//import com.yb.greendaodemo.helper.GreenDaoHelper
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

//    private var mHelper:GreenDaoHelper? = null
//
//    private lateinit var staffEntity1:StaffEntity
//    private lateinit var staffEntity2:StaffEntity
//    private lateinit var staffEntity3:StaffEntity
//    private lateinit var staffEntity4:StaffEntity
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        // 初始化数据库助手
//        mHelper = GreenDaoHelper.getInstance(this)
//        // 点击事件
//        initEvent()
//        // 初始数据
//        similateData()
//    }
//
//    private fun similateData() {
//        staffEntity1 = StaffEntity(null,1,"小明",18,"男生")
//        staffEntity2 = StaffEntity(null,2,"小丽",18,"女生")
//        staffEntity3 = StaffEntity(null,3,"小张",18,"男生")
//        staffEntity4 = StaffEntity(null,4,"小红",18,"女生")
//    }
//
//    private fun initEvent() {
//        mBtnAdd?.setOnClickListener {
//            // 添加数据
//            mHelper?.insertOrReplace(staffEntity1)
//            mHelper?.insertOrReplace(staffEntity2)
//            mHelper?.insertOrReplace(staffEntity3)
//            mHelper?.insertOrReplace(staffEntity4)
//            // 显示数据
//            showDataList()
//        }
//        mBtnDelete?.setOnClickListener {
//            // 删除数据
//            mHelper?.delete("小张")
//            showDataList()
//        }
//        mBtnUpdate?.setOnClickListener {
//            // 升级数据
//            mHelper?.update(staffEntity1,"王五")
//            showDataList()
//        }
//        mBtnSearch?.setOnClickListener {
//            // 查询数据
//            showDataList()
//        }
//    }
//
//    private fun showDataList() {
//        val sb = StringBuilder()
//        val staffEntityInfo: List<StaffEntity> = mHelper?.searchAll()!!
//        for (staffEntity in staffEntityInfo) {
//            sb.append("系统ID:").append(staffEntity.id)
//                .append("员工编号:").append(staffEntity.staffNo)
//                .append("员工名称:").append(staffEntity.staffName)
//                .append("性别:").append(staffEntity.sex)
//                .append("\n")
//        }
//        mTvData.text = sb.toString()
//    }
}
