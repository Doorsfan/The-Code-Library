package com.example.CodeLibrary.repositories;

import com.example.CodeLibrary.entitites.ShownNotification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShownNotificationRepo extends CrudRepository<ShownNotification, Integer> {

    @Query(value = "SELECT * FROM shownnotification WHERE showntousername = :showntousername", nativeQuery = true)
    public List<ShownNotification> findByShownToUsername(@Param("showntousername") String showntousername);
}