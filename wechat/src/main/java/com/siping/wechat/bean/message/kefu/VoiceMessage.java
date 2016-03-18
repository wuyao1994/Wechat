package com.siping.wechat.bean.message.kefu;

import org.json.JSONObject;

public class VoiceMessage extends KeFuMessage {
    private Media voice;

    public Media getVoice() {
        return voice;
    }

    public void setVoice(Media voice) {
        this.voice = voice;
    }

    public JSONObject generateJsonObject() throws Exception {
        JSONObject jsonObject = super.generateJsonObject();
        jsonObject.put("voice", this.getVoice().generateJsonObject());
        return jsonObject;
    }
}
