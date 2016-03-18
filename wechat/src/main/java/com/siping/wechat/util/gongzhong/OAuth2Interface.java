package com.siping.wechat.util.gongzhong;

import java.net.URLEncoder;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.siping.wechat.WeChatConstant;
import com.siping.wechat.bean.Oauth2Token;
import com.siping.wechat.bean.WeChatAccount;
import com.siping.wechat.bean.WeChatUserInfo;
import com.siping.wechat.util.WeChatUtil;

public class OAuth2Interface {
    /**
     * 根据微信帐号和code信息获取oauth的token
     * @param appid
     * @param appSecret
     * @param code
     * @return
     */
    public static Oauth2Token getOauth2Token(WeChatAccount wechatAccount, String code) throws Exception{
        String requestURL = WeChatConstant.GET_OAUTH_URL;
        requestURL = requestURL.replace("APPID", wechatAccount.getAppid()).replace("SECRET", wechatAccount.getAppsecret()).replace("CODE", code);

        JSONObject jsonObject = WeChatUtil.sendHttpRequestAndParseResultToJsonobject(requestURL, "GET", null);

        if(jsonObject.has(WeChatConstant.JSON_ERRCODE_KEY)){
            throw new Exception(jsonObject.getString(WeChatConstant.JSON_ERRMSG_KEY));
        }

        Oauth2Token oauthToken = new Oauth2Token();
        oauthToken.setToken(jsonObject.getString("access_token"));
        oauthToken.setExpiresIn(jsonObject.getInt("expires_in"));
        oauthToken.setRefreshToken(jsonObject.getString("refresh_token"));
        oauthToken.setOpenId(jsonObject.getString("openid"));
        oauthToken.setScope(jsonObject.getString("scope"));
        return oauthToken;
    }

    /**
     * 根据OAuth2token获取UserInfo
     * @param token TODO
     * @return
     */
    public static WeChatUserInfo getOAuth2UserInfo(Oauth2Token token) throws Exception{
        WeChatUserInfo userInfo = null;
        String requestUrl = WeChatConstant.GET_OAUTH_USER;
        requestUrl = requestUrl.replace("ACCESS_TOKEN", token.getRefreshToken()).replace("OPENID", token.getOpenId());
        try {
            JSONObject jsonObject = WeChatUtil.sendHttpRequestAndParseResultToJsonobject(requestUrl, "GET", null);
            if(jsonObject.has(WeChatConstant.JSON_ERRCODE_KEY)){
                throw new Exception(jsonObject.getString(WeChatConstant.JSON_ERRMSG_KEY));
            }

            userInfo = new WeChatUserInfo(jsonObject.getString("openid"));
            userInfo.setNickname(jsonObject.getString("nickname"));
            userInfo.setSex(jsonObject.getInt("sex"));

            if(jsonObject.has("country")){
                userInfo.setCountry(jsonObject.getString("country"));
            }
            if(jsonObject.has("province")){
                userInfo.setProvince(jsonObject.getString("province"));
            }
            if(jsonObject.has("city")){
                userInfo.setCity(jsonObject.getString("city"));
            }
            if (userInfo.getCountry() != null) {
                String timeZone = BasicInterface.getTimeZoneByCountry(userInfo.getCountry());
                userInfo.setTimeZone(timeZone);
            }
            userInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
            userInfo.setSubscribeTime(new Date());
        } catch (JSONException e) {
            throw e;
        }
        return userInfo;
    }

    /**
     * 根据重定向url生成oauth链接
     * @param wechatAccount
     * @param redirectUrl
     * @return
     * @throws Exception
     */
    public static String generateOauthUrl(WeChatAccount wechatAccount, String redirectUrl, String type) throws Exception{
        if (type == null || type.equalsIgnoreCase("base")) {
            return WeChatConstant.OAUTH_BASE_REDIRECT_URL.replace("REDIRECT_URI", URLEncoder.encode(redirectUrl, "UTF-8")).replace("APPID", wechatAccount.getAppid());
        } else {
            return WeChatConstant.OAUTH_INFO_REDIRECT_URL.replace("REDIRECT_URI", URLEncoder.encode(redirectUrl, "UTF-8")).replace("APPID", wechatAccount.getAppid());
        }
    }

}
