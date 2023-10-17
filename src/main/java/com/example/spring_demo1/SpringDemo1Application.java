package com.example.spring_demo1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:query.properties")
@SpringBootApplication
public class SpringDemo1Application {

    public static void main(String[] args) {

        SpringApplication.run(SpringDemo1Application.class, args);

    }

}
