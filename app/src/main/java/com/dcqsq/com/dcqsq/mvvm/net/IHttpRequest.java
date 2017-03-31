package com.dcqsq.com.dcqsq.mvvm.net;


import com.dcqsq.com.dcqsq.mvvm.bean.TeleNetReslut;

import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by dengpan on 17/3/31.
 */

public interface IHttpRequest {
    Observable<TeleNetReslut> getInfoByNo(Map<String,String> map);
}
