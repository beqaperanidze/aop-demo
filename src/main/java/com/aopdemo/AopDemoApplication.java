package com.aopdemo;

import com.aopdemo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AopDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AopDemoApplication.class, args);
        UserService userService = context.getBean(UserService.class);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("Calling getUserById(1):");
        userService.getUserById(1);

        System.out.println("\nCalling getUserById(-1):");
        try {
            userService.getUserById(-1);
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        System.out.println("\nCalling getUserByName(\"Alice\"):");
        userService.getUserByName("Alice");

        System.out.println("\nCalling deleteUser(2):");
        userService.deleteUser(2);
    }
}