package com.educandoweb.workshopmongo.resources;

import com.educandoweb.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User user = new User("123", "John", "john@gmail.com");
        User user1 = new User("456", "Jane", "jane@gmail.com");
        User user2 = new User("789", "Jane", "jane@gmail.com");
        List<User> users = Arrays.asList(user, user1, user2);
        return ResponseEntity.ok(users);
    }
}
