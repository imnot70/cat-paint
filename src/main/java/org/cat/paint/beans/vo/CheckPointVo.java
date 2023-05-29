package org.cat.paint.beans.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CheckPointVo extends BaseVo{

    /**
     * 模型id
     */
    private long id;
    /**
     * 模型名称
     */
    private String name;
    /**
     * 模型title
     */
    private String title;
    /**
     * 模型预览图地址
     */
    private String preview;

}
