package com.example.CodeLibrary.services;

import com.example.CodeLibrary.entitites.Activity;
import com.example.CodeLibrary.repositories.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This service class handles the logic of writing and reading from the database.
 * The Repo is only used for direct queries to the Database.
 * Built-in methods through 'extends CrudRepository'
 * The Controller classes handles receiving requests from the frontend.
 */
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
