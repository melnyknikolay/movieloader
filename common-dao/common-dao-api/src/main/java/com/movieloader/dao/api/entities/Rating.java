package com.movieloader.dao.api.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by nikmlk on 03.04.17.
 */

@Entity
@Table(name = "rating")
public class Rating implements Serializable {
    private static final long serialVersionUID = -7821581381469250614L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "source")
    private String source;

    @Column(name = "value")
    private String value;

    @ManyToOne(fetch = FetchType.EAGER)
    private Movie movie;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating = (Rating) o;

        if (!id.equals(rating.id)) return false;
        if (!source.equals(rating.source)) return false;
        if (!value.equals(rating.value)) return false;
        return movie.equals(rating.movie);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + source.hashCode();
        result = 31 * result + value.hashCode();
        result = 31 * result + movie.hashCode();
        return result;
    }
}
