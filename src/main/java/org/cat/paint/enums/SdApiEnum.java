package org.cat.paint.enums;

public enum SdApiEnum {
    TEXT2IMG("/sdapi/v1/txt2img","文生图"),
    img2img("/sdapi/v1/txt2img","图生图");

    private final String uri;
    private final String desc;

    SdApiEnum(String uri, String desc) {
        this.uri = uri;
        this.desc = desc;
    }

    public String uri() {
        return uri;
    }

    public String desc(){
        return desc;
    }
}
