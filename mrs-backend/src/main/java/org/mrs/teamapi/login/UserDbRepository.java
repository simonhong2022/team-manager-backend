package org.mrs.teamapi.login;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDbRepository extends MongoRepository<User, String> {
    User findUserByUsername(String username);
}
