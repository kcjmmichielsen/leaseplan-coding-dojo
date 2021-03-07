package com.assignment.spring.infrastructure.openweathermap;

import com.assignment.spring.infrastructure.openweathermap.models.WeatherResponse;
import com.assignment.spring.application.config.WeatherApiProperties;
import com.assignment.spring.domain.GetWeatherPort;
import com.assignment.spring.infrastructure.database.WeatherEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@Component
public class GetWeatherAdapter implements GetWeatherPort {

    private final WeatherApiProperties weatherApiProperties;
    private final RestTemplate restTemplate;
    private final OpenWeatherMapper openWeatherMapper;

    @Override
    public WeatherEntity getWeather(String city) {
        String url = weatherApiProperties.getUrl().replace("{city}", city).replace("{appid}", weatherApiProperties.getAppId());
        ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(url, WeatherResponse.class);
        return openWeatherMapper.toWeatherEntity(response.getBody());
    }
}
