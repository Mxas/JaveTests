package com.mxas.issues.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.mxas.issues.business.services")
@EnableAutoConfiguration
public class IssuesServiceConfig {
}
