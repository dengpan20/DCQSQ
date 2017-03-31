package com.dcqsq.com.dcqsq.mvvm.net;

import com.dcqsq.com.dcqsq.mvvm.bean.TeleNetReslut;

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
    @Override
    public Observable<TeleNetReslut> getInfoByNo(Map<String,String> map) {
        return null;
    }
}
