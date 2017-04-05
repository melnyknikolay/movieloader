package com.movieloader.dao.impl.configuration;


import com.movieloader.dao.api.entities.Movie;
import com.movieloader.dao.impl.repositories.MovieRepository;
import com.movieloader.dao.impl.step.RESTMovieProcessor;
import com.movieloader.dao.impl.step.RESTMovieReader;
import com.movieloader.dao.impl.step.RESTMovieWriter;
import com.movieloader.omdb.client.api.dto.MovieDTO;
import com.movieloader.omdb.client.configuration.OmdbClientCfg;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.configuration.support.MapJobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.dao.MapExecutionContextDao;
import org.springframework.batch.core.repository.dao.MapJobExecutionDao;
import org.springframework.batch.core.repository.dao.MapJobInstanceDao;
import org.springframework.batch.core.repository.dao.MapStepExecutionDao;
import org.springframework.batch.core.repository.support.SimpleJobRepository;
import org.springframework.batch.core.scope.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by nikmlk on 03.04.17.
 */
@Configuration
@EnableBatchProcessing
@Import({JpaConfig.class, OmdbClientCfg.class})
public class BatchConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private MovieRepository repository;

    @Bean
    public Step loadMowieInfoStep() {
        return stepBuilderFactory.get("OMDBDataLoadStep")
                .<MovieDTO, Movie>chunk(10)
                .reader(restMovieReader())
                .processor(restMovieProcessor())
                .writer(restMovieWriter())
                .build();
    }

    @Bean
    public Job loadMovieInfoJob() throws Exception {
        return jobBuilderFactory.get("OMDBJob")
                .incrementer(new RunIdIncrementer())
                .start(loadMowieInfoStep())
                .build();
    }

    @Bean
    private ItemReader<MovieDTO> restMovieReader() {
        return new RESTMovieReader();
    }

    @Bean
    private ItemProcessor<MovieDTO, Movie> restMovieProcessor() {
        return new RESTMovieProcessor();
    }

    @Bean
    private ItemWriter<Movie> restMovieWriter() {
        return new RESTMovieWriter(repository);
    }

    @Bean
    public static StepScope scope() {
        return new StepScope();
    }

    @Bean
    public JobRepository jobRepository() {
        return
                new SimpleJobRepository(
                        new MapJobInstanceDao(),
                        new MapJobExecutionDao(),
                        new MapStepExecutionDao(),
                        new MapExecutionContextDao()
                );
    }

    @Bean
    public JobLauncher jobLauncher() {
        SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher();
        simpleJobLauncher.setJobRepository(jobRepository());

        return simpleJobLauncher;
    }

    @Bean
    public JobRegistry jobRegistry() {
        return new MapJobRegistry();
    }

    @Bean
    public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor() {
        JobRegistryBeanPostProcessor bpp = new JobRegistryBeanPostProcessor();
        bpp.setJobRegistry(jobRegistry());
        return bpp;
    }
}
