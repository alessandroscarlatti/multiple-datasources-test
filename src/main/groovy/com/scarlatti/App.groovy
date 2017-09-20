package com.scarlatti

import groovy.util.logging.Slf4j

/**
 * Created by pc on 9/8/2017.
 */
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@SpringBootApplication
@Configuration
@Slf4j
@ConfigurationProperties
class App implements CommandLineRunner {

    static void main(String[] args) {
        SpringApplication.run(App.class, args)
    }

    @Override
    void run(String... args) throws Exception {

    }
}