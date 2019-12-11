package com.yb.greendaodemo.helper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.yb.greendaodemo.entity.DaoMaster
import com.yb.greendaodemo.entity.DaoSession
import com.yb.greendaodemo.entity.StaffEntity
import com.yb.greendaodemo.entity.StaffEntityDao

/**
 * 类说明：数据库助手,kotlin版本数据库助手在报错，暂时性注释
 * @author 裕博
 * Time: 2019/12/9 15:27
 */
//class GreenDaoHelper {
//
//    /**获取Helper对象*/
//    private var mHelper: DaoMaster.DevOpenHelper? = null
//    /**数据库*/
//    private var mDb: SQLiteDatabase? = null
//    /**DaoMaster*/
//    private var mDaoMaster: DaoMaster? = null
//    /**DaoSession*/
//    private var mDaoSession: DaoSession? = null
//    /**上下文*/
//    private var mContext: Context? = null
//    /**对应的数据Dao*/
//    private var mStaffEntityDao: StaffEntityDao? = null
//
//    constructor(context: Context?) {
//        this.mContext = context
//        mHelper = DaoMaster.DevOpenHelper(context, "staffEntity.db", null)
//        mDaoMaster = DaoMaster(getWritableDatabase())
//        mDaoSession = mDaoMaster?.newSession()
//        mStaffEntityDao = mDaoSession?.staffEntityDao
//    }
//
//    /**获取可读的数据库*/
//    fun getReadableDatabase(): SQLiteDatabase? {
//        if (mHelper == null) {
//            mHelper = DaoMaster.DevOpenHelper(mContext, "staffEntity.db", null)
//        }
//        return mHelper?.readableDatabase
//    }
//
//    /**获取可写的数据库*/
//    fun getWritableDatabase(): SQLiteDatabase? {
//        if (mHelper == null) {
//            mHelper = DaoMaster.DevOpenHelper(mContext, "staffEntity.db", null)
//        }
//        return mHelper?.writableDatabase
//    }
//
//    /**设置自动判定是插入还是替换*/
//    fun insertOrReplace(staff: StaffEntity) {
//        mStaffEntityDao?.insertOrReplace(staff)
//    }
//
//    /**插入一条数据，表里面没有与之相同的记录*/
//    fun insert(staff: StaffEntity): Long? {
//        return mStaffEntityDao?.insert(staff)
//    }
//
//    /**
//     * 更新数据
//     * @param staff 升级的表
//     * @param name 修改的员工名字
//     */
//    fun update(staff: StaffEntity,name:String){
//        // 拿到之前的记录
//        val staffInfo:StaffEntity? = mStaffEntityDao?.queryBuilder()
//            ?.where(StaffEntityDao.Properties.Id.eq(staff.id))?.build()!!.unique()
//        if(staffInfo !=null){
//            staffInfo?.staffName = name
//            mStaffEntityDao?.update(staffInfo)
//        }
//    }
//
//    /**
//     * 按条件查询数据库
//     * @param wherecluse 查询的数据库员工名称
//     */
//    fun searchByWhere(wherecluse:String):List<StaffEntity>{
//        return listOf(mStaffEntityDao?.queryBuilder()?.where(StaffEntityDao.Properties.StaffName.eq(wherecluse))?.build()!!.unique())
//    }
//
//    /**
//     * 查询数据库所有的数据
//     * @return 返回List集合
//     */
//    fun searchAll(): MutableList<StaffEntity>? {
//        return mStaffEntityDao?.queryBuilder()?.list()
//    }
//
//    /**
//     * 删除数据
//     */
//    fun delete(wherecluse:String){
//        mStaffEntityDao?.queryBuilder()?.where(StaffEntityDao.Properties.StaffName.eq(wherecluse))
//            ?.buildDelete()
//            ?.executeDeleteWithoutDetachingEntities()
//    }
//
//    /**
//     * 删除所有的数据
//     */
//    fun deleteAll(){
//        mStaffEntityDao?.deleteAll()
//    }
//
//    companion object {
//
//        private var mGreenDaoHelper: GreenDaoHelper? = null
//
//        fun getInstance(context: Context?): GreenDaoHelper? {
//            if (mGreenDaoHelper == null) {
//                synchronized(GreenDaoHelper::class.java) {
//                    if (mGreenDaoHelper == null) {
//                        mGreenDaoHelper = GreenDaoHelper(context)
//                    }
//                }
//            }
//            return mGreenDaoHelper
//        }
//    }
//}