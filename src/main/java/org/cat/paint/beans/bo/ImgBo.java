package org.cat.paint.beans.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 所有的图片生成接口参数的基类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class ImgBo extends BaseBo{

    /**
     * 纵横比
     */
    private int aspectRatio;

    /**
     * 模型（CheckPoint）名称
     */
    private String checkPointName;

    /**
     * prompt
     */
    private List<String> prompts;

}
