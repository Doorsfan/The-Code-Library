package com.example.CodeLibrary.controllers;

import com.example.CodeLibrary.entitites.Notification;
import com.example.CodeLibrary.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Använd @RestController istället för @Controller
// @RestController Spring Boot specifikt, tillåter oss använda @RequestBody för att
// automatiskt konvertera JSON till Java objekt. Med vanlig @Controller är det flera extra steg.
@RestController
@RequestMapping(value = "/rest", method = RequestMethod.POST)
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/notification/addNewNotification")
    public Notification createNewNotification(@RequestBody Notification newNotification) {
        return notificationService.saveNewNotification(newNotification);
    }

    @GetMapping("/notification/notificationsFrom/{authorname}")
    public List<Notification> getNotifications(@PathVariable String authorname) {
        return notificationService.getNotificationsForAuthor(authorname);
    }
}
