package com.assignment.spring.application.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
public class WeatherApiProperties {

    @Value("${open-weather-map.api-key}")
    private String appId;

    @Value("${open-weather-map.url}")
    private String url;

}