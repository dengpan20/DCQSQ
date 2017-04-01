package com.dcqsq.com.dcqsq.mvvm.base;

import android.content.Context;
import android.databinding.ViewDataBinding;

/**
 * Created by dengpan on 17/4/1.
 */

public interface IModelActivity<T extends ViewDataBinding>{
    T getBinder();
    Context getContext();
}

