package com.assignment.spring.application;

import com.assignment.spring.domain.WeatherService;
import com.assignment.spring.weather.api.model.Weather;
import com.assignment.spring.weather.api.rest.ApiApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@RequiredArgsConstructor
@Controller
public class WeatherController implements ApiApi{

    private final WeatherService weatherService;

    @GetMapping(value = "/weather")
    @ResponseBody
    public ResponseEntity<Weather> getWeatherForCity(@RequestParam final String city) {
        log.debug("Retrieving weather for city '{}'", city);
        return new ResponseEntity(weatherService.getWeather(city), HttpStatus.OK);
    }

}
