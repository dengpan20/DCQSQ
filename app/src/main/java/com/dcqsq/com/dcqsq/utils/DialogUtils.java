package com.dcqsq.com.dcqsq.utils;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by denppan on 2017/3/16.
 */

public class DialogUtils {
    public static SweetAlertDialog showLoadingDialog(Context context,String text){
        SweetAlertDialog pDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText(TextUtils.isEmpty(text) ? "加载中":text);
        pDialog.setCancelable(false);
        pDialog.show();
        return pDialog;
    }
}
