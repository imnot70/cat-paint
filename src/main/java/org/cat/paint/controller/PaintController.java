package org.cat.paint.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.cat.paint.beans.bo.Txt2ImgBo;
import org.cat.paint.beans.vo.ImageVo;
import org.cat.paint.beans.vo.Result;
import org.cat.paint.component.RestTemplateClient;
import org.cat.paint.config.Config;
import org.cat.paint.enums.SdApiEnum;
import org.cat.paint.utils.ImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/paint")
@RestController
public class PaintController extends BaseController{

    private static final String HTTP_PREFIX = "http://";
    @Autowired
    private Config config;
    @Autowired
    private RestTemplateClient client;

    @PostMapping("/test")
    public Result<ImageVo> test(@RequestBody Txt2ImgBo bo) {

        Result<ImageVo> result = new Result<>();
        try {
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("prompt",bo.getPrompts());
//            jsonObject.put("steps",bo.getSteps());
            String s = client.postForString("http://localhost:7860"+ SdApiEnum.TEXT2IMG.uri(), bo);
            JSONObject resultObject = JSONObject.parseObject(s);
            JSONArray images = resultObject.getJSONArray("images");
            String imageStr = images.toString();
            if(imageStr == null || imageStr.trim().length() == 0){
                result.setCode("1000");
                result.setMsg("failed");
                return result;
            }else{
                imageStr = imageStr.substring(2,imageStr.length()-2);
            }
            String outputPath = config.getOutPutFilePath() +"/"+ "a.png";
            ImgUtil.text2Jpg(outputPath,imageStr);
            ImageVo vo = new ImageVo();
            vo.setUri(HTTP_PREFIX + outputPath);
            result.setData(vo);
        }catch (Exception e){
            e.printStackTrace();
            result.setCode("1001");
            result.setMsg("system error");
            return result;
        }
        result.setCode("0000");
        result.setMsg("ok");
        return result;
    }

}
