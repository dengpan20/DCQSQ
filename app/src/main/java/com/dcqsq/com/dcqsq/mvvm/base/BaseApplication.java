package com.dcqsq.com.dcqsq.mvvm.base;

import android.app.Application;
import android.content.Context;



/**
 * Created by dengpan on 17/4/1.
 */

public class BaseApplication extends Application{
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
//        Utils.init(this);
//
//        LogUtils.Builder builder = LogUtils.getBuilder();
//
//        builder.setTag("RxFamilyUser")
//                .setLogSwitch(true)
//                .setLog2FileSwitch(false)
//                .create();
//        ToastUtils.init(false);
    }

    // 获取ApplicationContext
    public static Context getContext() {
        return mContext;
    }
}
