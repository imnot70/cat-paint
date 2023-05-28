package org.cat.paint.beans.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class SdApiBaseDto {

    /**
     * 降噪强度，生成图片时0.75，使用放大插件时0.2
     */
    @JsonProperty("denoising_strength")
    private double denoisingStrength;

    /**
     * 提示词，多个值之间用逗号分隔
     */
    @JsonProperty("prompt")
    private String prompt;

    /**
     * 反向提示词，多个值之间用逗号分隔
     */
    @JsonProperty("negative_prompt")
    private String negativePrompt;

    /**
     * styles
     */
    @JsonProperty("styles")
    private String[] styles;

    /**
     * 随机种子
     */
    @JsonProperty("seed")
    private long seed;

    /**
     * 子种子
     */
    @JsonProperty("subseed")
    private long subSeed;

    /**
     * subseed_strength
     */
    @JsonProperty("subseed_strength")
    private double subSeedStrength;

    /**
     * seed_resize_from_h
     */
    @JsonProperty("seed_resize_from_h")
    private int seedResizeFromH;

    /**
     * seed_resize_from_w
     */
    @JsonProperty("seed_resize_from_w")
    private int seedResizeFromW;

    @JsonProperty("restore_faces")
    private boolean restoreFaces;

    @JsonProperty("tiling")
    private boolean tiling;

    /**
     * batch_size
     */
    @JsonProperty("batch_size")
    private int batchSize;

    /**
     * n_iter
     */
    @JsonProperty("n_iter")
    private int niter;

    /**
     * 迭代步数
     */
    @JsonProperty("steps")
    private int steps;

    /**
     * 提示词引导权重，值越大AI发挥空间越小，建议7-30
     */
    @JsonProperty("cfg_scale")
    private double cfgScale;

    @JsonProperty("width")
    private int width;

    @JsonProperty("height")
    private int height;

    /**
     * 采样器名称
     */
    @JsonProperty("sampler_name")
    private String samplerName;

    @JsonProperty("sampler_index")
    private String samplerIndex;

    @JsonProperty("do_not_save_samples")
    private boolean doNotSaveSamples;

    @JsonProperty("do_not_save_grid")
    private boolean doNotSaveGrid;

    @JsonProperty("s_min_uncond")
    private double sMinUncond;

    @JsonProperty("eta")
    private long eta;

    @JsonProperty("s_churn")
    private double sChurn;

    @JsonProperty("s_tmax")
    private long stmax;

    @JsonProperty("s_tmin")
    private long stmin;

    @JsonProperty("s_noise")
    private double sNoise;

    /**
     * 需要覆盖的配置
     */
    @JsonProperty("override_settings")
    private Map<String,String> overrideSettings;

    /**
     * 生成后恢复覆盖的配置
     */
    @JsonProperty("override_settings_restore_afterwards")
    private boolean overrideSettingsRestoreAfterwards;

    /**
     * 脚本名称
     */
    @JsonProperty("script_name")
    private String scriptName;

    /**
     * 脚本参数
     */
    @JsonProperty("script_args")
    private Object[] scriptArgs;

    @JsonProperty("save_images")
    private boolean sendImages;

    @JsonProperty("save_images")
    private boolean saveImages;

    @JsonProperty("alwayson_scripts")
    private Map<String,String> alwaysonScripts;

}
