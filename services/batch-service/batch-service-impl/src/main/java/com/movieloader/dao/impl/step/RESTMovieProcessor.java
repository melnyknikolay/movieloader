package com.movieloader.dao.impl.step;


import com.movieloader.dao.api.entities.Movie;
import com.movieloader.omdb.client.api.dto.MovieDTO;
import org.modelmapper.ModelMapper;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by nikmlk on 03.04.17.
 */
public class RESTMovieProcessor implements ItemProcessor<MovieDTO, Movie> {

    public Movie process(MovieDTO movieDto) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        Movie movie = modelMapper.map(movieDto, Movie.class);
        return movie;
    }
}
