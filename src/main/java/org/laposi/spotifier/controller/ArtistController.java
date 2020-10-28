package org.laposi.spotifier.controller;

import org.laposi.spotifier.controller.dto.Artist;
import org.laposi.spotifier.service.ArtistService;
import org.laposi.spotifier.spotify.api.dto.SearchItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ArtistController {
    private ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @PostMapping("/artist/search")
    public ResponseEntity<SearchItem> searchArtist(@RequestBody() Artist artist) {
        return ResponseEntity.ok(artistService.searchArtist(artist));
    }
}
