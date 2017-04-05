package com.movieloader.dao.impl.step;

import com.movieloader.omdb.client.api.OmdbClient;
import com.movieloader.omdb.client.api.dto.MovieDTO;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@StepScope
public class RESTMovieReader implements ItemReader<MovieDTO> {

    @Autowired
    @Value("#{jobParameters['url']}")
    private String query;

    @Autowired
    private OmdbClient client;

    public MovieDTO read(){
        return (MovieDTO) client.loadInfo(query);
    }
}
