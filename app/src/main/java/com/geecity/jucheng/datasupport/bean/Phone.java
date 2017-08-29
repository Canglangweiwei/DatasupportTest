package com.geecity.jucheng.datasupport.bean;

import org.litepal.crud.DataSupport;

/**
 * <p>
 * 电话
 * </p>
 * Created by Administrator on 2017/8/29 0029.
 */
public class Phone extends DataSupport {

    private int id;
    private String phoneNumber;

    public Phone() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
