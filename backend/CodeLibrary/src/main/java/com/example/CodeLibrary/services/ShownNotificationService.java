package com.example.CodeLibrary.services;

import com.example.CodeLibrary.repositories.ShownNotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShownNotificationService {

    @Autowired
    private ShownNotificationRepo shownNotificationRepo;
}
