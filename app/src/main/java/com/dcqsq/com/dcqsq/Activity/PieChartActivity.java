package com.dcqsq.com.dcqsq.Activity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;

import com.dcqsq.com.dcqsq.R;
import com.dcqsq.com.dcqsq.base.BaseActivity;
import com.dcqsq.com.dcqsq.bean.TeleNetReslut;
import com.dcqsq.com.dcqsq.utils.DialogUtils;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.BaseRequest;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;
import okhttp3.Call;
import okhttp3.Response;

public class PieChartActivity extends BaseActivity implements OnChartValueSelectedListener {
    private PieChart mChart;
    private SweetAlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        mChart = (PieChart) findViewById(R.id.piechart);
        initPieChart();
        initRemoteData();

    }

    private void initRemoteData() {
        String no =getIntent().getStringExtra("no");
        final Gson gson= new Gson();
        OkGo.post("http://www.ttwulian.cn/index.php/Home/inquire/bull.html")
                .params("phone",no)
                .execute(new StringCallback() {
                    @Override
                    public void onBefore(BaseRequest request) {
                        super.onBefore(request);
                        dialog = DialogUtils.showLoadingDialog(PieChartActivity.this,"");
                    }

                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        TeleNetReslut reslut = gson.fromJson(s, TeleNetReslut.class);
                        if (reslut.getData() != null) {
                            initData(reslut.getData());
                        }else{
                            DialogUtils.showTipDialog(PieChartActivity.this,"号码不存在");
                        }
                    }

                    @Override
                    public void onAfter(String s, Exception e) {
                        super.onAfter(s, e);
                        dialog.dismiss();
                    }
                });
    }

    private void initData(TeleNetReslut.DataBean data) {
        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
        entries.add(new PieEntry((float) data.getPercent(),"已使用"+data.getAlready()+"M",null));
        entries.add(new PieEntry((float) (1-data.getPercent()),"剩余流量"+(data.getTotal()-data.getAlready())+"M",null));
        mChart.setCenterText("流量使用情况（套餐总量为："+data.getTotal()+"M）:");
        Log.e("--","---"+entries.get(0).getValue());
        setData(2,100,entries,null);
    }

    private void initPieChart() {
        mChart.setUsePercentValues(true);
        mChart.getDescription().setEnabled(false);
        mChart.setExtraOffsets(5, 10, 5, 5);

        mChart.setDragDecelerationFrictionCoef(0.95f);

//        mChart.setCenterTextTypeface(mTfLight);//font  setting
        mChart.setCenterText(generateCenterSpannableText());

        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColor(Color.WHITE);

        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);

        mChart.setHoleRadius(58f);
        mChart.setTransparentCircleRadius(61f);

        mChart.setDrawCenterText(true);

        mChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        mChart.setRotationEnabled(true);
        mChart.setHighlightPerTapEnabled(true);

        // mChart.setUnit(" €");
        // mChart.setDrawUnitsInChart(true);

        // add a selection listener
        mChart.setOnChartValueSelectedListener(this);

        setData(2, 100,null,null);

        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // mChart.spin(2000, 0, 360);

        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        // entry label styling
        mChart.setEntryLabelColor(Color.WHITE);
//        mChart.setEntryLabelTypeface(mTfRegular);
        mChart.setEntryLabelTextSize(12f);
    }

    private void setData(int count, int range,ArrayList<PieEntry> mentries,ArrayList<String> mmParties) {
        float mult = range;

        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
        ArrayList<String> mParties= new ArrayList<>();

        if(mentries != null){
            entries.addAll(mentries);
        }else{
            mParties.add("已使用");
            mParties.add("剩余");
            for (int i = 0; i < count ; i++) {
                entries.add(new PieEntry((float) ((29)),
                        mParties.get(i % mParties.size()),
                        null));

            }
        }
        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.



        PieDataSet dataSet = new PieDataSet(entries, "使用情况");

//        dataSet.setDrawIcons(false);

        dataSet.setSliceSpace(3f);
//        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<Integer>();

//        for (int c : ColorTemplate.VORDIPLOM_COLORS)
//            colors.add(c);
//
//        for (int c : ColorTemplate.JOYFUL_COLORS)
//            colors.add(c);
//
//        for (int c : ColorTemplate.COLORFUL_COLORS)
//            colors.add(c);
//
//        for (int c : ColorTemplate.LIBERTY_COLORS)
//            colors.add(c);
//
//        for (int c : ColorTemplate.PASTEL_COLORS)
//            colors.add(c);
        colors.add(getRedColor());
        colors.add(getGreenColor());

        dataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
//        data.setValueTypeface(mTfLight);
        mChart.setData(data);

        // undo all highlights
        mChart.highlightValues(null);

        mChart.invalidate();
    }

    private Integer getGreenColor() {
        return Color.parseColor("#7FFF00");
    }

    private Integer getRedColor() {
        return Color.parseColor("#EE0000");
    }

    private CharSequence generateCenterSpannableText() {
        SpannableString s = new SpannableString("流量使用情况");
//        s.setSpan(new RelativeSizeSpan(1.7f), 0, 14, 0);
//        s.setSpan(new StyleSpan(Typeface.NORMAL), 14, s.length() - 15, 0);
//        s.setSpan(new ForegroundColorSpan(Color.GRAY), 14, s.length() - 15, 0);
//        s.setSpan(new RelativeSizeSpan(.8f), 14, s.length() - 15, 0);
//        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 14, s.length(), 0);
//        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 14, s.length(), 0);
        return s;
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }
}
