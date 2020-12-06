package com.sportsprofile.sports_profile_core.entity;

import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsProfileFlywaySetup {
//    @ConditionalOnProperty(name = "flyway.enabled", matchIfMissing = true)
    @Bean
    public Flyway flyway(DataSource dataSource) {
        return Flyway.configure()
                .dataSource(dataSource)
                .outOfOrder(true)
                .locations("classpath:db/migration")
                .baselineOnMigrate(true)
                .baselineVersion("0")
                .schemas(EntitySchema.NAME)
                .load();
    }
}
