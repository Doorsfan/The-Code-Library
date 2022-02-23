package com.example.CodeLibrary.services;

import com.example.CodeLibrary.entitites.Follower;
import com.example.CodeLibrary.repositories.FollowerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowerService {

    @Autowired // Exempelvis för att importera spring klasser som @Service, @Repository etc
    private FollowerRepo followerRepo;

    public Follower addFollower(Follower follower) {
        return followerRepo.save(follower);
    }

    public List<Follower> getFollowersForUser(String targetusername) {
        return followerRepo.findFollowersForUserByUsername(targetusername);
    }
}
