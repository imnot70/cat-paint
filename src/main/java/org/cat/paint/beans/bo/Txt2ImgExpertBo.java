package org.cat.paint.beans.bo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 图生图简易模式参数
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Txt2ImgExpertBo extends Txt2ImgBo {

    private int steps;

    private long seed;
}
