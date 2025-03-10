package com.educandoweb.workshopmongo.services;

import com.educandoweb.workshopmongo.domain.Post;
import com.educandoweb.workshopmongo.repository.PostRepository;
import com.educandoweb.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            throw new ObjectNotFoundException("Post não encontrado");
        }
        return post;
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitle(text);
    }

    public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate) {
        maxDate.plusDays(1);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
