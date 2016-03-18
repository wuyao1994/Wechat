package com.siping.wechat.bean.message;


public class TemplateData {
    private String value;
    private String color = "#000000";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
