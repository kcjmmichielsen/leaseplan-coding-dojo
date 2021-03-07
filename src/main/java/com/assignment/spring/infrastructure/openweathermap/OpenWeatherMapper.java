package com.assignment.spring.infrastructure.openweathermap;

import com.assignment.spring.infrastructure.openweathermap.models.WeatherResponse;
import com.assignment.spring.infrastructure.database.WeatherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface OpenWeatherMapper {

    @Mapping(target = "city", source = "name")
    @Mapping(target = "country", source = "sys.country")
    @Mapping(target = "temperature", source = "main.temp")
    WeatherEntity toWeatherEntity(WeatherResponse weatherResponse);

}