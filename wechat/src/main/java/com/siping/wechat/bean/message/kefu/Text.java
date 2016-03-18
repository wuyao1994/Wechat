package com.siping.wechat.bean.message.kefu;

import org.json.JSONObject;

import com.siping.wechat.bean.message.SendableMessage;

public class Text implements SendableMessage {
    private String content;

    public Text() {

    }

    public Text(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public JSONObject generateJsonObject() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", this.getContent());
        return jsonObject;
    }

}
