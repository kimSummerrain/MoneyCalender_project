package com.example.MoneyCalender_project.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class GooglePlaceConfig {

    @Value("${google.places.api.key}")
    private String apiKey;

}