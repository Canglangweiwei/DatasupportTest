package com.geecity.jucheng.datasupport.bean;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * <p>
 * 图片
 * </p>
 * Created by Administrator on 2017/8/29 0029.
 */
public class Pictures extends DataSupport implements Serializable {

    private String pTitle;
    private String pDate;
    private String pImg;
    private String pHref;

    public Pictures() {
        super();
    }

    public String getpHref() {
        return pHref;
    }

    public void setpHref(String pHref) {
        this.pHref = pHref;
    }

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public String getpDate() {
        return pDate;
    }

    public void setpDate(String pDate) {
        this.pDate = pDate;
    }

    public String getpImg() {
        return pImg;
    }

    public void setpImg(String pImg) {
        this.pImg = pImg;
    }

    @Override
    public String toString() {
        return "Pictures{" +
                "pTitle='" + pTitle + '\'' +
                ", pDate='" + pDate + '\'' +
                ", pImg='" + pImg + '\'' +
                ", pHref='" + pHref + '\'' +
                '}';
    }
}
