package org.cat.paint.enums;

public enum SdApiEnum {

    MODEL_CHECKPOINTS("/sdapi/v1/sd-models","获取CheckPoints模型"),
    MODEL_CHECKPOINTS_REFRESH("/sdapi/v1/refresh-checkpoints","重新加载CheckPoints模型"),
    CONTROL_NET_MODELS("/controlnet/model_list","ControlNet的模型列表"),
    TEXT2IMG("/sdapi/v1/txt2img","文生图"),
    IMG2IMG("/sdapi/v1/txt2img","图生图");


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
