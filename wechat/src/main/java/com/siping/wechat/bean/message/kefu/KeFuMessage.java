package com.siping.wechat.bean.message.kefu;

import org.json.JSONObject;

import com.siping.wechat.bean.message.SendableMessage;

public class KeFuMessage implements SendableMessage{

    private String touser; //用户的openid
    private MessageType msgtype;
    private CustomService customService;

    public KeFuMessage() {
        super();
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public MessageType getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(MessageType msgtype) {
        this.msgtype = msgtype;
    }

    public CustomService getCustomService() {
        return customService;
    }

    public void setCustomService(CustomService customService) {
        this.customService = customService;
    }

    public JSONObject generateJsonObject() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("touser", this.getTouser());
        jsonObject.put("msgtype", this.getMsgtype());
        if(customService != null) {
            jsonObject.put("customservice", getCustomService().generateJsonObject());
        }
        return jsonObject;
    }

}
