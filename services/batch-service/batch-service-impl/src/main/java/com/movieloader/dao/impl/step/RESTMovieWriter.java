package com.movieloader.dao.impl.step;


import com.movieloader.dao.api.entities.Movie;
import com.movieloader.dao.impl.repositories.MovieRepository;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by nikmlk on 03.04.17.
 */
public class RESTMovieWriter implements ItemWriter<Movie> {

    private MovieRepository repository;

    public RESTMovieWriter(MovieRepository repository) {
        this.repository = repository;
    }

    public void write(List<? extends Movie> list) throws Exception {
        list.forEach(repository::save);
    }
}
