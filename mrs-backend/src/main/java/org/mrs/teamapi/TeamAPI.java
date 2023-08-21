package org.mrs.teamapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TeamAPI {
    private static final Logger log = LoggerFactory.getLogger(TeamAPI.class);
    public static void main(String[] args) {
        SpringApplication.run(TeamAPI.class, args);
    }
}
