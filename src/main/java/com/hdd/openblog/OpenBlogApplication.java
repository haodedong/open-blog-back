package com.hdd.openblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.hdd.openblog.dao")
public class OpenBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenBlogApplication.class, args);
    }

}
