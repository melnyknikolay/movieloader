package com.movieloader.dao.impl.service;

import com.movieloader.omdb.client.api.JobService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nikmlk on 05.04.17.
 */

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private JobRegistry jobRegistry;

    @Override
    public void start(String params) {
        try {
            Job job = jobRegistry.getJob("OMDBJob");
            jobLauncher.run(job, new JobParametersBuilder().addString("url", params).toJobParameters());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
