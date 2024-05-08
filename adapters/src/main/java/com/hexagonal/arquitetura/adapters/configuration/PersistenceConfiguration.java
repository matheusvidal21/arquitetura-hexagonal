package com.hexagonal.arquitetura.adapters.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource(
        value = { "classpath:persistence-${PERSISTENCE_PROFILE:datasource}.properties",
                "classpath:/persistence-application.properties", "classpath:/application.properties" },
        ignoreResourceNotFound = true)
@ComponentScan("com.hexagonal.arquitetura.adapters")
@EntityScan("com.hexagonal.arquitetura.adapters.entities")
@EnableJpaRepositories(basePackages = { "com.hexagonal.arquitetura.adapters.repositories" })
@EnableTransactionManagement
@EnableJpaAuditing
public class PersistenceConfiguration {
}
