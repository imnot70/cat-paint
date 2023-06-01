package org.cat.paint.service.impl;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.cat.paint.beans.bo.Img2ImgBo;
import org.cat.paint.beans.bo.Txt2ImgBo;
import org.cat.paint.beans.bo.Txt2ImgExpertBo;
import org.cat.paint.beans.bo.Txt2ImgSimpleBo;
import org.cat.paint.beans.dto.SdApiTxt2ImgDto;
import org.cat.paint.beans.vo.ImageVo;
import org.cat.paint.beans.vo.Result;
import org.cat.paint.component.RestTemplateClient;
import org.cat.paint.config.Config;
import org.cat.paint.constant.StrConst;
import org.cat.paint.enums.RespCode;
import org.cat.paint.enums.SdApiEnum;
import org.cat.paint.exception.BusinessException;
import org.cat.paint.service.ImageService;
import org.cat.paint.utils.ImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private Config config;
    @Autowired
    private RestTemplateClient client;

    @Override
    public ImageVo txt2Img(Txt2ImgBo bo) {
        SdApiTxt2ImgDto dto = (bo instanceof Txt2ImgExpertBo)
                ? SdApiTxt2ImgDto.getInstance((Txt2ImgExpertBo) bo)
                : SdApiTxt2ImgDto.getInstance(bo.getPrompt());

        Map<String,String> overrideSettings = new HashMap<>();
        overrideSettings.put("sd_model_checkpoint",bo.getCheckPointName());
        dto.setOverrideSettings(overrideSettings);

        ImageVo result = new ImageVo();
        String url = RestTemplateClient.HTTP_PREFIX + config.getSdHost() + StrConst.STR_COLON + config.getSdPort() + SdApiEnum.TEXT2IMG.uri();
        String generateResult = client.postForString(url, dto);
        JSONObject resultObject = JSONObject.parseObject(generateResult);
        JSONArray images = resultObject.getJSONArray(StrConst.SD_ATTR_IMG);
        String imageStr = images.toString();
        if(imageStr == null || imageStr.trim().length() == 0){
            log.info("imgStr is empty,url:{}",url);
            throw new BusinessException(RespCode.SYSTEM_ERR);
        }else{
            imageStr = imageStr.substring(2,imageStr.length()-2);
        }
        // FIXME userId
        String filePath = ImgUtil.getFilePath(10000L);
        ImgUtil.text2Jpg(filePath,imageStr);
        result.setUri(filePath);
        return result;
    }

    @Override
    public ImageVo img2Img(Img2ImgBo bo) {
        // TODO
        return null;
    }
}
