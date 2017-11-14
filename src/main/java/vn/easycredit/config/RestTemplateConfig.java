/*
 * @(#)RestTemplateConfig.java
 * 
 * Copyright 2014 Air Link Co.Ltd . All Rights Reserved.
 * 
 * This software is the proprietary information of Air Link Co.Ltd. Use is
 * subject to license terms.
 */

package vn.easycredit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import vn.easycredit.config.setting.ImxApiSetting;

/**
 * @author HienNT
 *
 */
@Configuration
public class RestTemplateConfig {

    private static final int MILISECOND = 1000;

    @Autowired
    private ImxApiSetting imxApiSetting;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RestTemplate imxRestTemplate() {
        return createRestTemplate(imxApiSetting.getTimeout());
    }
    
    private RestTemplate createRestTemplate(int timeout) {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(timeout * MILISECOND);
        factory.setConnectTimeout(timeout * MILISECOND);
        RestTemplate template = new RestTemplate(new BufferingClientHttpRequestFactory(factory));
//        template.getInterceptors().add(loggingApiInterceptor);
//        template.setErrorHandler(new CustomResponseErrorHandler());
        return template;
    }

}
