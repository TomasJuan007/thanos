package com.infinite.thanos.config;

import com.infinite.thanos.batch.IndividualItemProcessor;
import com.infinite.thanos.batch.JobCompletionNotificationListener;
import com.infinite.thanos.model.AbstractIndividual;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.builder.FlowJobBuilder;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.flow.support.SimpleFlow;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

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
        SimpleFlow flow1 = new FlowBuilder<SimpleFlow>("flow1")
                .start(handlers.get(0))
                .build();
        SimpleFlow flow2 = new FlowBuilder<SimpleFlow>("flow2")
                .start(handlers.get(1))
                .build();
        SimpleFlow splitFlow = new FlowBuilder<SimpleFlow>("splitFlow")
                .split(taskExecutor())
                .add(flow1, flow2)
                .build();
        FlowJobBuilder flowJobBuilder = jobBuilder
                .start(splitFlow).build();
        return flowJobBuilder.build();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor("batch-");
    }

}
