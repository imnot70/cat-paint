package org.cat.paint.controller;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.cat.paint.beans.bo.Txt2ImgExpertBo;
import org.cat.paint.beans.bo.Txt2ImgSimpleBo;
import org.cat.paint.beans.vo.CheckPointVo;
import org.cat.paint.beans.vo.ImageVo;
import org.cat.paint.beans.vo.Result;
import org.cat.paint.component.RestTemplateClient;
import org.cat.paint.config.Config;
import org.cat.paint.constant.StrConst;
import org.cat.paint.enums.SdApiEnum;
import org.cat.paint.service.ImageService;
import org.cat.paint.utils.ImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/api/v1/paint")
@RestController
public class PaintController extends BaseController{

    private static final String HTTP_PREFIX = RestTemplateClient.HTTP_PREFIX;
    @Autowired
    private Config config;
    @Autowired
    private RestTemplateClient client;
    @Autowired
    private ImageService imageService;

    /**
     * 获取checkpoints列表（不分页）
     * @return  模型列表
     */
    @GetMapping("/models/ckpt")
    public Result<List<CheckPointVo>> ckpts(){
        return success(null);
    }

    @PostMapping("/simple/txt2img")
    public Result<ImageVo> txt2ImgSimple(@RequestBody Txt2ImgSimpleBo bo){
        // TODO 参数检验
        ImageVo imageVo = imageService.txt2Img(bo);
        return success(imageVo);
    }

    @PostMapping("/expert/txt2img")
    public Result<ImageVo> txt2ImgExpert(@RequestBody Txt2ImgExpertBo bo){
        // TODO 参数检验
        ImageVo imageVo = imageService.txt2Img(bo);
        return success(imageVo);
    }

    @GetMapping("/checkpoints")
    public Result<List<CheckPointVo>> checkPoints(){
        return null;
    }

    @GetMapping("/process")
    public Result<String> process(@RequestParam String taskId){
        return null;
    }

}
