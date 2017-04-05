package com.movieloader.omdb.client.api.dto;

import java.io.Serializable;

/**
 * Created by nikmlk on 03.04.17.
 */
public class Query implements Serializable{
    private static final long serialVersionUID = -5501323226145794210L;

    private String query;
    private int year;
    private MediaContentType type;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public MediaContentType getType() {
        return type;
    }

    public void setType(MediaContentType type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public String toString() {
        return "http://www.omdbapi.com/?" + "s=" + query + "&y=" + year + "&plot=short&r=json" + "&type=" + type;
    }
}
