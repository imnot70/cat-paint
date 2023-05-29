package org.cat.paint.beans.vo;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class ImageVo extends BaseVo {

    private String taskId;

    private String uri;

}
