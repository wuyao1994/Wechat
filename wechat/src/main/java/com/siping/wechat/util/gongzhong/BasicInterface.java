package com.siping.wechat.util.gongzhong;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.siping.wechat.WeChatConstant;
import com.siping.wechat.bean.AccessToken;
import com.siping.wechat.bean.WeChatAccount;
import com.siping.wechat.util.WeChatUtil;

/**
 * access_token是公众号的全局唯一票据，公众号调用各接口时都需使用access_token。
 * 开发者需要进行妥善保存。access_token的存储至少要保留512个字符空间。
 * access_token的有效期目前为2个小时，需定时刷新，重复获取将导致上次获取的access_token失效。
 * @author nil
 */
public class BasicInterface {
    private static Map<String, String> timeZoneMap = new HashMap<String, String>();

    static {
        /* 非洲 */
        timeZoneMap.put("冈比亚", "Africa/Banjul");
        timeZoneMap.put("摩洛哥", "Africa/Casablanca");
        timeZoneMap.put("几内亚", "Africa/Conakry");
        timeZoneMap.put("利比里亚", "Africa/Monrovia");
        timeZoneMap.put("阿尔及利亚", "Africa/Algiers");
        timeZoneMap.put("中非共和国", "Africa/Bangui");
        timeZoneMap.put("刚果", "Africa/Brazzaville");
        timeZoneMap.put("喀麦隆", "Africa/Douala");
        timeZoneMap.put("安哥拉", "Africa/Luanda");
        timeZoneMap.put("尼日尔共和国", "Africa/Niamey");
        timeZoneMap.put("纳米比亚", "Africa/Windhoek");
        timeZoneMap.put("埃及", "Africa/Cairo");
        timeZoneMap.put("津巴布韦", "Africa/Harare");
        timeZoneMap.put("南非共和国", "Africa/Johannesburg");
        timeZoneMap.put("赞比亚", "Africa/Lusaka");
        /* 欧洲 */
        timeZoneMap.put("英国", "Europe/London");
        timeZoneMap.put("法国", "Europe/Paris");
        timeZoneMap.put("德国", "Europe/Berlin");
        timeZoneMap.put("奥地利", "Europe/Vienna");
        timeZoneMap.put("俄罗斯", "Europe/Moscow");
        timeZoneMap.put("葡萄牙", "Europe/Lisbon");
        timeZoneMap.put("卢森堡", "Europe/Luxembourg");
        timeZoneMap.put("摩纳哥", "Europe/Monaco");
        timeZoneMap.put("梵蒂冈", "Europe/Vatican");
        timeZoneMap.put("波兰", "Europe/Warsaw");
        timeZoneMap.put("瑞士", "Europe/Zurich");
        timeZoneMap.put("克罗地亚", "Europe/Zagreb");
        timeZoneMap.put("瑞典", "Europe/Stockholm");
        timeZoneMap.put("罗马", "Europe/Rome");
        timeZoneMap.put("捷克", "Europe/Prague");
        timeZoneMap.put("西班牙", "Europe/Madrid");
        timeZoneMap.put("丹麦", "Europe/Copenhagen");
        timeZoneMap.put("比利时", "Europe/Brussels");
        timeZoneMap.put("荷兰", "Europe/Amsterdam");
        timeZoneMap.put("匈牙利", "Europe/Budapest");
        timeZoneMap.put("希腊", "Europe/Athens");
        timeZoneMap.put("匈牙利", "Europe/Budapest");
        /* 亚洲 */
        timeZoneMap.put("中国", "Asia/Shanghai");
        timeZoneMap.put("泰国", "Asia/Bangkok");
        timeZoneMap.put("日本", "Asia/Tokyo");
        timeZoneMap.put("韩国", "Asia/Seoul");
        timeZoneMap.put("新加坡", "Asia/Singapore");
        timeZoneMap.put("印度", "Asia/Calcutta");
        timeZoneMap.put("伊朗", "Iran");
        timeZoneMap.put("土耳其", "Turkey");
        timeZoneMap.put("利比亚", "Libya");
        timeZoneMap.put("以色列", "Israel");
        timeZoneMap.put("迪拜", "Asia/Dubai");
        timeZoneMap.put("哈萨克斯坦", "Asia/Almaty");
        timeZoneMap.put("孟加拉", "Asia/Dacca");
        timeZoneMap.put("不丹", "Asia/Thimbu");
        timeZoneMap.put("印度尼西亚", "Asia/Jakarta");
        timeZoneMap.put("文莱", "Asia/Brunei");
        timeZoneMap.put("菲律宾", "Asia/Manila");
        timeZoneMap.put("蒙古", "Asia/Ulaanbaatar");
        timeZoneMap.put("朝鲜", "Asia/Pyongyang");
        /* 北美洲 */
        timeZoneMap.put("美国", "America/Chicago");
        timeZoneMap.put("加拿大", "America/Toronto");
        timeZoneMap.put("夏威夷", "US/Hawaii");
        timeZoneMap.put("墨西哥", "Mexico/General");
        timeZoneMap.put("古巴", "Cuba");
        timeZoneMap.put("牙买加", "Jamaica");
        timeZoneMap.put("巴拿马", "America/Panama");
        /* 南美洲 */
        timeZoneMap.put("阿根廷", "America/Argentina/Buenos_Aires");
        timeZoneMap.put("巴西", "Brazil/Acre");
        timeZoneMap.put("智利", "Chile/EasterIsland");
        /* 大洋洲 */
        timeZoneMap.put("澳大利亚", "Australia/Sydney");
        timeZoneMap.put("斐济", "Pacific/Fiji");
    }

    public static String getTimeZoneByCountry(String country) {
        return timeZoneMap.get(country);
    }

    /**
     * 通过公众服务号或订阅号帐号获取access_token
     * @param appid
     * @param appSecret
     * @return
     */
    public static AccessToken getAccessToken(WeChatAccount wechatAccount) throws Exception {
        String url = WeChatConstant.GTE_ACCESSTOKEN_URL;
        String requestUrl = url.replace("APPID", wechatAccount.getAppid()).replace("APPSECRET", wechatAccount.getAppsecret());
        JSONObject jsonObject = WeChatUtil.sendHttpRequestAndParseResultToJsonobject(requestUrl, "GET", null);
        if (jsonObject.has(WeChatConstant.JSON_ERRCODE_KEY)) {
            throw new Exception(jsonObject.getString(WeChatConstant.JSON_ERRMSG_KEY));
        }

        AccessToken token = null;
        try {
            token = new AccessToken();
            token.setToken(jsonObject.getString("access_token"));
            token.setExpiresIn(jsonObject.getInt("expires_in"));
        } catch (Exception e) {
            throw e;
        }

        wechatAccount.setAccessToken(token);
        return token;
    }
}
