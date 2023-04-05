package org.mrs.teamapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = {
        "org.mrs.teamapi.employee", "org.mrs.teamapi.team", "org.mrs.teamapi.login"
})
public class TeamAPI {
    private static final Logger log = LoggerFactory.getLogger(TeamAPI.class);
    public static void main(String[] args) {
        SpringApplication.run(TeamAPI.class, args);
    }
}
