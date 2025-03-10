package com.educandoweb.workshopmongo.repository;

import com.educandoweb.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{'title':  {$regex: ?0, $options:  'i'}}")
    List<Post> findByTitle(String title);

    List<Post> findByTitleContainingIgnoreCase(String text);

}
