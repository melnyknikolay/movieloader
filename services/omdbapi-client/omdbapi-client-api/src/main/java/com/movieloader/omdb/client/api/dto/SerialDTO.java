package com.movieloader.omdb.client.api.dto;

/**
 * Created by nikmlk on 05.04.17.
 */
public class SerialDTO extends OMDBEntityDTO {
    private static final long serialVersionUID = 7995933105447259217L;

    private String title;
    private int year;
    private String imdbID;
    private MediaContentType Type;
    private String poster;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public MediaContentType getType() {
        return Type;
    }

    public void setType(MediaContentType type) {
        Type = type;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
