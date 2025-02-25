package com.aopdemo.service;

import com.aopdemo.annotation.Loggable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Loggable
    public void getUserById(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("ID cannot be negative");
        }
        System.out.println( "User: " + id);
    }

    public void getUserByName(String name) {
        System.out.println("User: " + name);
    }

    @Loggable
    public void deleteUser(int id) {
        System.out.println("Deleting user with ID: " + id);
    }
}