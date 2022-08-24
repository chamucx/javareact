package com.example.reactdemoapp;

import com.example.reactdemoapp.security.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ReactDemoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactDemoAppApplication.class, args);
        System.out.println("Funciona el semejante HPD Careverga?");
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringApplicationContext springApplicationContext() {
        return new SpringApplicationContext();
    }

    @Bean(name = "AppProperties")
    public AppProperties getAppProperties() {
        return new AppProperties();
    }

}
