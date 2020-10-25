package org.laposi.spotifier.spotify.api.dto;

import java.util.List;

public class TopTracksResponse {
    private List<Track> tracks;

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
