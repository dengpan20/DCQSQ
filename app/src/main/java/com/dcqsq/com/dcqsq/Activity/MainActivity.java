package com.dcqsq.com.dcqsq.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.dcqsq.com.dcqsq.R;
import com.dcqsq.com.dcqsq.base.BaseActivity;
import com.dcqsq.com.dcqsq.bean.TeleNetReslut;
import com.dcqsq.com.dcqsq.utils.DialogUtils;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.BaseRequest;

import cn.pedant.SweetAlert.SweetAlertDialog;
import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends BaseActivity {
    private TextView tv_result;
    private SweetAlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_result= (TextView) findViewById(R.id.tv_result);
        String no =getIntent().getStringExtra("no");
        final Gson gson= new Gson();
        OkGo.post("http://www.ttwulian.cn/index.php/Home/inquire/bull.html")
                .params("phone",no)
                .execute(new StringCallback() {
                    @Override
                    public void onBefore(BaseRequest request) {
                        super.onBefore(request);
                        dialog = DialogUtils.showLoadingDialog(MainActivity.this,"");
                    }

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        TeleNetReslut reslut = gson.fromJson(s, TeleNetReslut.class);
                        if (reslut.getData() != null) {
                            tv_result.setText(Html.fromHtml("当前状态：<font color='red'>" + reslut.getData().getStatus() + "</font>.总共流量：<font color='red'>" + reslut.getData().getTotal() + "M</font>.使用流量：<font color='red'>" + reslut.getData().getAlready() + "M</font>."));
                        }else{
                            tv_result.setText("请返回输入正确的iccid");
                        }
                    }

                    @Override
                    public void onAfter(String s, Exception e) {
                        super.onAfter(s, e);
                        dialog.dismiss();
                    }
                });

    }
}
