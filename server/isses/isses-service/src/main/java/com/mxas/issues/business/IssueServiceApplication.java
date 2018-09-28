package com.mxas.issues.bussines;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.mxas.issues.bussines.repository", "com.mxas.issues.bussines.services.impl"})
@EnableAutoConfiguration
public class IssueServiceApplication {

}
