package com.example.restemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ShawnMendesProxy {

    // GET https://itunes.apple.com/search?term=shawnmendes&limit=1
    @Autowired
    RestTemplate restTemplate;
    @Value("${shawnmendes.service.url}")
    String url;
    @Value("#{1+2+3}")
    int suma;

    public ShawnMendesResponse makeShawnMendesRequest(String term, Integer limit) throws JsonProcessingException {

        String uri = url + "/search?term=" + term + "&limit=" + limit;
        ResponseEntity<String> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                String.class
        );
        String json = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ShawnMendesResponse.class);

    }


}
