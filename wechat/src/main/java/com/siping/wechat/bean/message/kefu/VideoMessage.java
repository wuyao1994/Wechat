package com.siping.wechat.bean.message.kefu;

import org.json.JSONObject;

public class VideoMessage extends KeFuMessage {
    private VideoMedia video;

    public VideoMedia getVideo() {
        return video;
    }

    public void setVideo(VideoMedia video) {
        this.video = video;
    }

    public JSONObject generateJsonObject() throws Exception {
        JSONObject jsonObject = super.generateJsonObject();
        jsonObject.put("video", this.getVideo().generateJsonObject());
        return jsonObject;
    }
}
