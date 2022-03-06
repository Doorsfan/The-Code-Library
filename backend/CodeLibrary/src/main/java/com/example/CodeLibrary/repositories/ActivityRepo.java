package com.example.CodeLibrary.repositories;

import com.example.CodeLibrary.entitites.Activity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepo extends CrudRepository<Activity, Integer> {

    @Query(value = "SELECT * FROM activity WHERE username = :username", nativeQuery = true)
    List<Activity> findByUsername(@Param("username") String username);

}
