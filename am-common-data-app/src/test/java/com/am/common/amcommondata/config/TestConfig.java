package com.am.common.amcommondata.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.am.common.amcommondata")
@EntityScan(basePackages = "com.am.common.amcommondata.domain")
@EnableJpaRepositories(basePackages = "com.am.common.amcommondata.repository")
public class TestConfig {
}
