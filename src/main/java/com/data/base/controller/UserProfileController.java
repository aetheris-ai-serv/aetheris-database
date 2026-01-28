package com.data.base.controller;

import org.springframework.web.bind.annotation.*;
import com.data.base.model.UserProfile;
import com.data.base.service.UserProfileService;

@RestController
@RequestMapping("/api/profile")
@CrossOrigin
public class UserProfileController {

    private final UserProfileService service;

    public UserProfileController(UserProfileService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public UserProfile save(@RequestBody UserProfile profile) {
        return service.saveProfile(profile);
    }

    @GetMapping("/user/{userId}")
    public UserProfile getByUserId(@PathVariable String userId) {
        return service.getByUserId(userId);
    }
}
