package com.mxas.issues.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class IssueServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{IssueServiceApplication.class, com.mxas.issues.IssueServiceApplication.class}, args);
    }
}