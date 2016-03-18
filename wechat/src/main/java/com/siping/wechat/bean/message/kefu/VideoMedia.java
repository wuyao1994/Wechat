package com.siping.wechat.bean.message.kefu;

import org.json.JSONObject;

public class VideoMedia extends Media {
    private String thumbMediaId;
    private String title;
    private String description;

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JSONObject generateJsonObject() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("media_id", this.getMediaId());
        jsonObject.put("thumb_media_id", this.getThumbMediaId());
        jsonObject.put("title", this.getTitle());
        jsonObject.put("description", this.getDescription());
        return jsonObject;
    }
}
