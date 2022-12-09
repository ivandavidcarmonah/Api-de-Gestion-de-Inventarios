package com.backend.project.configuration;

import javax.activation.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;



@Configuration
public class DataSourceConfiguration {

    @Primary
    public DataSource getDataSource(){
        return (DataSource) DataSourceBuilder.create().build();
    }

}
