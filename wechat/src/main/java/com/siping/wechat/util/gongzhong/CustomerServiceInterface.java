package com.siping.wechat.util.gongzhong;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.siping.wechat.HttpRequestMethod;
import com.siping.wechat.WeChatConstant;
import com.siping.wechat.bean.WeChatAccount;
import com.siping.wechat.bean.message.kefu.CustomService;
import com.siping.wechat.bean.message.kefu.KeFuMessage;
import com.siping.wechat.util.WeChatUtil;

public class CustomerServiceInterface {

    public static final String KF_LIST = "kf_list";

    public static void addCustomerService(WeChatAccount wechatAccount, CustomService customService) throws Exception {
        String url = WeChatConstant.ADD_CUSTOM_SERVICE;
        url = url.replace("ACCESS_TOKEN", wechatAccount.getAccessToken().getToken());
        try {
            JSONObject jsonObject = WeChatUtil.sendHttpRequestAndParseResultToJsonobject(url, HttpRequestMethod.POST, customService.generateJsonObject().toString());
            if (jsonObject.has(WeChatConstant.JSON_ERRCODE_KEY)) {
                Integer errorCode = jsonObject.getInt(WeChatConstant.JSON_ERRCODE_KEY);
                if (errorCode != 0) {
                    throw new Exception(jsonObject.getString(WeChatConstant.JSON_ERRMSG_KEY));
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void updateCustomerService(WeChatAccount wechatAccount, CustomService customService) throws Exception {
        String url = WeChatConstant.UPDATE_CUSTOM_SERVICE;
        url = url.replace("ACCESS_TOKEN", wechatAccount.getAccessToken().getToken());
        try {
            JSONObject jsonObject = WeChatUtil.sendHttpRequestAndParseResultToJsonobject(url, HttpRequestMethod.POST, customService.generateJsonObject().toString());
            if (jsonObject.has(WeChatConstant.JSON_ERRCODE_KEY)) {
                Integer errorCode = jsonObject.getInt(WeChatConstant.JSON_ERRCODE_KEY);
                if (errorCode != 0) {
                    throw new Exception(jsonObject.getString(WeChatConstant.JSON_ERRMSG_KEY));
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void deleteCustomerService(WeChatAccount wechatAccount, CustomService customService) throws Exception {
        String url = WeChatConstant.DELETE_CUSTOM_SERVICE;
        url = url.replace("ACCESS_TOKEN", wechatAccount.getAccessToken().getToken());
        try {
            JSONObject jsonObject = WeChatUtil.sendHttpRequestAndParseResultToJsonobject(url, HttpRequestMethod.GET, customService.generateJsonObject().toString());
            if (jsonObject.has(WeChatConstant.JSON_ERRCODE_KEY)) {
                Integer errorCode = jsonObject.getInt(WeChatConstant.JSON_ERRCODE_KEY);
                if (errorCode != 0) {
                    throw new Exception(jsonObject.getString(WeChatConstant.JSON_ERRMSG_KEY));
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static List<CustomService> getCustomerService(WeChatAccount wechatAccount, CustomService customService) throws Exception {
        String url = WeChatConstant.GET_CUSTOM_SERVICE;
        url = url.replace("ACCESS_TOKEN", wechatAccount.getAccessToken().getToken());
        List<CustomService> customs = null;
        try {
            JSONObject jsonObject = WeChatUtil.sendHttpRequestAndParseResultToJsonobject(url, HttpRequestMethod.POST, customService.generateJsonObject().toString());
            if (jsonObject.has(WeChatConstant.JSON_ERRCODE_KEY)) {
                Integer errorCode = jsonObject.getInt(WeChatConstant.JSON_ERRCODE_KEY);
                if (errorCode != 0) {
                    throw new Exception(jsonObject.getString(WeChatConstant.JSON_ERRMSG_KEY));
                }
            }
            customs = new ArrayList<CustomService>();
            JSONArray jsonArray = jsonObject.getJSONArray(KF_LIST);
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject customJson = jsonArray.getJSONObject(i);
                CustomService custom = new CustomService();
                custom.setKfAccount(customJson.getString("kf_account"));
                custom.setKfNick(customJson.getString("kf_nick"));
                custom.setKfAccount(customJson.getString("kf_id"));
                custom.setKfAccount(customJson.getString("kf_headimgurl"));
                customs.add(custom);
            }
        } catch (Exception e) {
            throw e;
        }
        return customs;
    }

    public static void sendMessage(WeChatAccount wechatAccount, KeFuMessage message) throws Exception {
        String url = WeChatConstant.SEND_MESSAGE_CUSTOM_SERVICE;
        url = url.replace("ACCESS_TOKEN", wechatAccount.getAccessToken().getToken());
        try {
            JSONObject jsonObject = WeChatUtil.sendHttpRequestAndParseResultToJsonobject(url, HttpRequestMethod.POST, message.generateJsonObject().toString());
            if (jsonObject.has(WeChatConstant.JSON_ERRCODE_KEY)) {
                Integer errorCode = jsonObject.getInt(WeChatConstant.JSON_ERRCODE_KEY);
                if (errorCode != 0) {
                    throw new Exception(jsonObject.getString(WeChatConstant.JSON_ERRMSG_KEY));
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
