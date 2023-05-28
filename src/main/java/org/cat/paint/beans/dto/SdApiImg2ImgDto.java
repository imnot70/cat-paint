package org.cat.paint.beans.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SdApiImg2ImgDto extends SdApiBaseDto{

    @JsonProperty("init_images")
    private String[] initImages;

    @JsonProperty("resize_mode")
    private int resizeMode;

    @JsonProperty("image_cfg_scale")
    private double imageCfgScale;

    @JsonProperty("mask")
    private String mask;

    @JsonProperty("mask_blur")
    private int maskBlur;

    @JsonProperty("inpainting_fill")
    private double inpaintingFill;

    @JsonProperty("inpaint_full_res")
    private boolean inpaintFullRes;

    @JsonProperty("inpaint_full_res_padding")
    private double inpaintFullResPadding;

    @JsonProperty("inpainting_mask_invert")
    private double inpaintingMaskInvert;

    @JsonProperty("initial_noise_multiplier")
    private double initialMoiseMultiplier;

    @JsonProperty("include_init_images")
    private boolean includeInitImages;

}
