package com.siping.wechat.bean.message.kefu;

import org.json.JSONObject;

public class ImageMessage extends KeFuMessage {
    private Media image;

    public Media getImage() {
        return image;
    }

    public void setImage(Media image) {
        this.image = image;
    }

    public JSONObject generateJsonObject() throws Exception {
        JSONObject jsonObject = super.generateJsonObject();
        jsonObject.put("image", this.getImage().generateJsonObject());
        return jsonObject;
    }
}
