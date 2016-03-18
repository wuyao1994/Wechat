package com.siping.wechat.bean.message.kefu;

import org.json.JSONObject;

import com.siping.wechat.bean.message.SendableMessage;

public class WxCard implements SendableMessage {
    private String cardId;
    private WxCardExt cardExt;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public WxCardExt getCardExt() {
        return cardExt;
    }

    public void setCardExt(WxCardExt cardExt) {
        this.cardExt = cardExt;
    }

    public JSONObject generateJsonObject() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("card_id", this.getCardId());
        jsonObject.put("card_ext", this.getCardExt().generateJsonObject());
        return jsonObject;
    }
}
