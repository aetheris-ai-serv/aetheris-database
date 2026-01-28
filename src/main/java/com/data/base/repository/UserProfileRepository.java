package com.data.base.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.data.base.model.UserProfile;

import java.util.Optional;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
    Optional<UserProfile> findByUserId(String userId);
}
