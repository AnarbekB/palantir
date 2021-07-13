package ru.balmukanov.palantir.framework;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("ru.balmukanov.palantir")
@EntityScan("ru.balmukanov.palantir")
public class PersistenceConfig {
}
