package com.example.CodeLibrary.services;

import com.example.CodeLibrary.entitites.ShownNotification;
import com.example.CodeLibrary.repositories.ShownNotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShownNotificationService {

    @Autowired
    private ShownNotificationRepo shownNotificationRepo;

    public ShownNotification saveNewShownNotification(ShownNotification newNotification) {
        return shownNotificationRepo.save(newNotification);
    }

    public List<ShownNotification> getShownNotificationsForUsername(String showntousername) {
        return shownNotificationRepo.findByShownToUsername(showntousername);
    }
}
