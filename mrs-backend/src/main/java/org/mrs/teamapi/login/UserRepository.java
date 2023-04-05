package org.mrs.teamapi.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    UserDbRepository repo;

    public UserRepository() {
    }

    public UserRepository(UserDbRepository repo) {
        this.repo = repo;
    }

    public User getUserByUserInfo(String username) {
        return repo.findUserByUsername(username);
    }

    public User saveUser(User user) { return repo.save(user); }
}
