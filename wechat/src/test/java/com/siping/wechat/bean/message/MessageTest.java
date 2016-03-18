package com.siping.wechat.bean.message;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.siping.wechat.util.WeChatUtil;

public class MessageTest {

    public static <T extends Message> T parseXMLToMessage(String xml, Class<T> messgeClass) throws Exception {
        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        Map<String, Object> map = WeChatUtil.parseMessageXmlToMap(inputStream);
        Message message = Message.create(map);
        return (T) message;
    }

    @Test
    public void textMessageTest() throws Exception {
        String xml = "<xml>";
        xml += "<ToUserName><![CDATA[toUser]]></ToUserName>";
        xml += "<FromUserName><![CDATA[fromUser]]></FromUserName>";
        xml += "<CreateTime>1348831860</CreateTime>";
        xml += "<MsgType><![CDATA[text]]></MsgType>";
        xml += "<Content><![CDATA[this is a test]]></Content>";
        xml += "<MsgId>1234567890123456</MsgId>";
        xml += "</xml>";
        TextMessage message = parseXMLToMessage(xml, TextMessage.class);

        Assert.assertEquals(message.getMsgType(), MessageType.text);
        String xmlStr = message.generateXMLContent();
        Assert.assertEquals(xml, xmlStr);
    }

    @Test
    public void imageMessageTest() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1348831860</CreateTime><MsgType><![CDATA[image]]></MsgType><PicUrl><![CDATA[this is a url]]></PicUrl><MediaId><![CDATA[media_id]]></MediaId><MsgId>1234567890123456</MsgId></xml>";
        ImageMessage message = parseXMLToMessage(xml, ImageMessage.class);
        Assert.assertEquals(message.getMsgType(), MessageType.image);
        String xmlStr = message.generateXMLContent();
        Assert.assertEquals(xml, xmlStr);
    }

    @Test
    public void voiceMessageTest() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1357290913</CreateTime><MsgType><![CDATA[voice]]></MsgType><MediaId><![CDATA[media_id]]></MediaId><Format><![CDATA[Format]]></Format><MsgId>1234567890123456</MsgId></xml>";
        VoiceMessage message = parseXMLToMessage(xml, VoiceMessage.class);
        Assert.assertEquals(message.getMsgType(), MessageType.voice);
        String xmlStr = message.generateXMLContent();
        Assert.assertEquals(xml, xmlStr);
    }

    @Test
    public void videoMessageTest() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1357290913</CreateTime><MsgType><![CDATA[video]]></MsgType><MediaId><![CDATA[media_id]]></MediaId><ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId><MsgId>1234567890123456</MsgId></xml>";
        VideoMessage message = parseXMLToMessage(xml, VideoMessage.class);
        Assert.assertEquals(message.getMsgType(), MessageType.video);
        String xmlStr = message.generateXMLContent();
        Assert.assertEquals(xml, xmlStr);
    }

    @Test
    public void shortVideoMessageTest() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1357290913</CreateTime><MsgType><![CDATA[shortvideo]]></MsgType><MediaId><![CDATA[media_id]]></MediaId><ThumbMediaId><![CDATA[thumb_media_id]]></ThumbMediaId><MsgId>1234567890123456</MsgId></xml>";
        ShortVideoMessage message = parseXMLToMessage(xml, ShortVideoMessage.class);
        Assert.assertEquals(message.getMsgType(), MessageType.shortvideo);
        String xmlStr = message.generateXMLContent();
        Assert.assertEquals(xml, xmlStr);
    }

    @Test
    public void locationMessageTest() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1351776360</CreateTime><MsgType><![CDATA[location]]></MsgType><Location_X>23.134521</Location_X><Location_Y>113.358803</Location_Y><Scale>20</Scale><Label><![CDATA[位置信息]]></Label><MsgId>1234567890123456</MsgId></xml>";
        LocationMessage message = parseXMLToMessage(xml, LocationMessage.class);
        Assert.assertEquals(message.getMsgType(), MessageType.location);
        String xmlStr = message.generateXMLContent();
        Assert.assertEquals(xml, xmlStr);
    }

    @Test
    public void linkMessageTest() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1351776360</CreateTime><MsgType><![CDATA[link]]></MsgType><Title><![CDATA[公众平台官网链接]]></Title><Description><![CDATA[公众平台官网链接]]></Description><Url><![CDATA[url]]></Url><MsgId>1234567890123456</MsgId></xml>";
        LinkMessage message = parseXMLToMessage(xml, LinkMessage.class);
        Assert.assertEquals(message.getMsgType(), MessageType.link);
        String xmlStr = message.generateXMLContent();
        Assert.assertEquals(xml, xmlStr);
    }

    @Test
    public void subscribeTest() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[FromUser]]></FromUserName><CreateTime>123456789</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[subscribe]]></Event></xml>";
        SubscribeEvent message = parseXMLToMessage(xml, SubscribeEvent.class);
        Assert.assertEquals(message.getMsgType(), MessageType.event);
        String event = message.getEvent();
        Assert.assertTrue(event.equals("subscribe"));
        Assert.assertEquals(event, "subscribe");
    }

    @Test
    public void unSubscribeTest() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[FromUser]]></FromUserName><CreateTime>123456789</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[unsubscribe]]></Event></xml>";
        UnSubscribeEvent message = parseXMLToMessage(xml, UnSubscribeEvent.class);
        Assert.assertEquals(message.getMsgType(), MessageType.event);
        String event = message.getEvent();
        Assert.assertTrue(event.equals("unsubscribe"));
    }

    @Test
    public void qrCodeSubscribeTest() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[FromUser]]></FromUserName><CreateTime>123456789</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[subscribe]]></Event><EventKey><![CDATA[qrscene_123123]]></EventKey><Ticket><![CDATA[TICKET]]></Ticket></xml>";
        SubscribeEvent message = parseXMLToMessage(xml, SubscribeEvent.class);
        Assert.assertEquals(message.getMsgType(), MessageType.event);
        String event = message.getEvent();
        Assert.assertTrue(event.equals("subscribe"));
    }

    @Test
    public void qrTest2() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[FromUser]]></FromUserName><CreateTime>123456789</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[SCAN]]></Event><EventKey><![CDATA[SCENE_VALUE]]></EventKey><Ticket><![CDATA[TICKET]]></Ticket></xml>";
        QrEvent message = parseXMLToMessage(xml, QrEvent.class);
        Assert.assertEquals(message.getMsgType(), MessageType.event);
        String event = message.getEvent();
        Assert.assertTrue(event.equals("SCAN"));
    }

    @Test
    public void locationEventTest() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>123456789</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[LOCATION]]></Event><Latitude>23.137466</Latitude><Longitude>113.352425</Longitude><Precision>119.385040</Precision></xml>";
        LocationEvent message = parseXMLToMessage(xml, LocationEvent.class);
        Assert.assertEquals(message.getMsgType(), MessageType.event);
        String event = message.getEvent();
        Assert.assertTrue(event.equals("LOCATION"));
    }

    @Test
    public void clickEventTest() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[FromUser]]></FromUserName><CreateTime>123456789</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[CLICK]]></Event><EventKey><![CDATA[EVENTKEY]]></EventKey></xml>";
        ClickEvent message = parseXMLToMessage(xml, ClickEvent.class);
        Assert.assertEquals(message.getMsgType(), MessageType.event);
        String event = message.getEvent();
        Assert.assertTrue(event.equals("CLICK"));
    }

    @Test
    public void viewEventTest() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[FromUser]]></FromUserName><CreateTime>123456789</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[VIEW]]></Event><EventKey><![CDATA[www.qq.com]]></EventKey></xml>";
        ViewEvent message = parseXMLToMessage(xml, ViewEvent.class);
        Assert.assertEquals(message.getMsgType(), MessageType.event);
        String event = message.getEvent();
        Assert.assertTrue(event.equals("VIEW"));
    }
    @Test
    public void scancodeWaitEventTest() throws Exception {
        String xml = "<xml><ToUserName><![CDATA[gh_82479813ed64]]></ToUserName><FromUserName><![CDATA[ojpX_jig-gyi3_Q9fHXQ4rdHniQs]]></FromUserName><CreateTime>1412075435</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[scancode_waitmsg]]></Event><EventKey><![CDATA[rselfmenu_0_0]]></EventKey><ScanCodeInfo><ScanType><![CDATA[qrcode]]></ScanType><ScanResult><![CDATA[http://weixin.qq.com/r/pUNnf4HEX9wgrcUc9xa3]]></ScanResult><EventKey><![CDATA[rselfmenu_0_0]]></EventKey></ScanCodeInfo></xml>";
        ScancodeWaitEvent message = parseXMLToMessage(xml, ScancodeWaitEvent.class);
        Assert.assertEquals(message.getMsgType(), MessageType.event);
        String event = message.getEvent();
        Assert.assertTrue(event.equals("scancode_waitmsg"));
    }
}
