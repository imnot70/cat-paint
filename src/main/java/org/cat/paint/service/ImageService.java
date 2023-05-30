package org.cat.paint.service;

import org.cat.paint.beans.bo.Img2ImgBo;
import org.cat.paint.beans.bo.Txt2ImgBo;
import org.cat.paint.beans.vo.ImageVo;

public interface ImageService {

    ImageVo txt2Img(Txt2ImgBo bo);

    ImageVo img2Img(Img2ImgBo bo);
}
