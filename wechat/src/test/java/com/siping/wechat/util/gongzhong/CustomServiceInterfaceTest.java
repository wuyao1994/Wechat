package com.siping.wechat.util.gongzhong;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.siping.wechat.bean.FileType;
import com.siping.wechat.bean.MediaFile;
import com.siping.wechat.bean.WeChatAccount;
import com.siping.wechat.bean.message.kefu.CustomService;
import com.siping.wechat.bean.message.kefu.ImageMessage;
import com.siping.wechat.bean.message.kefu.Media;
import com.siping.wechat.bean.message.kefu.MessageType;
import com.siping.wechat.bean.message.kefu.Text;
import com.siping.wechat.bean.message.kefu.TextMessage;

public class CustomServiceInterfaceTest {
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
    public void addCustomServiceTest() throws Exception {
        CustomService custom = new CustomService();
        custom.setKfAccount("cus@HeareaTest");
        custom.setNickname("陈");
        custom.setPassword("123456");
        System.out.println(custom.generateJsonObject().toString());
        CustomerServiceInterface.addCustomerService(weChatAccount, custom);
    }
    //提示参数有问题
    @Test
    @Ignore
    public void updateCustomServiceTest() throws Exception {
        CustomService custom = new CustomService();
        custom.setKfAccount("custom2@HeareaTest");
        custom.setNickname("陈陈");
        custom.setPassword("123456");
        CustomerServiceInterface.updateCustomerService(weChatAccount, custom);
    }

    @Test
    @Ignore
    public void deleteCustomServiceTest() throws Exception {
        CustomService custom = new CustomService();
        custom.setKfAccount("001@HeareaTest");
        custom.setNickname("小陈");
        custom.setPassword("123456");
        CustomerServiceInterface.deleteCustomerService(weChatAccount, custom);
    }

    @Test
    public void sendMessageTest() throws Exception {
        TextMessage textMsg = new TextMessage();
        textMsg.setTouser("ofRZAs0PhmEPTUQ-3u8z9ucxVjcw");
        textMsg.setMsgtype(MessageType.text);
        Text text = new Text();
        text.setContent("Hello World");
        textMsg.setText(text);
        System.out.println(textMsg.generateJsonObject().toString());
        CustomerServiceInterface.sendMessage(weChatAccount, textMsg);

        String filePath = ClassLoader.getSystemClassLoader().getResource("glyphicons-halflings.png").getPath();
        MediaFile mediaFile = new MediaFile();
        mediaFile.setFilePath(filePath);
        mediaFile.setFileType(FileType.IMAGE);
        MediaInterface.addMateria(weChatAccount, mediaFile);

        Media media = new Media();
        media.setMediaId(mediaFile.getMediaId());
        ImageMessage imgageMsg = new ImageMessage();
        imgageMsg.setTouser("ofRZAs0PhmEPTUQ-3u8z9ucxVjcw");
        imgageMsg.setMsgtype(MessageType.image);
        imgageMsg.setImage(media);

        System.out.println(imgageMsg.generateJsonObject().toString());
        CustomerServiceInterface.sendMessage(weChatAccount, imgageMsg);

    }

}
