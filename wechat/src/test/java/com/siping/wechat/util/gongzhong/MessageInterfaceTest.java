package com.siping.wechat.util.gongzhong;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.siping.wechat.bean.WeChatAccount;
import com.siping.wechat.bean.WeChatUserInfo;
import com.siping.wechat.bean.message.TemplateData;
import com.siping.wechat.bean.message.TemplateMessage;

public class MessageInterfaceTest {
    private static WeChatAccount weChatAccount = new WeChatAccount();

    @Before
    public void createWeChatAccountTest() throws Exception {
        weChatAccount.setAppid("wx90f846fb078ece3c");
        weChatAccount.setAppsecret("eb550804df5ccf87a0d683ae7623066f ");
        weChatAccount.setToken("sipingsoft");
        BasicInterface.getAccessToken(weChatAccount);
    }

    @Test
    public void templateMessage() throws Exception {

        TemplateMessage templateMessage = new TemplateMessage();
        templateMessage.setTemplate_id("TrCBQvynkw5J21KXPgqyDgNC9rH0Ily6C6hMmMfdVGI");
        WeChatUserInfo user = new WeChatUserInfo();
        user.setOpenid("ofRZAs4fdj51B-mNtFT1VkI8UUgQ");
        templateMessage.setTopcolor("#000000");
        templateMessage.setUrl("http://www.baidu.com");
        Map<String, TemplateData> data = new HashMap<String, TemplateData>();
        TemplateData first = new TemplateData();
        first.setValue("您于2015/05/25 14:58成功申请提现。");
        first.setColor("#0000FF");
        TemplateData keyword1 = new TemplateData();
        keyword1.setValue("100.00\n");
        TemplateData keyword2 = new TemplateData();
        keyword2.setValue("1");
        keyword2.setColor("#FF0000");
        TemplateData keyword3 = new TemplateData();
        keyword3.setValue("99");
        keyword3.setColor("#FF0000");
        TemplateData keyword4 = new TemplateData();
        keyword4.setValue("<a href=\"http://www.baidu.com\">百度</a>");
        keyword4.setColor("#FF0000");
        TemplateData remark = new TemplateData();
        remark.setValue("<a href=\"http://www.baidu.com\">百度</a>");
        remark.setColor("#FF0000");
        data.put("first",first);
        data.put("keyword1",keyword1);
        data.put("keyword2",keyword2);
        data.put("keyword3",keyword3);
        data.put("keyword4",keyword4);
        data.put("remark",remark);
        templateMessage.setData(data);
        MessageInterface.sendTemplateMessege(weChatAccount, templateMessage, user);
        String json = templateMessage.generateUploadJson();
        System.out.println(json);
    }

}
