package com.movieloader.dao.impl.repositories;

import com.movieloader.dao.api.entities.Movie;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by nikmlk on 03.04.17.
 */
public interface MovieRepository extends CrudRepository<Movie, String> {
}
