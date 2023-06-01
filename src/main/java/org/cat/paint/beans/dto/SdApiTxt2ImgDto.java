package org.cat.paint.beans.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.cat.paint.beans.bo.Txt2ImgExpertBo;
import org.cat.paint.beans.bo.Txt2ImgSimpleBo;
import org.cat.paint.utils.ImgUtil;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SdApiTxt2ImgDto extends SdApiBaseDto {

    public static SdApiTxt2ImgDto getInstance(Txt2ImgSimpleBo bo) {
        SdApiTxt2ImgDto instance = defaultInstance(bo.getAspectRatio());
        instance.setPrompt(bo.getPrompt());
        return instance;
    }

    public static SdApiTxt2ImgDto getInstance(Txt2ImgExpertBo bo) {
        return getInstance(bo.getPrompt()
                , bo.getSeed()
                , bo.getDenoisingStrength()
                , bo.getSamplerName()
                , bo.getSteps()
                , bo.getCfgScale()
                , bo.isRestoreFace()
                , bo.getAspectRatio());
    }

    public static SdApiTxt2ImgDto getInstance(String prompt
            , long seed
            , double denoisingStrength
            , String samplerName
            , int step
            , double cfgScale
            , boolean restoreFace
            , int aspectRatioType) {
        SdApiTxt2ImgDto instance = defaultInstance(aspectRatioType);
        instance.setPrompt(prompt);
        instance.setSeed(seed);
        instance.setDenoisingStrength(denoisingStrength);
        instance.setSamplerName(samplerName);
        instance.setSteps(step);
        instance.setCfgScale(cfgScale);
        instance.setRestoreFaces(restoreFace);
        return instance;
    }

    public static SdApiTxt2ImgDto defaultInstance(int aspectRatioType) {
        List<Integer> ratio = ImgUtil.calculateRes(aspectRatioType);
        SdApiTxt2ImgDto instance = new SdApiTxt2ImgDto();
        instance.setBatchSize(1);
        instance.setTiling(false);
        instance.setRestoreFaces(false);
        instance.setWidth(ratio.get(0));
        instance.setHeight(ratio.get(1));
        instance.setCfgScale(7.0);
        instance.setSteps(20);
        instance.setDenoisingStrength(0.75);
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
