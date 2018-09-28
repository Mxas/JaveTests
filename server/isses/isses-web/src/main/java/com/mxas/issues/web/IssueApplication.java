package com.mxas.issues.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.mxas.issues")
public class IssueApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{IssueApplication.class}, args);
    }
}
