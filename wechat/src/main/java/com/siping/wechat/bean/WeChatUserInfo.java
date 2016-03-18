package com.siping.wechat.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

/**
 * 微信用户信息
 * @author Mx
 */
public class WeChatUserInfo implements Serializable {
    private static String DefalutTimeZone = TimeZone.getDefault().getID();

    public WeChatUserInfo() {
    }

    public WeChatUserInfo(String openid) {
        this.openid = openid;
    }

    private static final long serialVersionUID = 1L;
    /**
     * 编号，数据库唯一编号
     */
    private Long no;
    /**
     * openid用户的唯一标示
     */
    private String openid;
    /**
     * 是否关注
     */
    private int subscribe = 1;
    /**
     * 关注时间
     */
    private Date subscribeTime;
    /**
     * 呢称
     */
    private String nickname;
    /**
     * 性别：1男2女0未知
     */
    private int sex;
    /**
     * 国家
     */
    private String country;
    /**
     * 省份
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 语言
     */
    private String language;
    /**
     * 头像地址
     */
    private String headImgUrl;

    private Boolean isGPSOpen;

    private String timeZone;

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public int getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(int subscribe) {
        this.subscribe = subscribe;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLanguage() {
        if (language == null)
            return "en";
        else {
            if (language.length() < 2) {
                return language.toLowerCase();
            } else {
                return language.substring(0, 2).toLowerCase();
            }
        }
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public Date getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public Boolean getIsGPSOpen() {
        if(isGPSOpen == null){
            return false;
        }
        return isGPSOpen;
    }

    public void setIsGPSOpen(Boolean isGPSOpen) {
        this.isGPSOpen = isGPSOpen;
    }

    public String getTimeZone() {
        if(timeZone == null){
            return DefalutTimeZone;
        }
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
