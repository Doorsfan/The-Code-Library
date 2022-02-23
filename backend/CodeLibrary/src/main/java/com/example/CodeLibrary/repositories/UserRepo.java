package com.example.CodeLibrary.repositories;

import com.example.CodeLibrary.entitites.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

    /*
    Custom queries
    Dynamiska värden i queryn skrivs med :kolon. Sedan hänvisar man till den i metodens parameter med @Param(“kolon”).

    @Query(value = "SELECT * FROM users WHERE name = :name", nativeQuery = true)
    List<User> customFindUsersByName(@Param("name") String name);
    */

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE users SET followers = (followers + 1) WHERE username = :username", nativeQuery = true)
    int updateFollowsOfUser(@Param("username") String username);

    @Query(value = "SELECT followers FROM users WHERE username = :username", nativeQuery = true)
    String findFollowersForUserByUsername(@Param("username") String username);

    User findByUsername(String username);

    List<User> findByUsernameContainingIgnoreCase(String title);

}
