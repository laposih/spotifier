package org.laposi.spotifier.service;

import org.laposi.spotifier.spotify.api.SpotifyUrl;
import org.laposi.spotifier.spotify.api.dto.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class AuthorizationService {

    @Value("${client.id}")
    private String clientId;

    @Value("${client.secret}")
    private String clientSecret;

    private RestTemplate restTemplate;

    @Autowired
    public AuthorizationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getAccessToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        String credentials = clientId + ":" + clientSecret;
        String value = "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());
        headers.add("Authorization", value);
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.put("grant_type", Arrays.asList("client_credentials"));
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

        ResponseEntity<AccessTokenResponse> response = restTemplate.
                postForEntity(SpotifyUrl.POST_ACCESS_TOKEN.url(), request, AccessTokenResponse.class);
        return response.getBody().getAccessToken();
    }
}

