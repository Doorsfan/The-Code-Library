package com.example.CodeLibrary.services;

import com.example.CodeLibrary.entitites.Activity;
import com.example.CodeLibrary.repositories.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepo activityRepo;

    public List<Activity> findActivityByUsername(String username) {
        return activityRepo.findByUsername(username);
    }

    public Activity saveNewActivityToDb(Activity activity) {
        return activityRepo.save(activity);
    }
}
