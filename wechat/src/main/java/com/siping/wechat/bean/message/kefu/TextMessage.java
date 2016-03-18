package com.siping.wechat.bean.message.kefu;

import org.json.JSONObject;

public class TextMessage extends KeFuMessage {
    private Text text;

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public void setText(String content) {
        if (text == null) {
            text = new Text();
        }
        text.setContent(content);
    }

    public JSONObject generateJsonObject() throws Exception {
        JSONObject jsonObject = super.generateJsonObject();
        jsonObject.put("text", getText().generateJsonObject());
        return jsonObject;
    }

}
