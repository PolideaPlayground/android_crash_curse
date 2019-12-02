package com.wpam.sob.stackoverflow;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StackOverflowSearchResponse {
    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("items")
    private List<Issue> items;

    public StackOverflowSearchResponse() {
    }

    public StackOverflowSearchResponse(boolean hasMore, List<Issue> items) {
        this.hasMore = hasMore;
        this.items = items;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<Issue> getItems() {
        return items;
    }

    public void setItems(List<Issue> items) {
        this.items = items;
    }
}
