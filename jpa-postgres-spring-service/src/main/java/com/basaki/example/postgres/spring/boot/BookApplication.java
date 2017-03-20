package com.basaki.example.postgres.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * {@code BookApplication} represents the entry point for book controller
 * spring boot application.
 * <p/>
 *
 * @author Indra Basak
 * @since 2/23/17
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.basaki.example.postgres.spring.config",
        "com.basaki.example.postgres.spring.controller",
        "com.basaki.example.postgres.spring.data.entity",
        "com.basaki.example.postgres.spring.data.repository",
        "com.basaki.example.postgres.spring.error",
        "com.basaki.example.postgres.spring.model",
        "com.basaki.example.postgres.spring.service"})
@EntityScan(basePackages = "com.basaki.example.postgres.spring.data.entity")
@EnableJpaRepositories(basePackages = {"com.basaki.example.postgres.spring.data.repository"})
public class BookApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }
}
