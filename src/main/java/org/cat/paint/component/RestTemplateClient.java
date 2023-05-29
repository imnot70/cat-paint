package org.cat.paint.component;

import org.cat.paint.beans.bo.ExpertTxt2ImgBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class RestTemplateClient {

    @Autowired
    private RestTemplate template;

    public String postForString(String url, ExpertTxt2ImgBo bo){

//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.put("Content-Type",Arrays.asList(MediaType.APPLICATION_JSON_VALUE));
        headers.put("Accept",Arrays.asList(MediaType.APPLICATION_JSON_VALUE));

        HttpEntity<ExpertTxt2ImgBo> reqEntity = new HttpEntity<>(bo,headers);

        ResponseEntity<String> result = template.postForEntity(url, reqEntity, String.class);
        return result.getBody();
    }


}
