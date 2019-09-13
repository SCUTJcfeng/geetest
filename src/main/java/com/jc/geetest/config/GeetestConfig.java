package com.jc.geetest.config;

import com.jc.geetest.sdk.GeetestLib;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * GeetestConfig
 */
@Configuration
public class GeetestConfig {

    @Value("${geetest.geetest-id}")
    private String geetestId;

    @Value("${geetest.geetest-key}")
    private String geetestKey;

    @Bean
    public GeetestLib geetestLib() {
        return new GeetestLib(geetestId, geetestKey, true);
    }
}
