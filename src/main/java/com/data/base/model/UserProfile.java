package com.data.base.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_profiles")
public class UserProfile {

    @Id
    private String id;

    private String userId;

    private int speed;
    private int averageSpeed;
    private int traffic;
    private String quality;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(int averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public int getTraffic() {
        return traffic;
    }

    public void setTraffic(int traffic) {
        if (traffic < 0 || traffic > 10) {
            throw new IllegalArgumentException("Traffic must be between 1 and 10");
        }
        this.traffic = traffic;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}
