package com.siping.wechat.bean.message;

public class ClickEvent extends EventMessage {

    private String eventKey;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}
