package com.siping.wechat.bean.message.kefu;

import org.json.JSONObject;

import com.siping.wechat.bean.message.SendableMessage;

public class CustomService implements SendableMessage{
    private String kfAccount;
    private String kfNick; // 获取客服帐号时用此昵称
    private String kfId;
    private String nickname; // 增删改时用此昵称
    private String password;
    private String kfHeadimgurl;

    public String getKfAccount() {
        return kfAccount;
    }

    public void setKfAccount(String kfAccount) {
        this.kfAccount = kfAccount;
    }

    public String getKfNick() {
        return kfNick;
    }

    public void setKfNick(String kfNick) {
        this.kfNick = kfNick;
    }

    public String getKfId() {
        return kfId;
    }

    public void setKfId(String kfId) {
        this.kfId = kfId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKfHeadimgurl() {
        return kfHeadimgurl;
    }

    public void setKfHeadimgurl(String kfHeadimgurl) {
        this.kfHeadimgurl = kfHeadimgurl;
    }

    public JSONObject generateJsonObject() throws Exception {
        JSONObject jsonObject = new JSONObject();
        if(!isNullOrEmpty(this.getKfAccount())) {
            jsonObject.put("kf_account", this.getKfAccount());
        }
        if(!isNullOrEmpty(this.getNickname())) {
            jsonObject.put("nickname", this.getNickname());
        }
        if(!isNullOrEmpty(this.getPassword())) {
            jsonObject.put("password", this.getPassword());
        }
        return jsonObject;
    }

    private boolean isNullOrEmpty(Object object) {
        if(object == null) {
            return true;
        } else {
            if(object instanceof String) {
                if(object.equals("")) {
                    return true;
                }
            }
        }
        return false;
    }
}
