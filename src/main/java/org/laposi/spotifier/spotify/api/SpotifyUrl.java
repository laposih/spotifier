package org.laposi.spotifier.spotify.api;

public enum SpotifyUrl {
    POST_ACCESS_TOKEN("https://accounts.spotify.com/api/token");

    private String url;

    private SpotifyUrl(String value) {
        url = value;
    }

    public String url() {
        return url;
    }
}
