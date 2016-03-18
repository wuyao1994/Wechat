package com.siping.wechat.bean.message;

public class ScancodeWaitEvent extends EventMessage {

    private String eventKey;
    private ScanCodeInfo scanCodeInfo;
    public String getEventKey() {
        return eventKey;
    }
    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
    public ScanCodeInfo getScanCodeInfo() {
        return scanCodeInfo;
    }
    public void setScanCodeInfo(ScanCodeInfo scanCodeInfo) {
        this.scanCodeInfo = scanCodeInfo;
    }
    
}
