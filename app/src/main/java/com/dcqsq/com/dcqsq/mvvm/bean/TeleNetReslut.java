package com.dcqsq.com.dcqsq.mvvm.bean;

import java.io.Serializable;

/**
 * Created by dengpan on 17/3/16.
 */

public class TeleNetReslut implements Serializable{

    /**
     * status : 1
     * msg : 成功
     * code : 200
     * data : {"status":"已激活","total":3072,"already":890,"percent":0.29,"fready":29,"shiming":"已实名"}
     */

    private String status;
    private String msg;
    private int code;
    /**
     * status : 已激活
     * total : 3072
     * already : 890
     * percent : 0.29
     * fready : 29
     * shiming : 已实名
     */

    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String status;
        private int total;
        private int already;
        private double percent;
        private int fready;
        private String shiming;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getAlready() {
            return already;
        }

        public void setAlready(int already) {
            this.already = already;
        }

        public double getPercent() {
            return percent;
        }

        public void setPercent(double percent) {
            this.percent = percent;
        }

        public int getFready() {
            return fready;
        }

        public void setFready(int fready) {
            this.fready = fready;
        }

        public String getShiming() {
            return shiming;
        }

        public void setShiming(String shiming) {
            this.shiming = shiming;
        }
    }
}
