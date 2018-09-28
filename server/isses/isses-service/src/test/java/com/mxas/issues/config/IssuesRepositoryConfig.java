package com.mxas.issues.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.mxas.issues.business.repository")
@SpringBootApplication
public class IssuesRepositoryConfig {
}
