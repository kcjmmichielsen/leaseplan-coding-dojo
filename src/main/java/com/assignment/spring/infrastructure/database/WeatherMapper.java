package com.assignment.spring.infrastructure.database;

import com.assignment.spring.weather.api.model.Weather;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface WeatherMapper {

    Weather toWeather(WeatherEntity entity);

}
