package com.assignment.spring.domain;

import com.assignment.spring.infrastructure.database.WeatherEntity;

@FunctionalInterface
public interface GetWeatherPort {

    WeatherEntity getWeather(String city);
}
