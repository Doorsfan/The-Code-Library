package com.example.CodeLibrary.repositories;

import com.example.CodeLibrary.entitites.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Integer> {

    /*
    Custom queries
    Dynamiska värden i queryn skrivs med :kolon. Sedan hänvisar man till den i metodens parameter med @Param(“kolon”).

    @Query(value = "SELECT * FROM users WHERE name = :name", nativeQuery = true)
    List<User> customFindUsersByName(@Param("name") String name);
    */

    @Query(value = "SELECT * FROM comments WHERE articleid = :articleid", nativeQuery = true)
    List<Comment> findAllCommentsByArticleId(@Param("articleid") Integer articleid);


}
