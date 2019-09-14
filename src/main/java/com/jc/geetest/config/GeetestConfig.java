package com.jc.geetest.config;

import com.jc.geetest.sdk.GeetestLib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * GeetestConfig
 */
@Configuration
public class GeetestConfig {

    @Value("${geetest.geetest-id}")
    private String geetestId;

    @Value("${geetest.geetest-key}")
    private String geetestKey;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public GeetestLib geetestLib() {
        return new GeetestLib(geetestId, geetestKey, restTemplate);
    }
}
