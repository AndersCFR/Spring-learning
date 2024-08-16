package com.anders.spring_rest.config;
import net.datafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakerBeanConfig {

    @Bean
    public Faker getFaker(){
        return new Faker();
    }
}