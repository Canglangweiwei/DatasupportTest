package com.geecity.jucheng.datasupport.app;

import org.litepal.LitePal;
import org.litepal.LitePalApplication;

/**
 * <p>application</p>
 * Created by Administrator on 2017/8/29 0029.
 */
@SuppressWarnings("ALL")
public class GccApplication extends LitePalApplication {

    private static GccApplication sApp;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        LitePal.initialize(this);
    }

    public static GccApplication get() {
        return sApp;
    }
}
