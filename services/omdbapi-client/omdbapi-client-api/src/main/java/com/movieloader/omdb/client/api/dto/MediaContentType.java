package com.movieloader.omdb.client.api.dto;

/**
 * Created by nikmlk on 05.04.17.
 */
public enum MediaContentType {
    Movie, Serial;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
