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
public class AnnieConfig {

    @Bean("annieDataSource")
    @ConfigurationProperties("datasources.annie")
    public DataSource annieDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("annieJdbcTemplate")
    public JdbcTemplate annieJdbcTemplate(@Qualifier("annieDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("annieNamedParamJdbcTemplate")
    public NamedParameterJdbcTemplate annieNamedParamJdbcTemplate(@Qualifier("annieDataSource") DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
