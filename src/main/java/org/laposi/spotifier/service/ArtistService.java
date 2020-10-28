package org.laposi.spotifier.service;

import org.laposi.spotifier.controller.dto.Artist;
import org.laposi.spotifier.spotify.api.SpotifyUrl;
import org.laposi.spotifier.spotify.api.dto.SearchItem;
import org.laposi.spotifier.spotify.api.dto.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ArtistService {
    private final RestTemplate restTemplate;
    private AuthorizationService authorizationService;

    @Autowired
    public ArtistService(RestTemplate restTemplate, AuthorizationService authorizationService) {
        this.restTemplate = restTemplate;
        this.authorizationService = authorizationService;
    }

    public SearchItem searchArtist(Artist artist) {
        HttpEntity<Object> request = new HttpEntity<>(null, authorizationService.createAuthorizationHeader());
        UriComponentsBuilder uri = UriComponentsBuilder.fromHttpUrl(SpotifyUrl.SEARCH.url())
                .queryParam("q", artist.getArtist())
                .queryParam("type", "artist");
        ResponseEntity<SearchResponse> response = restTemplate.exchange(
                uri.toUriString(),
                HttpMethod.GET,
                request,
                SearchResponse.class
        );
        return response.getBody().getArtists();
    }
}
