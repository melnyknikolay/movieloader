package com.movieloader.omdb.client.service;

import com.movieloader.omdb.client.api.OmdbClient;
import com.movieloader.omdb.client.api.dto.MovieDTO;
import com.movieloader.omdb.client.api.dto.OMDBEntityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by nikmlk on 05.04.17.
 */

@Component
public class OmdbClientImpl implements OmdbClient {

    @Autowired
    private RestTemplate restTemplate;

    private String query;
    private int nextMovieIndex;
    private List<MovieDTO> movieDTOData;

    @Override
    public OMDBEntityDTO loadInfo(String query) {
        this.query = query;
        if (movieDataIsNotInitialized()) {
            movieDTOData = fetchMoviesDataFromAPI();
        }

        MovieDTO nextMovieDTO = null;

        if (nextMovieIndex < movieDTOData.size()) {
            nextMovieDTO = movieDTOData.get(nextMovieIndex);
            nextMovieIndex++;
        }

        return nextMovieDTO;
    }

    private boolean movieDataIsNotInitialized() {
        return this.movieDTOData == null;
    }

    private List<MovieDTO> fetchMoviesDataFromAPI() {
        ResponseEntity<MovieDTO[]> response = restTemplate.getForEntity(
                query,
                MovieDTO[].class
        );
        MovieDTO[] movieDTOs = response.getBody();
        return Arrays.asList(movieDTOs);
    }
}
