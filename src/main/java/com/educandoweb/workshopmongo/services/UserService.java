package com.educandoweb.workshopmongo.services;

import com.educandoweb.workshopmongo.domain.User;
import com.educandoweb.workshopmongo.repository.UserRepository;
import com.educandoweb.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        User user = userRepository.findById(id).orElse(null);

        if(user == null) {
            throw new ObjectNotFoundException("Usuário não encontrado.");
        }

        return user;
    }
}
