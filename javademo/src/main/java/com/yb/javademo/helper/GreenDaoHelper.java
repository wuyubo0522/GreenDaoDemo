package com.yb.javademo.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.yb.javademo.entity.DaoMaster;
import com.yb.javademo.entity.DaoSession;
import com.yb.javademo.entity.StaffEntity;
import com.yb.javademo.entity.StaffEntityDao;

import java.util.List;

/**
 * 类说明：Java版的GreenDao数据库助手
 *
 * @author 裕博
 * Time: 2019/12/11 9:47
 */
public class GreenDaoHelper {
    /**
     * 获取Helper对象
     */
    private DaoMaster.DevOpenHelper mHelper;
    /**
     * 数据库
     */
    private SQLiteDatabase db;
    /**
     * 上下文
     */
    private Context mContext;
    /**
     * dao
     */
    private StaffEntityDao mStaffEntityDao;

    private static GreenDaoHelper mGreenDaoHelper;

    /**
     * 获取单例
     */
    public static GreenDaoHelper getInstance(Context context) {
        if (mGreenDaoHelper == null) {
            synchronized (GreenDaoHelper.class) {
                if (mGreenDaoHelper == null) {
                    mGreenDaoHelper = new GreenDaoHelper(context);
                }
            }
        }
        return mGreenDaoHelper;
    }

    /**
     * 初始化
     *
     * @param context
     */
    private GreenDaoHelper(Context context) {
        this.mContext = context;
        mHelper = new DaoMaster.DevOpenHelper(context, "staffEntity.db", null);
        DaoMaster mDaoMaster = new DaoMaster(getWritableDatabase());
        DaoSession mDaoSession = mDaoMaster.newSession();
        mStaffEntityDao = mDaoSession.getStaffEntityDao();
    }

    /**
     * 获取可读数据库
     */
    private SQLiteDatabase getReadableDatabase() {
        if (mHelper == null) {
            mHelper = new DaoMaster.DevOpenHelper(mContext, "staffEntity.db", null);
        }
        return mHelper.getReadableDatabase();
    }

    /**
     * 获取可写数据库
     *
     * @return
     */
    private SQLiteDatabase getWritableDatabase() {
        if (mHelper == null) {
            mHelper = new DaoMaster.DevOpenHelper(mContext, "person.db", null);
        }
        return mHelper.getWritableDatabase();
    }

    /**
     * 会自动判定是插入还是替换
     *
     * @param staffEntity 相应的数据
     */
    public void insertOrReplace(StaffEntity staffEntity) {
        mStaffEntityDao.insertOrReplace(staffEntity);
    }

    /**
     * 插入一条记录，表里面要没有与之相同的记录
     *
     * @param staffEntity 相应的数据
     */
    public long insert(StaffEntity staffEntity) {
        return mStaffEntityDao.insert(staffEntity);
    }

    /**
     * 更新数据
     *
     * @param staffEntity 相应的数据
     */
    public void update(StaffEntity staffEntity, String name) {
        //拿到之前的记录
        StaffEntity staffInfo = mStaffEntityDao.queryBuilder().where(StaffEntityDao.Properties.Id.eq(staffEntity.getId())).build().unique();
        if (staffInfo != null) {
            if (!name.isEmpty()) {
                staffInfo.setStaffName(name);
            }
            mStaffEntityDao.update(staffInfo);
        }
    }

    /**
     * 按条件查询数据
     * @param condition 查询条件
     */
    public List<StaffEntity> searchByWhere(String condition) {
        return (List<StaffEntity>) mStaffEntityDao.queryBuilder().where(StaffEntityDao.Properties.StaffName.eq(condition)).build().unique();
    }

    /**
     * 查询所有数据
     */
    public List<StaffEntity> searchAll() {
        return mStaffEntityDao.queryBuilder().list();
    }

    /**
     * 删除数据
     * @param condition  查询条件
     */
    public void delete(String condition) {
        mStaffEntityDao.queryBuilder().where(StaffEntityDao.Properties.StaffName.eq(condition)).buildDelete().executeDeleteWithoutDetachingEntities();
    }

    /**
     * 删除所有的数据
     */
    public void deleteAll() {
        mStaffEntityDao.deleteAll();
    }
}
