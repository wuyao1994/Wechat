package com.siping.wechat.util.gongzhong;

import org.json.JSONObject;

import com.siping.wechat.WeChatConstant;
import com.siping.wechat.bean.WeChatAccount;
import com.siping.wechat.bean.WeChatUserInfo;
import com.siping.wechat.bean.message.TemplateMessage;
import com.siping.wechat.bean.message.TextMessage;
import com.siping.wechat.util.WeChatUtil;

public class MessageInterface {

    /**
     * 发送模版消息
     * @param wechatAccount
     * @param message
     * @param user
     * @throws Exception
     */
    public static void sendTemplateMessege(WeChatAccount wechatAccount, TemplateMessage message , WeChatUserInfo user) throws Exception{
        String url = WeChatConstant.SEND_TEMPLATE_MESSAGE;
        url = url.replace("ACCESS_TOKEN", wechatAccount.getAccessToken().getToken());
        message.setTouser(user);
        JSONObject jsonObject = WeChatUtil.sendHttpRequestAndParseResultToJsonobject(url, "POST", message.generateUploadJson());
        try {
            if(jsonObject.getInt(WeChatConstant.JSON_ERRCODE_KEY) != 0){
                throw new Exception(jsonObject.getString(WeChatConstant.JSON_ERRMSG_KEY));
            }
        } catch (Exception e) {
            throw e;
        }
    }

}
