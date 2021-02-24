package com.rincentral.test.models;

public class BodyCharacteristics {

    private Integer bodyLength;
    private Integer bodyWidth;
    private Integer bodyHeight;
    private String bodyStyle;

    public BodyCharacteristics(Integer bodyLength, Integer bodyWidth, Integer bodyHeight, String bodyStyle) {
        this.bodyLength = bodyLength;
        this.bodyWidth = bodyWidth;
        this.bodyHeight = bodyHeight;
        this.bodyStyle = bodyStyle;
    }

    public Integer getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(Integer bodyLength) {
        this.bodyLength = bodyLength;
    }

    public Integer getBodyWidth() {
        return bodyWidth;
    }

    public void setBodyWidth(Integer bodyWidth) {
        this.bodyWidth = bodyWidth;
    }

    public Integer getBodyHeight() {
        return bodyHeight;
    }

    public void setBodyHeight(Integer bodyHeight) {
        this.bodyHeight = bodyHeight;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }
}
