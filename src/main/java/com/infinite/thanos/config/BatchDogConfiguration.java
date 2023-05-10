package com.infinite.thanos.config;

import com.infinite.thanos.model.Dog;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchDogConfiguration extends BatchConfiguration {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<Dog> readeDog() {
        return new FlatFileItemReaderBuilder<Dog>()
                .name("dogItemReader")
                .resource(new ClassPathResource("sample-data-dog.csv"))
                .delimited()
                .names(new String[]{"nickname"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Dog>() {{
                    setTargetType(Dog.class);
                }})
                .build();
    }


    @Bean
    public JdbcBatchItemWriter<Dog> writeDog(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Dog>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO dog (identifier, nickname) VALUES (:identifier, :nickname)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Step handleDog(JdbcBatchItemWriter<Dog> writer) {
        return stepBuilderFactory.get("handleDog")
                .<Dog, Dog>chunk(10)
                .reader(readeDog())
                .processor(processor())
                .writer(writer)
                .build();
    }

}
