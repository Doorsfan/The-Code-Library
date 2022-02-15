package com.example.CodeLibrary.repositories;

import com.example.CodeLibrary.entitites.Article;
import com.example.CodeLibrary.entitites.Dislike;
import com.example.CodeLibrary.entitites.Like;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DislikesRepo extends CrudRepository<Dislike, Integer> {

    @Query(value = "SELECT * FROM dislikes WHERE userid = :userid AND articleId = :articleId", nativeQuery = true)
    List<Dislike> findDislikesByUserIdAndArticleId(@Param("userid") Integer userid, @Param("articleId") Integer articleId);

    @Query(value = "SELECT * FROM dislikes WHERE articleId = :articleId", nativeQuery = true)
    List<Dislike> findDislikesByArticleId(@Param("articleId") Integer articleId);

    @Query(value = "SELECT * FROM dislikes WHERE userid = :userid", nativeQuery = true)
    List<Dislike> findDislikesByUserId(@Param("userid") Integer userid);

    @Query(value = "DELETE * FROM dislikes WHERE userid = :userid AND articleId = :articleId", nativeQuery = true)
    void deleteDislikeByArticleIdAndUserId(@Param("userid") Integer userid, @Param("articleId") Integer articleId);
}
