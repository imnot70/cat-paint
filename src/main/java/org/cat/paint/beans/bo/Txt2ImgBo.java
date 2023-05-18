package org.cat.paint.beans.bo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Txt2ImgBo extends BaseBo{

    private int steps;

    private List<String> prompts;

}
