package com.example.MoneyCalender_project.service;

import com.example.MoneyCalender_project.config.GooglePlaceConfig;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GooglePlacesService {
    private final GooglePlaceConfig googlePlaceConfig;
    private final RestTemplate restTemplate = new RestTemplate();

    public String getPlaceCategory(String placeName) {
        String apiKey = googlePlaceConfig.getApiKey();

        String url = UriComponentsBuilder.fromHttpUrl("https://maps.googleapis.com/maps/api/place/findplacefromtext/json")
                .queryParam("input", placeName)
                .queryParam("inputtype", "textquery")
                .queryParam("fields", "type")
                .queryParam("key", apiKey)
                .toUriString();

        try {
            GooglePlaceResponse googlePlaceResponse = restTemplate.getForObject(url, GooglePlaceResponse.class);
            System.out.println("API Response: " + googlePlaceResponse); // 응답 로그 출력

            if (googlePlaceResponse != null && googlePlaceResponse.getCandidates() != null && !googlePlaceResponse.getCandidates().isEmpty()) {

                return googlePlaceResponse.getCandidates().get(0).getTypes().isEmpty() ? "unknown" : googlePlaceResponse.getCandidates().get(0).getTypes().get(0);
            }
        } catch (Exception e) {
            // 예외를 로깅
            System.out.println("Exception in getPlaceCategory: " + e.getMessage());
        }

        // 기본값으로 unknown 반환
        return "unknown";
    }

    @Data
    static class GooglePlaceResponse {
        private List<Candidate> candidates;
        }
        @Data
        static class Candidate {
            private List<String> types;
        }
}
