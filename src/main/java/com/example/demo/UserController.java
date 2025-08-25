// src/main/java/com/example/demo/UserController.java
package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping("/users")
public class UserController {

    private final String directoryPath = "/nsv";

    @PostMapping
    public String addUser (@RequestBody User user) {
        try {
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdir();
            }
            File file = new File(directory, user.getName() + ".txt");
            FileWriter writer = new FileWriter(file);
            writer.write("Name: " + user.getName() + "\n");
            writer.write("Age: " + user.getAge() + "\n");
            writer.write("Description: " + user.getDescription() + "\n");
            writer.close();
            return "User  data saved successfully!";
        } catch (IOException e) {
            return "Error saving user data: " + e.getMessage();
        }
    }
}
