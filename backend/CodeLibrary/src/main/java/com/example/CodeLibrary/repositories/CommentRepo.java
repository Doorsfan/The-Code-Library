package com.example.CodeLibrary.repositories;

import com.example.CodeLibrary.entitites.Comment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Integer> {

    @Query(value = "SELECT * FROM comments WHERE articleid = :articleid", nativeQuery = true)
    List<Comment> findAllCommentsByArticleId(@Param("articleid") Integer articleid);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE comments SET content = :content WHERE id = :id", nativeQuery = true)
    void updateComment(@Param("id") Integer id, @Param("content") String content);


}
