package com.example.restemplate.itunes.service;

import com.example.restemplate.itunes.proxy.ItunesProxy;
import com.example.restemplate.itunes.proxy.ItunesResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItunesService {
    @Autowired
    ItunesProxy iTunesClient;
    @Autowired
    ItunesMapper itunesMapper;

    public void fetchShawnMendesSongs() throws JsonProcessingException {
        String json = iTunesClient.makeRequest("shawnmendes", 1);
        if (json != null) {
            ItunesResponse shawnMendesResponse = itunesMapper.mapJsonToItunesResponse(json);
            System.out.println(shawnMendesResponse);
        }
    }

}
