package org.cat.paint.component;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import org.cat.paint.beans.bo.Txt2ImgExpertBo;
import org.cat.paint.beans.dto.SdApiBaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;

@Component
public class RestTemplateClient {

    public static final String HTTP_PREFIX = "http://";

    @Autowired
    private RestTemplate template;

    public String postForString(String url, SdApiBaseDto bo){
        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONBytes(bo));
        HttpEntity<JSONObject> reqEntity = new HttpEntity<>(jsonObject,headers);
        ResponseEntity<String> result = template.postForEntity(url, reqEntity, String.class);
        return result.getBody();
    }

}
