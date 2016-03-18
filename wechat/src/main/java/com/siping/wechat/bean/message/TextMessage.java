
package com.siping.wechat.bean.message;

public class TextMessage extends CommonMessage implements ReplayableMessage{

    private String content = "";

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String generateXMLContent() throws Exception {
        String xml = "<xml>";
        xml += "<ToUserName><![CDATA[" + this.getToUserName() + "]]></ToUserName>";
        xml += "<FromUserName><![CDATA[" + this.getFromUserName() + "]]></FromUserName>";
        xml += "<CreateTime>" + this.getCreateTimeStr() + "</CreateTime>";
        xml += "<MsgType><![CDATA[" + this.getMsgType() + "]]></MsgType>";
        xml += "<Content><![CDATA[" + this.getContent() + "]]></Content>";
        if(this.getMsgId() != null){
            xml += "<MsgId>" + this.getMsgId() + "</MsgId>";
        }
        xml += "</xml>";
        return xml;
    }
}
