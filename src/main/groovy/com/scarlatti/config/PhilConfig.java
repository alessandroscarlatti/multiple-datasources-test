package com.scarlatti.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by pc on 9/19/2017.
 */
@Configuration
public class PhilConfig {

    @Bean(name = "philDataSource")
    @ConfigurationProperties("datasources.phil")
    public DataSource philDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("philJdbcTemplate")
    public JdbcTemplate philJdbcTemplate(@Qualifier("philDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("philNamedParamJdbcTemplate")
    public NamedParameterJdbcTemplate philNamedParamJdbcTemplate(@Qualifier("philDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
