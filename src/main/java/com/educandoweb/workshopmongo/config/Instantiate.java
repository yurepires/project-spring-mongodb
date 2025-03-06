package com.educandoweb.workshopmongo.config;

import com.educandoweb.workshopmongo.domain.User;
import com.educandoweb.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiate implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User user1 = new User(null, "John Doe", "john@email.com");
        User user2 = new User(null, "Jane Brown", "jane@email.com");
        User user3 = new User(null, "Maria Grey", "maria@email.com");

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
    }
}
