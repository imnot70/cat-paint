package org.cat.paint.beans.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cat.paint.beans.bo.Txt2ImgExpertBo;
import org.cat.paint.utils.ImgUtil;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SdApiTxt2ImgDto extends SdApiBaseDto {

    public static SdApiTxt2ImgDto getInstance(String prompt) {
        SdApiTxt2ImgDto instance = defaultInstance();
        instance.setPrompt(prompt);
        return instance;
    }

    public static SdApiTxt2ImgDto getInstance(Txt2ImgExpertBo bo) {
        List<Integer> ratio = ImgUtil.calculateRes(bo.getAspectRatio());
        return getInstance(bo.getPrompt()
                , bo.getSeed()
                , bo.getDenoisingStrength()
                , bo.getSamplerName()
                , bo.getSteps()
                , bo.getCfgScale()
                , bo.isRestoreFace()
                , ratio.get(0)
                , ratio.get(1));
    }

    public static SdApiTxt2ImgDto getInstance(String prompt
            , long seed
            , double denoisingStrength
            , String samplerName
            , int step
            , double cfgScale
            , boolean restoreFace
            , int height
            , int width) {
        SdApiTxt2ImgDto instance = defaultInstance();
        instance.setPrompt(prompt);
        instance.setSeed(seed);
        instance.setDenoisingStrength(denoisingStrength);
        instance.setSamplerName(samplerName);
        instance.setSteps(step);
        instance.setCfgScale(cfgScale);
        instance.setRestoreFaces(restoreFace);
        instance.setHeight(height);
        instance.setWidth(width);
        return instance;
    }

    public static SdApiTxt2ImgDto defaultInstance() {
        SdApiTxt2ImgDto instance = new SdApiTxt2ImgDto();
        instance.setBatchSize(1);
        instance.setTiling(false);
        instance.setRestoreFaces(false);
        // TODO 设置默认的反向提示词
        instance.setNegativePrompt(null);
//        instance.setStyles(null);
//        instance.setSubSeed(null);
//        instance.setSubSeedStrength(null);
//        instance.setSeedResizeFromH(null);
//        instance.setSeedResizeFromW(null);
//        instance.setNiter(null);
        return instance;
    }

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
