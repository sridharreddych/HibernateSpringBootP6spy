package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            
            bookstoreService.persistAuthor();
            bookstoreService.displayAuthor();
        };
    }
}

/*
 * 
 * How To Set Up P6Spy in Spring Boot

Description: This is a Spring Boot application that uses P6Spy. P6Spy is a framework that enables database data to be seamlessly intercepted and logged with no code changes to the application.

Key points:

in pom.xml, add the P6Spy Maven dependency
in application.properties, set up JDBC URL as, jdbc:p6spy:mysql://localhost:3306/db_users
in application.properties, set up driver class name as, com.p6spy.engine.spy.P6SpyDriver
in the application root folder add the file spy.properties (this file contains P6Spy configurations); in this application, the logs will be outputed to console, but you can easy switch to a file; more details about P6Spy configurations can be found in documentation
 * 
 * 
 */
