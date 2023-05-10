package com.infinite.thanos.config;

import com.infinite.thanos.model.Human;
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
public class BatchHumanConfiguration extends BatchConfiguration {

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<Human> readeHuman() {
        return new FlatFileItemReaderBuilder<Human>()
                .name("humanItemReader")
                .resource(new ClassPathResource("sample-data-human.csv"))
                .delimited()
                .names(new String[]{"firstName", "lastName"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Human>() {{
                    setTargetType(Human.class);
                }})
                .build();
    }


    @Bean
    public JdbcBatchItemWriter<Human> writeHuman(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Human>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO human (identifier, first_name, last_name) VALUES (:identifier, :firstName, :lastName)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Step handleHuman(JdbcBatchItemWriter<Human> writer) {
        return stepBuilderFactory.get("handleHuman")
                .<Human, Human>chunk(10)
                .reader(readeHuman())
                .processor(processor())
                .writer(writer)
                .build();
    }

}
