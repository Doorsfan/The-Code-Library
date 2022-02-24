package com.example.CodeLibrary.controllers;

import com.example.CodeLibrary.services.ShownNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// Använd @RestController istället för @Controller
// @RestController Spring Boot specifikt, tillåter oss använda @RequestBody för att
// automatiskt konvertera JSON till Java objekt. Med vanlig @Controller är det flera extra steg.
@RestController
@RequestMapping(value = "/rest", method = RequestMethod.POST)
public class ShownNotificationController {

    @Autowired
    private ShownNotificationService shownNotificationService;
}
