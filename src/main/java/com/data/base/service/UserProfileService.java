package com.data.base.service;

import org.springframework.stereotype.Service;
import com.data.base.model.UserProfile;
import com.data.base.repository.UserProfileRepository;

@Service
public class UserProfileService {

    private final UserProfileRepository repo;

    public UserProfileService(UserProfileRepository repo) {
        this.repo = repo;
    }

    public UserProfile saveProfile(UserProfile profile) {
        return repo.save(profile);
    }

    public UserProfile getByUserId(String userId) {
        return repo.findByUserId(userId).orElse(null);
    }
}
