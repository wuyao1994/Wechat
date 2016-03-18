package com.siping.wechat.bean;

import java.io.Serializable;
import java.util.Random;

public class JSSignature implements Serializable {
    private JSSDKTicket ticket;
    private String url;
    private String appid;
    private String noncestr;
    private Long timestamp;
    private String signature = "";

    public JSSignature() {
        timestamp = System.currentTimeMillis()/1000;

        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 15; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        noncestr = sb.toString();
    }

    public JSSDKTicket getTicket() {
        return ticket;
    }
    public void setTicket(JSSDKTicket ticket) {
        this.ticket = ticket;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getNoncestr() {
        return noncestr;
    }
    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }
    public Long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
    public String getAppid() {
        return appid;
    }
    public void setAppid(String appid) {
        this.appid = appid;
    }
}
