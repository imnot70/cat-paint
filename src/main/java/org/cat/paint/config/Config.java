package org.cat.paint.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Getter
@Configuration
public class Config {

    @Value("${stable-diffusion.host}")
    private String sdHost;
    @Value("${stable-diffusion.port}")
    private String sdPort;
    @Value("${file.path.input}")
    private String cacheFilePath;
    @Value("${file.path.output}")
    private String outPutFilePath;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
