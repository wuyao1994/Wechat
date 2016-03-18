package com.siping.wechat.bean;

import java.io.Serializable;

public class JSSDKTicket implements Serializable{
    /**
     *  获取到的凭证
     */
    private String ticket;

    /**
     * 凭证有效时间，单位：秒
     */
    private Integer expiresIn;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }
}
