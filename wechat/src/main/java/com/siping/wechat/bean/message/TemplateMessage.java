package com.siping.wechat.bean.message;

import java.util.Iterator;
import java.util.Map;

import org.json.JSONObject;

import com.siping.wechat.bean.WeChatUserInfo;

public class TemplateMessage {
    private String template_id;
    private WeChatUserInfo touser;
    private String url;
    private String topcolor = "#000000";
    private Map<String, TemplateData> datas;

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public WeChatUserInfo getTouser() {
        return touser;
    }

    public void setTouser(WeChatUserInfo touser) {
        this.touser = touser;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTopcolor() {
        return topcolor;
    }

    public void setTopcolor(String topcolor) {
        this.topcolor = topcolor;
    }

    public Map<String, TemplateData> getData() {
        return datas;
    }

    public void setData(Map<String, TemplateData> data) {
        this.datas = data;
    }

    public String generateUploadJson() throws Exception {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("touser", this.getTouser().getOpenid());
        jsonObject.put("template_id", this.getTemplate_id());
        jsonObject.put("url", this.getUrl());
        jsonObject.put("topcolor", this.getTopcolor());

        JSONObject datasJson = new JSONObject();
        Iterator<String> keys = this.getData().keySet().iterator();
        while(keys.hasNext()){
            String key = keys.next();
            TemplateData data = datas.get(key);

            JSONObject dataJson = new JSONObject();
            dataJson.put("value", data.getValue());
            dataJson.put("color", data.getColor());
            datasJson.put(key, dataJson);
        }

        jsonObject.put("data", datasJson);

        return jsonObject.toString();
    }
}
