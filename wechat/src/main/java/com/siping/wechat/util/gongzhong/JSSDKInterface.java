package com.siping.wechat.util.gongzhong;

import java.security.MessageDigest;

import org.json.JSONObject;

import com.siping.wechat.WeChatConstant;
import com.siping.wechat.bean.JSSDKTicket;
import com.siping.wechat.bean.JSSignature;
import com.siping.wechat.bean.WeChatAccount;
import com.siping.wechat.util.WeChatUtil;

public class JSSDKInterface {
    private static String SIGNATURE_TEMPLATE = "jsapi_ticket=JSTICKET&noncestr=NONCESTR&timestamp=TIMESTAMP&url=URL";
    /**
     * 刷新调用jssdk的ticket
     * @param appid
     * @param appSecret
     * @return
     */
    public static JSSDKTicket getJSTicket(WeChatAccount wechatAccount) throws Exception {
        String url = WeChatConstant.GET_JSAPI_TICKET;
        String requestUrl = url.replace("ACCESS_TOKEN", wechatAccount.getAccessToken().getToken());
        JSONObject jsonObject = WeChatUtil.sendHttpRequestAndParseResultToJsonobject(requestUrl, "GET", null);
        if(jsonObject.getInt(WeChatConstant.JSON_ERRCODE_KEY) != 0){
            throw new Exception(jsonObject.getString(WeChatConstant.JSON_ERRMSG_KEY));
        }

        JSSDKTicket ticket = null;
        try {
            ticket = new JSSDKTicket();
            ticket.setTicket(jsonObject.getString("ticket"));
            ticket.setExpiresIn(jsonObject.getInt("expires_in"));
        } catch (Exception e) {
            throw e;
        }

        return ticket;
    }

    /**
     * 刷新调用jssdk的ticket
     * @param appid
     * @param appSecret
     * @return
     */
    public static JSSignature generateSignature(String url, JSSDKTicket ticket) throws Exception {
        JSSignature signature = new JSSignature();
        signature.setUrl(url);

        String sigStr = SIGNATURE_TEMPLATE.replace("JSTICKET", ticket.getTicket());
        sigStr = sigStr.replace("NONCESTR", signature.getNoncestr());
        sigStr = sigStr.replace("TIMESTAMP", signature.getTimestamp() + "");
        sigStr = sigStr.replace("URL", signature.getUrl());

        sigStr = encrypt(sigStr, "sha-1");
        signature.setSignature(sigStr);
        return signature;
    }

    /**
     * md5或者sha-1加密
     * @param inputText 要加密的内容
     * @param algorithmName 加密算法名称：md5或者sha-1，不区分大小写
     * @return
     * @throws Exception
     */

    private static String encrypt(String inputText, String algorithmName) throws Exception {
        if (algorithmName == null || "".equals(algorithmName.trim())) {
            algorithmName = "md5";
        }
        String encryptText = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithmName);
            messageDigest.update(inputText.getBytes("UTF8"));
            encryptText = hex(messageDigest.digest());
        } catch (Exception e) {
            throw e;
        }
        return encryptText;
    }

    /**
     * 返回十六进制字符串
     * @param arr
     * @return
     */
    private static String hex(byte[] arr) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; ++i) {
            sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1,3));
        }
        return sb.toString();
    }
}
