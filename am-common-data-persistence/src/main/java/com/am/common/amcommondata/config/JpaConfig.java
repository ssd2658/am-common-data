package com.am.common.amcommondata.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.am.common.amcommondata.domain")
@EnableJpaRepositories(basePackages = "com.am.common.amcommondata.repository")
public class JpaConfig {
}
