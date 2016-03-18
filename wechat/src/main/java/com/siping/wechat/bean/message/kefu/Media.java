package com.siping.wechat.bean.message.kefu;

import org.json.JSONObject;

import com.siping.wechat.bean.message.SendableMessage;

public class Media implements SendableMessage{
    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public JSONObject generateJsonObject() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("media_id", this.getMediaId());
        return jsonObject;
    }
}
