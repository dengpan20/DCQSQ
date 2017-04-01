package com.dcqsq.com.dcqsq.mvvm.base;

import android.content.Context;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.dcqsq.com.dcqsq.mvvm.utils.AppManagerUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by dengpan on 17/4/1.
 */

public abstract class BaseActivity <T extends ViewDataBinding,M extends BaseModel> extends AppCompatActivity implements IModelActivity<T>{
    private T mBinder = null;
    private M mModel = null;
    public abstract int getLayoutId();

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        mBinder = DataBindingUtil.setContentView(this,getLayoutId());
        AppManagerUtils.getAppManager().addActivity(this);

        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Class<M> bizClass = (Class) params[1];
        try {
            mModel = bizClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        mModel.setView
    }

    @Override
    public T getBinder() {
        return null;
    }

    @Override
    public Context getContext() {
        return null;
    }
}
