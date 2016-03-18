package com.siping.wechat.bean.message.kefu;

import org.json.JSONObject;

public class MusicMessage extends KeFuMessage {
    private MusicMedia music;

    public MusicMedia getMusic() {
        return music;
    }

    public void setMusic(MusicMedia music) {
        this.music = music;
    }

    public JSONObject generateJsonObject() throws Exception {
        JSONObject jsonObject = super.generateJsonObject();
        jsonObject.put("music", this.getMusic().generateJsonObject());
        return jsonObject;
    }
}
