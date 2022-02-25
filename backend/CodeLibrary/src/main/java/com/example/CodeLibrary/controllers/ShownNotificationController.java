package com.example.CodeLibrary.controllers;

import com.example.CodeLibrary.entitites.ShownNotification;
import com.example.CodeLibrary.services.ShownNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Använd @RestController istället för @Controller
// @RestController Spring Boot specifikt, tillåter oss använda @RequestBody för att
// automatiskt konvertera JSON till Java objekt. Med vanlig @Controller är det flera extra steg.
@RestController
@RequestMapping(value = "/rest", method = RequestMethod.POST)
public class ShownNotificationController {

    @Autowired
    private ShownNotificationService shownNotificationService;

    @PostMapping("/shownnotification/addNewShownNotification")
    public ShownNotification createNewNotification(@RequestBody ShownNotification newNotification) {
        return shownNotificationService.saveNewShownNotification(newNotification);
    }

    @GetMapping("/shownnotification/getNotificationsFor/{showntousername}")
    public List<ShownNotification> getShownNotifications(@PathVariable String showntousername) {
        return shownNotificationService.getShownNotificationsForUsername(showntousername);
    }
}
