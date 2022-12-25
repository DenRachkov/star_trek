package com.example.startrek777;

import com.oracle.wls.shaded.org.apache.bcel.Repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserRepositoryTest {
    private Map<String, User> list;

    private UserRepository users;

    @BeforeEach
    void setup() {
        list = new HashMap<>();
        User user = new User();
        user.setName("user1");
        list.put("user1", user);


        user = new User();
        user.setName("user2");
        list.put("user2", user);

        this.users = new UserRepository(list);
    }

    @Test
    void test_save_NewUser() {
        User user = new User();
        String newUser = "user3";
        user.setName(newUser);
        users.save(user);

        assertEquals("user3", user.getName());
    }

    @Test
    void test_isExists_IdIsUser() {
        boolean actual = users.isExists("user1");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void test_isExists_IdIsNotUser() {
        boolean actual = users.isExists("user3");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void test_fetchByUsername() {

        assertEquals("user1", users.fetchByUsername("user1").getName());
    }
}