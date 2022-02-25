package com.example.CodeLibrary.services;

import com.example.CodeLibrary.entitites.Notification;
import com.example.CodeLibrary.repositories.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepo notificationRepo;

    public Notification saveNewNotification(Notification newNotification) {
        return notificationRepo.save(newNotification);
    }

    public List<Notification> getNotificationsForAuthor(String author) {
        return notificationRepo.findNotificationsByAuthor(author);
    }
}
