package com.example.restemplate;

import org.springframework.beans.factory.annotation.Autowired;
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

    public String makeShawnMendesRequest(String term, Integer limit) {

        String uri = "https://itunes.apple.com/search?term=" + term + "&limit=" + limit;
        ResponseEntity<String> exchange = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                String.class
        );
        return exchange.getBody();
    }


}
