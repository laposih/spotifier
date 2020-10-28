package org.laposi.spotifier.spotify.api.dto;

import java.util.List;

public class SearchItem {
    private List<SearchResult> items;

    public List<SearchResult> getItems() {
        return items;
    }

    public void setItems(List<SearchResult> items) {
        this.items = items;
    }
}
