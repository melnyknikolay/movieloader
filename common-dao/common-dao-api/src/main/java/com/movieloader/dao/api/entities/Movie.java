package com.movieloader.dao.api.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by nikmlk on 03.04.17.
 */

@Entity
@Table(name = "movie")
public class Movie implements Serializable {
    private static final long serialVersionUID = -7554882489581860911L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private String year;

    @Column(name = "rated")
    private String rated;

    @Column(name = "released")
    private String released;

    @Column(name = "runtime")
    private String runtime;

    @Column(name = "genre")
    private String genre;

    @Column(name = "director")
    private String director;

    @Column(name = "writer")
    private String writer;

    @Column(name = "actors")
    private String actors;

    @Column(name = "plot")
    private String plot;

    @Column(name = "language")
    private String language;

    @Column(name = "country")
    private String country;

    @Column(name = "awards")
    private String awards;

    @Column(name = "poster")
    private String poster;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "movie")
    private List<Rating> ratings;

    @Column(name = "metascore")
    private String metascore;

    @Column(name = "imdbRating")
    private String imdbRating;

    @Column(name = "imdbVotes")
    private String imdbVotes;

    @Column(name = "imdbID")
    private String imdbID;

    @Column(name = "type")
    private String type;

    @Column(name = "dvd")
    private String dvd;

    @Column(name = "boxOffice")
    private String boxOffice;

    @Column(name = "production")
    private String production;

    @Column(name = "website")
    private String website;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDvd() {
        return dvd;
    }

    public void setDvd(String dvd) {
        this.dvd = dvd;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (!id.equals(movie.id)) return false;
        if (!title.equals(movie.title)) return false;
        if (!year.equals(movie.year)) return false;
        if (rated != null ? !rated.equals(movie.rated) : movie.rated != null) return false;
        if (released != null ? !released.equals(movie.released) : movie.released != null) return false;
        if (runtime != null ? !runtime.equals(movie.runtime) : movie.runtime != null) return false;
        if (genre != null ? !genre.equals(movie.genre) : movie.genre != null) return false;
        if (director != null ? !director.equals(movie.director) : movie.director != null) return false;
        if (writer != null ? !writer.equals(movie.writer) : movie.writer != null) return false;
        if (!actors.equals(movie.actors)) return false;
        if (plot != null ? !plot.equals(movie.plot) : movie.plot != null) return false;
        if (!language.equals(movie.language)) return false;
        if (!country.equals(movie.country)) return false;
        if (awards != null ? !awards.equals(movie.awards) : movie.awards != null) return false;
        if (poster != null ? !poster.equals(movie.poster) : movie.poster != null) return false;
        if (ratings != null ? !ratings.equals(movie.ratings) : movie.ratings != null) return false;
        if (metascore != null ? !metascore.equals(movie.metascore) : movie.metascore != null) return false;
        if (!imdbRating.equals(movie.imdbRating)) return false;
        if (imdbVotes != null ? !imdbVotes.equals(movie.imdbVotes) : movie.imdbVotes != null) return false;
        if (imdbID != null ? !imdbID.equals(movie.imdbID) : movie.imdbID != null) return false;
        if (type != null ? !type.equals(movie.type) : movie.type != null) return false;
        if (dvd != null ? !dvd.equals(movie.dvd) : movie.dvd != null) return false;
        if (boxOffice != null ? !boxOffice.equals(movie.boxOffice) : movie.boxOffice != null) return false;
        if (production != null ? !production.equals(movie.production) : movie.production != null) return false;
        return website != null ? website.equals(movie.website) : movie.website == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + year.hashCode();
        result = 31 * result + (rated != null ? rated.hashCode() : 0);
        result = 31 * result + (released != null ? released.hashCode() : 0);
        result = 31 * result + (runtime != null ? runtime.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (director != null ? director.hashCode() : 0);
        result = 31 * result + (writer != null ? writer.hashCode() : 0);
        result = 31 * result + actors.hashCode();
        result = 31 * result + (plot != null ? plot.hashCode() : 0);
        result = 31 * result + language.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + (awards != null ? awards.hashCode() : 0);
        result = 31 * result + (poster != null ? poster.hashCode() : 0);
        result = 31 * result + (ratings != null ? ratings.hashCode() : 0);
        result = 31 * result + (metascore != null ? metascore.hashCode() : 0);
        result = 31 * result + imdbRating.hashCode();
        result = 31 * result + (imdbVotes != null ? imdbVotes.hashCode() : 0);
        result = 31 * result + (imdbID != null ? imdbID.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (dvd != null ? dvd.hashCode() : 0);
        result = 31 * result + (boxOffice != null ? boxOffice.hashCode() : 0);
        result = 31 * result + (production != null ? production.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        return result;
    }
}
