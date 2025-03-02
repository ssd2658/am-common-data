package com.am.common.amcommondata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AmCommonDataApplication {
    public static void main(String[] args) {
        SpringApplication.run(AmCommonDataApplication.class, args);
    }
}
