package com.educandoweb.workshopmongo.config;

import com.educandoweb.workshopmongo.domain.Post;
import com.educandoweb.workshopmongo.domain.User;
import com.educandoweb.workshopmongo.repository.PostRepository;
import com.educandoweb.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class Instantiate implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        User user1 = new User(null, "John Doe", "john@email.com");
        User user2 = new User(null, "Jane Brown", "jane@email.com");
        User user3 = new User(null, "Maria Grey", "maria@email.com");

        Post post1 = new Post(null, "Partiu viagem!", "Vou viajar para São Paulo. Abraços!", LocalDate.parse( "21/03/2018", fmt), user3);
        Post post2 = new Post(null, "Bom dia", "Acordei feliz hoje!", LocalDate.parse( "23/03/2018", fmt), user3);

        userRepository.saveAll(Arrays.asList(user1, user2, user3));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
