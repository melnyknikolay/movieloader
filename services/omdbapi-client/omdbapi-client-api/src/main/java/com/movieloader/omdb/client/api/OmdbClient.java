package com.movieloader.omdb.client.api;

import com.movieloader.omdb.client.api.dto.OMDBEntityDTO;

/**
 * Created by nikmlk on 05.04.17.
 */
public interface OmdbClient {
        OMDBEntityDTO loadInfo(String query);
}
