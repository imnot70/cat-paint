package org.cat.paint.beans.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SdApiTxt2ImgDto extends SdApiBaseDto{

    /**
     * 是否使用高清修复
     */
    @JsonProperty("enable_hr")
    private boolean enableHr;

    /**
     * firstphase_width
     */
    @JsonProperty("firstphase_width")
    private int firstPhaseWidth;

    /**
     * firstphase_height
     */
    @JsonProperty("firstphase_height")
    private int firstPhaseHeight;

    /**
     * 高清放大倍数
     */
    @JsonProperty("hr_scale")
    private double hrScale;

    /**
     * 放大器名称
     */
    @JsonProperty("hr_upscaler")
    private String hrUpscaler;

    /**
     * hr_second_pass_steps
     */
    @JsonProperty("hr_second_pass_steps")
    private int hrSecondPassSteps;

    /**
     * hr_resize_x
     */
    @JsonProperty("hr_resize_x")
    private int hrResizeX;

    /**
     * hr_resize_y
     */
    @JsonProperty("hr_resize_y")
    private int hrResizeY;




}
