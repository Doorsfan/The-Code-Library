package com.example.CodeLibrary.controllers;

import com.example.CodeLibrary.entitites.Activity;
import com.example.CodeLibrary.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest", method = RequestMethod.POST)
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/activity/findActivityByUsername/{username}")
    public List<Activity> getActivityByUsername(@PathVariable String username) {
        return activityService.findActivityByUsername(username);
    }

    @PostMapping("/activity/saveNewActivity")
    public Activity createNewActivity(@RequestBody Activity activity) {
        return activityService.saveNewActivityToDb(activity);
    }
}
