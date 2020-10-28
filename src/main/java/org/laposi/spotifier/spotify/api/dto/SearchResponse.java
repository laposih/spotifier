package org.laposi.spotifier.spotify.api.dto;

import java.util.List;

public class SearchResponse {
    private SearchItem artists;

    public SearchItem getArtists() {
        return artists;
    }

    public void setArtists(SearchItem artists) {
        this.artists = artists;
    }
}
