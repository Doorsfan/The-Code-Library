package com.example.CodeLibrary.controllers;

import com.example.CodeLibrary.entitites.Follower;
import com.example.CodeLibrary.services.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest", method = RequestMethod.POST)
// Sätter denna strängen att komma automatiskt efter localhost:4000{minSträng}
public class FollowersController {

    @Autowired
    FollowerService followerService;

    @PostMapping("/followers/addNewFollower")
    public Follower addNewfollow(@RequestBody Follower newFollower) {
        return followerService.addFollower(newFollower);
    }

    @GetMapping("/followers/getFollowersOf/{targetusername}")
    public List<Follower> getFollowers(@PathVariable String targetusername) {
        return followerService.getFollowersForUser(targetusername);
    }
}
