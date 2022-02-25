package com.example.CodeLibrary.repositories;

import com.example.CodeLibrary.entitites.Follower;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FollowerRepo extends CrudRepository<Follower, Integer> {

    @Query(value = "SELECT * FROM followers WHERE targetusername = :targetusername", nativeQuery = true)
    List<Follower> findFollowersForUserByUsername(@Param("targetusername") String targetusername);

    @Query(value = "SELECT * FROM followers WHERE followersusername = :followersusername", nativeQuery = true)
    List<Follower> findFollowedUsersBasedOnUsername(@Param("followersusername") String followersusername);
}
