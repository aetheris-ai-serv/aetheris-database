package com.data.base.service;

import org.springframework.stereotype.Service;
import com.data.base.model.User;
import com.data.base.model.UserProfile;
import com.data.base.repository.UserRepository;
import com.data.base.repository.UserProfileRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserProfileRepository userProfileRepository;

    public UserService(UserRepository userRepository, 
                      UserProfileRepository userProfileRepository) {
        this.userRepository = userRepository;
        this.userProfileRepository = userProfileRepository;
    }

    // Create user (password already hashed by FastAPI)
    public User createUser(User user) {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already registered");
        }
        return userRepository.save(user);
    }

    // Get user by ID
    public User getUserById(String id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // Get user by email (for login verification)
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    // Create user profile
    public UserProfile createUserProfile(UserProfile profile) {
        userRepository.findById(profile.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found with id: " + profile.getUserId()));
        
        return userProfileRepository.save(profile);
    }

    // Update user profile
    public UserProfile updateUserProfile(String userId, UserProfile updatedProfile) {
        UserProfile existingProfile = userProfileRepository.findByUserId(userId)
            .orElseThrow(() -> new RuntimeException("Profile not found for user: " + userId));
        
        existingProfile.setSpeed(updatedProfile.getSpeed());
        existingProfile.setAverageSpeed(updatedProfile.getAverageSpeed());
        existingProfile.setTraffic(updatedProfile.getTraffic());
        existingProfile.setQuality(updatedProfile.getQuality());
        
        return userProfileRepository.save(existingProfile);
    }

    // Get user profile by userId
    public UserProfile getUserProfile(String userId) {
        return userProfileRepository.findByUserId(userId)
            .orElseThrow(() -> new RuntimeException("Profile not found for user: " + userId));
    }

    // Update user location
    public User updateUserLocation(String userId, Double latitude, Double longitude) {
        User user = getUserById(userId);
        user.setLatitude(latitude);
        user.setLongitude(longitude);
        return userRepository.save(user);
    }
}
