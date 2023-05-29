package org.cat.paint.beans.bo;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class ExpertTxt2ImgBo extends GenerateImgBo{

    private int steps;

    private long seed;
}
