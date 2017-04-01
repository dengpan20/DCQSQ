package com.dcqsq.com.dcqsq.mvvm.base;

import android.databinding.ViewDataBinding;
import android.view.View;

import com.dcqsq.com.dcqsq.mvvm.net.RequestCallBack;

/**
 * Created by dengpan on 17/4/1.
 */

public abstract class BaseModel<T extends ViewDataBinding,M extends IBaseControl> implements IModel,RequestCallBack{
    protected IModelActivity UI = null;
    protected T mBinder = null;
    protected M mControl = null;
//    public DialogUtil mDialog;
    public View mNotWorkView;//无网络图片
    @Override
    public void onCreat() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void beforeRequest(int tag) {

    }

    @Override
    public void success(Object data, int tag) {

    }

    @Override
    public void error(String errorMsg) {

    }
}
