package com.siping.wechat.util.gongzhong;


import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.siping.wechat.bean.FileType;
import com.siping.wechat.bean.MediaFile;
import com.siping.wechat.bean.PicTextMessage;
import com.siping.wechat.bean.WeChatAccount;
import com.siping.wechat.bean.WeChatUserInfo;
import com.siping.wechat.bean.message.TemplateData;
import com.siping.wechat.bean.message.TemplateMessage;

public class MediaInterfaceTest {
    private static WeChatAccount weChatAccount = new WeChatAccount();

    @Before
    public void createWeChatAccountTest() throws Exception {
        weChatAccount.setAppid("wx90f846fb078ece3c");
        weChatAccount.setAppsecret("eb550804df5ccf87a0d683ae7623066f ");
        weChatAccount.setToken("sipingsoft");
        BasicInterface.getAccessToken(weChatAccount);
    }

    @Test
    @Ignore
    public void addMateriaTest() throws Exception {
        String filePath = ClassLoader.getSystemClassLoader().getResource("glyphicons-halflings.png").getPath();
        MediaFile file = new MediaFile();
        file.setFilePath(filePath);
        file.setFileType(FileType.IMAGE);
        MediaInterface.addMateria(weChatAccount, file);
        Assert.assertNotNull(file.getMediaId());
    }

    @Test
    @Ignore
    public void sendPicTextMessageTest() throws Exception{
        String filePath = ClassLoader.getSystemClassLoader().getResource("glyphicons-halflings.png").getPath();
        MediaFile file = new MediaFile();
        file.setFilePath(filePath);
        file.setFileType(FileType.IMAGE);
        MediaInterface.uploadFile(weChatAccount, file);
        Assert.assertNotNull(file.getMediaId());

        PicTextMessage picTextMessage = new PicTextMessage();
        picTextMessage.setHeadImage(file);
        picTextMessage.setTitle("测试消息");
        picTextMessage.setAuthor("测试用户");
        picTextMessage.setContent("Nice to send!");
        picTextMessage.setSourceUrl("http://www.baidu.com");
        MediaInterface.uploadMessage(weChatAccount, picTextMessage);
        MediaInterface.sendAllMessege(weChatAccount, picTextMessage);
    }

    @Test(expected = Exception.class)
    public void uploadAndDownLoadFileTest() throws Exception {
        String filePath = ClassLoader.getSystemClassLoader().getResource("glyphicons-halflings.png").getPath();
        MediaFile file = new MediaFile();
        file.setFilePath(filePath);
        file.setFileType(FileType.IMAGE);
        MediaInterface.uploadFile(weChatAccount, file);
        Assert.assertNotNull(file.getFilePath());

        InputStream is = MediaInterface.downloadFile(weChatAccount, file);
        Assert.assertNotNull(file.getMediaId());
        Assert.assertNotNull(is);

        file.setMediaId("laslkasjfdlksadf");
        MediaInterface.downloadFile(weChatAccount, file);
    }

    @Test
    @Ignore
    public void templateMessage() throws Exception {
        TemplateMessage templateMessage = new TemplateMessage();
        templateMessage.setTemplate_id("TrCBQvynkw5J21KXPgqyDgNC9rH0Ily6C6hMmMfdVGI");
        WeChatUserInfo user = new WeChatUserInfo();
        user.setOpenid("ofRZAs0PhmEPTUQ-3u8z9ucxVjcw");
        templateMessage.setTopcolor("#FF0000");
        templateMessage.setUrl("http://www.baidu.com");
        Map<String, TemplateData> data = new HashMap<String, TemplateData>();
        TemplateData first = new TemplateData();
        first.setValue("模版消息测试：您于2015/05/25 14:58成功申请提现。");
        first.setColor("#FF0000");
        TemplateData keyword1 = new TemplateData();
        keyword1.setValue("100.00");
        keyword1.setColor("#FF0000");
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
