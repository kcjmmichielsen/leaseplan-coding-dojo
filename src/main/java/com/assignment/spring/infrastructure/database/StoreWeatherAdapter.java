package com.assignment.spring.infrastructure.database;

import com.assignment.spring.domain.StoreWeatherPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class StoreWeatherAdapter implements StoreWeatherPort {

    private final WeatherRepository weatherRepository;

    @Override
    public WeatherEntity storeWeather(WeatherEntity weatherEntity) {
        return weatherRepository.save(weatherEntity);
    }
}
