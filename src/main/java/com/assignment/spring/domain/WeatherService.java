package com.assignment.spring.domain;

import com.assignment.spring.infrastructure.database.WeatherEntity;
import com.assignment.spring.infrastructure.database.WeatherMapper;
import com.assignment.spring.weather.api.model.Weather;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class WeatherService {

    private final GetWeatherPort getWeatherPort;
    private final StoreWeatherPort storeWeatherPort;
    private final WeatherMapper weatherMapper;

    public Weather getWeather(final String city) {
        WeatherEntity weatherEntity = getWeatherPort.getWeather(city);
        log.debug("Weather information retrieved.");
        weatherEntity = storeWeatherPort.storeWeather(weatherEntity);
        log.debug("Weather information stored.");
        return weatherMapper.toWeather(weatherEntity);
    }

}
