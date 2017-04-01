package com.dcqsq.com.dcqsq.mvvm.net;

/**
 * Created by dengpan on 17/4/1.
 * 请求的回调接口
 */

public interface RequestCallBack {
    void beforeRequest(int tag);
    void success(Object data,int tag);
    void error(String errorMsg);
}
