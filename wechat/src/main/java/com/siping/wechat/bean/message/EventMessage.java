package com.siping.wechat.bean.message;

import java.util.Map;

public abstract class EventMessage extends Message {

    private String event;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public static EventMessage create(Map<String, Object> map) throws Exception {
        EventMessage message = null;
        String event = map.get("Event").toString();

        if (event.equals("LOCATION")) {
            LocationEvent locationEvent = new LocationEvent();
            locationEvent.setLatitude(Double.parseDouble(map.get("Latitude").toString()));
            locationEvent.setLongitude(Double.parseDouble(map.get("Longitude").toString()));
            locationEvent.setPrecision(Float.parseFloat(map.get("Precision").toString()));
            message = locationEvent;
        } else if (event.equals("subscribe")) {
            SubscribeEvent subscribeEvent = new SubscribeEvent();
            message = subscribeEvent;
        } else if (event.equals("CLICK")) {
            ClickEvent mentEvent = new ClickEvent();
            mentEvent.setEventKey(map.get("EventKey").toString());
            message = mentEvent;
        } else if (event.equals("scancode_waitmsg")) {
            ScancodeWaitEvent scancodeWaitEvent = new ScancodeWaitEvent();
            scancodeWaitEvent.setEventKey(map.get("EventKey").toString());
            Map<String, Object> scanCodeInfoMap = (Map<String, Object>) map.get("ScanCodeInfo");
            ScanCodeInfo scanCodeInfo = new ScanCodeInfo();
            scanCodeInfo.setScanType(scanCodeInfoMap.get("ScanType").toString());
            scanCodeInfo.setScanResult(scanCodeInfoMap.get("ScanResult").toString());
            scancodeWaitEvent.setScanCodeInfo(scanCodeInfo);
            message = scancodeWaitEvent;
        } else if (event.equals("unsubscribe")) {
            UnSubscribeEvent unsubscribeEvent = new UnSubscribeEvent();
            message = unsubscribeEvent;
        } else if (event.equals("VIEW")) {
            ViewEvent mentEvent = new ViewEvent();
            mentEvent.setEventKey(map.get("EventKey").toString());
            message = mentEvent;
        } else if (event.equals("SCAN")) {
            QrEvent qrEvent = new QrEvent();
            qrEvent.setEventKey(map.get("EventKey").toString());
            qrEvent.setTicket(map.get("Ticket").toString());
            message = qrEvent;
        } else {
            throw new Exception("Unsupported message.");
        }

        message.setEvent(event);
        message.setToUserName(map.get("ToUserName").toString());
        message.setFromUserName(map.get("FromUserName").toString());
        message.setCreateTime(Long.parseLong(map.get("CreateTime").toString()));
        message.setMsgType(MessageType.create(map.get("MsgType").toString()));
        return message;
    }
}
