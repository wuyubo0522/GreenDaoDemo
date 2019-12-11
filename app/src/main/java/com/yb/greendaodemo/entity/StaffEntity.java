package com.yb.greendaodemo.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 类说明：测试数据实体类,目前使用Java写是最合适的
 *
 * @author 裕博
 * Time: 2019/12/9 13:57
 */
@Entity
public class StaffEntity {
    /**
     * 设置数据库ID自增长
     */
    @Id(autoincrement = true)
    private Long id;
    /**
     * 员工编号设置唯一性
     */
    @Unique
    private int staffNo;
    /**
     * 员工姓名
     */
    private String staffName;
    /**
     * 员工年龄
     */
    private int age;
    /**
     * 员工性别
     */
    private String sex;

    @Generated(hash = 1888968521)
    public StaffEntity(Long id, int staffNo, String staffName, int age,
                       String sex) {
        this.id = id;
        this.staffNo = staffNo;
        this.staffName = staffName;
        this.age = age;
        this.sex = sex;
    }

    @Generated(hash = 623314536)
    public StaffEntity() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStaffNo() {
        return this.staffNo;
    }

    public void setStaffNo(int staffNo) {
        this.staffNo = staffNo;
    }

    public String getStaffName() {
        return this.staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return this.sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "StaffEntity{" +
                "id=" + id +
                ", staffNo=" + staffNo +
                ", staffName='" + staffName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
