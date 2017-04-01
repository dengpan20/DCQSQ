package com.dcqsq.com.dcqsq.mvvm.net;

import com.dcqsq.com.dcqsq.mvvm.bean.TeleNetReslut;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by dengpan on 17/3/31.
 */

public interface AppNetService {
    @FormUrlEncoded
    @POST("")
    Observable<TeleNetReslut> getDataByNo(@Header("Cache-Control") String cacheControl, @FieldMap Map<String,String> map);
}
