package org.cat.paint.service;

import org.cat.paint.beans.bo.Img2ImgBo;
import org.cat.paint.beans.bo.Txt2ImgBo;
import org.cat.paint.beans.dto.ResizeDto;
import org.cat.paint.beans.vo.ImageVo;

public interface ImageService {

    ImageVo txt2Img(Txt2ImgBo bo);

    /**
     * 缩放图片
     */
    ImageVo resize(ResizeDto dto);

    ImageVo img2Img(Img2ImgBo bo);
}
