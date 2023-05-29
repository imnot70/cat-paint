package org.cat.paint.beans.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class GenerateImgBo extends BaseBo {

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
