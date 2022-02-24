package com.example.CodeLibrary.repositories;

import com.example.CodeLibrary.entitites.Notification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificationRepo extends CrudRepository<Notification, Integer> {

    @Query(value = "SELECT * FROM notification WHERE authorname = :authorname", nativeQuery = true)
    public List<Notification> findNotificationsByAuthor(@Param("authorname") String authorname);
}
