package com.subra.batchmysql;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;


/**
 * Created by sdass on 12/20/2019.
 */
@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public FlatFileItemReader<BetsPromo> reader(){
        return new FlatFileItemReaderBuilder<BetsPromo>()
                .name("promoItemReader")
                .resource(new ClassPathResource("sample-data.csv"))
                .delimited()
                .names(new String[]{"email", "firstName", "lastName", "betsId", "state", "promoId" })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<BetsPromo>(){

                    {setTargetType(BetsPromo.class);}

                }).build();
    }

    @Bean
    BetsPromoItemProcessor processor(){
        return new BetsPromoItemProcessor();
    }

    //https://spring.io/guides/gs/batch-processing/
    @Bean
    public JdbcBatchItemWriter<BetsPromo> writer(DataSource dataSource){
    //public JpaItemWriter<BetsPromo>
        return new JdbcBatchItemWriterBuilder<BetsPromo>()
                 .itemSqlParameterSourceProvider( new BeanPropertyItemSqlParameterSourceProvider<>())
                 .sql("insert into bets_promo (email, first_name, last_name, bets_id, state, promo_id, signup_date)" +
                         " values (:email, :firstName, :lastName, :betsId, :state, :promoId, :signupDate)") //signupDate
                 .dataSource(dataSource)
                 .build();

                 //insert into bets_promo (email, first_name, last_name, bets_id, state, promo_id) values('mc@yahoo.com', 'Jhon', 'Dolan', 5, 'NY', 44);
    }

    @Bean
    public Job importBetsPromoJob(JobCompletionNotificationListener listener, Step step1){
        return jobBuilderFactory.get("importBetsPromoJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<BetsPromo> writer){
        return stepBuilderFactory.get("step1")
                .<BetsPromo, BetsPromo> chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }


} //class ends
