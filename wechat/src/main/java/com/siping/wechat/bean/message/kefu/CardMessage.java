package com.siping.wechat.bean.message.kefu;

import org.json.JSONObject;

public class CardMessage extends KeFuMessage {
    private WxCard wxcard;

    public WxCard getWxcard() {
        return wxcard;
    }

    public void setWxcard(WxCard wxcard) {
        this.wxcard = wxcard;
    }

    public JSONObject generateJsonObject() throws Exception {
        JSONObject jsonObject = super.generateJsonObject();
        jsonObject.put("wxcard", this.getWxcard().generateJsonObject());
        return jsonObject;
    }
}
