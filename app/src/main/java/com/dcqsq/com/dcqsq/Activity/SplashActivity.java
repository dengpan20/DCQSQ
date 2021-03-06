package com.dcqsq.com.dcqsq.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dcqsq.com.dcqsq.R;
import com.dcqsq.com.dcqsq.base.BaseActivity;
import com.dcqsq.com.dcqsq.constant.Constant;
import com.dcqsq.com.dcqsq.utils.SharePreUtils;

public class SplashActivity extends BaseActivity {
    private EditText et_text;
    private Button btn_go_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        et_text = (EditText) findViewById(R.id.et_idcard);
        String phone = (String) SharePreUtils.getParam(this, Constant.KEY_PHONE_NO, "");
        et_text.setText(phone);
        btn_go_result = (Button) findViewById(R.id.btn_go_result);
        btn_go_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                Intent intent = new Intent(SplashActivity.this,PieChartActivity.class);
                intent.putExtra("no",et_text.getText().toString());
                SharePreUtils.setParam(SplashActivity.this, Constant.KEY_PHONE_NO,et_text.getText().toString());
                startActivity(intent);
            }
        });

    }
}
