package org.cat.paint.service.impl;

import org.cat.paint.beans.bo.Img2ImgBo;
import org.cat.paint.beans.bo.Txt2ImgBo;
import org.cat.paint.beans.bo.Txt2ImgExpertBo;
import org.cat.paint.beans.bo.Txt2ImgSimpleBo;
import org.cat.paint.beans.dto.SdApiTxt2ImgDto;
import org.cat.paint.beans.vo.ImageVo;
import org.cat.paint.beans.vo.Result;
import org.cat.paint.config.Config;
import org.cat.paint.service.ImageService;
import org.cat.paint.utils.ImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private Config config;

    @Override
    public ImageVo txt2Img(Txt2ImgBo bo) {
        ImageVo result = new ImageVo();

        SdApiTxt2ImgDto dto = new SdApiTxt2ImgDto();
        if(bo instanceof Txt2ImgExpertBo){
           // TODO

        }

        return null;
    }

    private SdApiTxt2ImgDto createDto(){
        return null;
    }

    @Override
    public ImageVo img2Img(Img2ImgBo bo) {
        // TODO
        return null;
    }
}
