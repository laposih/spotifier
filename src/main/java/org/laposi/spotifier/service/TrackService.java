package org.laposi.spotifier.service;

import org.laposi.spotifier.service.dto.TopTracks;
import org.laposi.spotifier.spotify.api.SpotifyUrl;
import org.laposi.spotifier.spotify.api.dto.TopTracksResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackService {
    private final RestTemplate restTemplate;
    private AuthorizationService authorizationService;

    @Autowired
    public TrackService(RestTemplate restTemplate, AuthorizationService authorizationService) {
        this.restTemplate = restTemplate;
        this.authorizationService = authorizationService;
    }

    public TopTracks getTopTracks(String artist, String country) {
        String accessToken = authorizationService.getAccessToken();
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization", "Bearer " + accessToken);
        HttpEntity<Object> request = new HttpEntity<>(null, header);
        UriComponents uri = UriComponentsBuilder.fromHttpUrl(SpotifyUrl.GET_ARTIST_TOP_TRACKS.url())
                .queryParam("country", country)
                .buildAndExpand(artist);
        ResponseEntity<TopTracksResponse> response = restTemplate.exchange(
                uri.toUriString(),
                HttpMethod.GET,
                request,
                TopTracksResponse.class
        );
        TopTracks topTracks = new TopTracks();
        List<String> trackList = new ArrayList<>();
        for (int i = 0; i < response.getBody().getTracks().size(); i++) {
            trackList.add(response.getBody().getTracks().get(i).getName());
        }
        topTracks.setTracks(trackList);
        return topTracks;
    }

}
