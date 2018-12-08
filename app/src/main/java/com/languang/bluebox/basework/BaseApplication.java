package com.languang.bluebox.basework;

import android.support.multidex.MultiDexApplication;

import com.languang.bluebox.utils.WiFiHandler;

/**
 * 初始配置
 *
 * @author mrj
 * @date 2017/11/23
 */

public class BaseApplication extends MultiDexApplication {


    private static BaseApplication application;

    public static BaseApplication getInstance() {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        //初始化wifi控制器
//        WiFiHandler.instance().init(this);

    }
}
