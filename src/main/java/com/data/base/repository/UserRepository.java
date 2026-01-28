package com.data.base.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.data.base.model.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}

