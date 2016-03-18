package com.siping.wechat.bean.message;

public class LocationEvent extends EventMessage {

    private Double latitude;
    private Double longitude;
    private Float precision;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Float getPrecision() {
        return precision;
    }

    public void setPrecision(Float precision) {
        this.precision = precision;
    }

}
