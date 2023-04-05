package org.mrs.teamapi.team;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamDbRepository extends MongoRepository<Team, String> {
    Team findTeamByName(String name);
}
