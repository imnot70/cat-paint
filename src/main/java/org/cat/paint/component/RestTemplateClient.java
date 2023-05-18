package org.cat.paint.component;

import com.alibaba.fastjson2.JSONObject;
import org.cat.paint.beans.bo.Txt2ImgBo;
import org.cat.paint.beans.vo.ImageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
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

    @Autowired
    private RestTemplate template;

    public String postForString(String url, Txt2ImgBo bo){

//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.put("Content-Type",Arrays.asList(MediaType.APPLICATION_JSON_VALUE));
        headers.put("Accept",Arrays.asList(MediaType.APPLICATION_JSON_VALUE));

        HttpEntity<Txt2ImgBo> reqEntity = new HttpEntity<>(bo,headers);

        ResponseEntity<String> result = template.postForEntity(url, reqEntity, String.class);
        return result.getBody();
    }


}
