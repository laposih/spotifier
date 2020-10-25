package org.laposi.spotifier.controller;

import org.laposi.spotifier.service.TrackService;
import org.laposi.spotifier.service.dto.TopTracks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrackController {
    private TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping("/tracks/top")
    public ResponseEntity<TopTracks> getTopTracks(@RequestParam(name="artist") String artist, @RequestParam(name="country") String country) {
        return ResponseEntity.ok(trackService.getTopTracks(artist, country));
    }
}
