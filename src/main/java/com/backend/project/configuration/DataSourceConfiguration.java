package com.backend.project.configuration;

import javax.activation.DataSource;

import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.backend.project.utils.AppConstants;


@Configuration
public class DataSourceConfiguration {

    @Primary
    public DataSource getDataSource(){
        return (DataSource) DataSourceBuilder.create().build();
    }

}
