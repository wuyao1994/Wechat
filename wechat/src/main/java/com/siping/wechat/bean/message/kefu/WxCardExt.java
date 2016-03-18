package com.siping.wechat.bean.message.kefu;

import org.json.JSONObject;

import com.siping.wechat.bean.message.SendableMessage;

public class WxCardExt implements SendableMessage{
    private String code;
    private String openid;
    private String timestamp;
    private String signature;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public JSONObject generateJsonObject() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", this.getCode());
        jsonObject.put("openid", this.getOpenid());
        jsonObject.put("timestamp", this.getTimestamp());
        jsonObject.put("signature", this.getSignature());
        return jsonObject;
    }
}
