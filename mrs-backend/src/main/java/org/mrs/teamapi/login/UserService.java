package org.mrs.teamapi.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository repo;

    public UserService(){
    }

    public UserService(UserRepository repo) { this.repo = repo; }

    public User getUser(String username){
        return repo.getUserByUserInfo(username);
    }

    public User saveUser(String username, String password) {
        return repo.saveUser(new User(UUID.randomUUID().toString(), username, password));
    }
}
