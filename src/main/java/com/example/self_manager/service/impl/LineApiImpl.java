package com.example.self_manager.service.impl;

import com.example.self_manager.domain.LineAuthorization;
import com.example.self_manager.domain.LineJwt;
import com.example.self_manager.service.LineApi;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.example.self_manager.config.LineChannelConfig.GET_TOKEN_URL;

@Service
public class LineApiImpl implements LineApi {

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public LineJwt getLineJwt(String code) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        LineAuthorization lineAuthorization = new LineAuthorization();
        lineAuthorization.setCode(code);
        HttpEntity<String> request = new HttpEntity<>(lineAuthorization.toString(), headers);

        return restTemplate.postForObject(GET_TOKEN_URL, request, LineJwt.class);
    }
}
