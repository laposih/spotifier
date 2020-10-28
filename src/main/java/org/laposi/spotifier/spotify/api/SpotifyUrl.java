package org.laposi.spotifier.spotify.api;

public enum SpotifyUrl {
    POST_ACCESS_TOKEN("https://accounts.spotify.com/api/token"),
    GET_ARTIST_TOP_TRACKS("https://api.spotify.com/v1/artists/{artist}/top-tracks"),
    SEARCH("https://api.spotify.com/v1/search");

    private String url;

    private SpotifyUrl(String value) {
        url = value;
    }

    public String url() {
        return url;
    }
}
