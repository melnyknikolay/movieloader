package com.movieloader.controller;

import com.movieloader.omdb.client.api.JobService;
import com.movieloader.omdb.client.api.dto.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by nikmlk on 03.04.17.
 */
@RestController
@RequestMapping(path = "/rest",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieRestController {

    @Autowired
    private JobService jobService;


    @RequestMapping(path = "/public")
    public void publicMessage(Query msg) {
        jobService.start(msg.toString());
    }

}
