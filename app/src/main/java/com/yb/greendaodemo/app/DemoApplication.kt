package com.yb.greendaodemo.app

import android.app.Application

/**
 * 类说明：应用主入口，初始化GreenDao数据库
 *
 * @author 裕博
 * Time: 2019/12/9 13:09
 */
class DemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // 初始化数据库
        initGreenDao()
    }

    private fun initGreenDao() { //        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "aserbao.db");
//        SQLiteDatabase db = helper.getWritableDatabase();
//        DaoMaster daoMaster = new DaoMaster(db);
//        daoSession = daoMaster.newSession();
    }
}