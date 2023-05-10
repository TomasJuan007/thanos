package com.infinite.thanos.config;

import com.infinite.thanos.batch.IndividualItemProcessor;
import com.infinite.thanos.batch.JobCompletionNotificationListener;
import com.infinite.thanos.model.AbstractIndividual;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.builder.SimpleJobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Bean
    public <T extends AbstractIndividual> IndividualItemProcessor<T> processor() {
        return new IndividualItemProcessor<>();
    }

    @Bean
    public Job importJob(JobCompletionNotificationListener listener, List<Step> handlers) {

        JobBuilder jobBuilder = jobBuilderFactory.get("importJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener);
        SimpleJobBuilder simpleJobBuilder = jobBuilder
                .start(handlers.get(0))
                .next(handlers.get(1));
        return simpleJobBuilder.build();
    }

}
