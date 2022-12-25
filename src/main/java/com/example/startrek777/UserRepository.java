package com.example.startrek777;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    protected Map<String, User> users = new HashMap<>();

    public boolean isExists(String name) {
        return users.containsKey(name);
    }
    public void save(User user) {
        users.put(user.getName(), user);
    }

    public User fetchByUsername(String username) {
        return users.get(username);
    }

    public UserRepository(Map<String, User> users) {
        this.users = users;
    }
}
