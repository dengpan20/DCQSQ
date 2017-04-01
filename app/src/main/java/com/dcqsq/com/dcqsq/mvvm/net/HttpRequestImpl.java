package com.dcqsq.com.dcqsq.mvvm.net;

import android.support.annotation.NonNull;

import com.dcqsq.com.dcqsq.mvvm.base.BaseApplication;
import com.dcqsq.com.dcqsq.mvvm.bean.TeleNetReslut;
import com.dcqsq.com.dcqsq.mvvm.config.Constant;
import com.dcqsq.com.dcqsq.mvvm.utils.NetUtil;

import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by dengpan on 17/3/31.
 */

public class HttpRequestImpl implements IHttpRequest {
    private static  IHttpRequest httpRequest;
    public static IHttpRequest getInstance() {
        if (httpRequest == null) {
            httpRequest = new HttpRequestImpl();
            return httpRequest;
        }
        return httpRequest;
    }
    /**
     * 根据网络状况获取缓存的策略
     */
    @NonNull
    private String getCacheControl() {
        return NetUtil.isConnected(BaseApplication.getContext()) ? Constant.SCACHE_CONTROL_AGE : Constant.SCACHE_CONTROL_CACHE;
    }
    @Override
    public Observable<TeleNetReslut> getInfoByNo(Map<String,String> map) {
        return RetrofitManager.createServiceFrom(AppNetService.class).getDataByNo(getCacheControl(),map);
    }
}
