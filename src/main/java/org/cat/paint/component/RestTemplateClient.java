package org.cat.paint.component;

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

    public String postForString(String url, Txt2ImgExpertBo bo){
        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.put("Content-Type", Collections.singletonList(MediaType.APPLICATION_JSON_VALUE));
        headers.put("Accept", Collections.singletonList(MediaType.APPLICATION_JSON_VALUE));

        HttpEntity<Txt2ImgExpertBo> reqEntity = new HttpEntity<>(bo,headers);

        ResponseEntity<String> result = template.postForEntity(url, reqEntity, String.class);
        return result.getBody();
    }

    public String postForString(String url, SdApiBaseDto bo){
        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.put("Content-Type", Collections.singletonList(MediaType.APPLICATION_JSON_VALUE));
        headers.put("Accept", Collections.singletonList(MediaType.APPLICATION_JSON_VALUE));

        HttpEntity<SdApiBaseDto> reqEntity = new HttpEntity<>(bo,headers);

        ResponseEntity<String> result = template.postForEntity(url, reqEntity, String.class);
        return result.getBody();
    }


}
