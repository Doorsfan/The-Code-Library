package com.example.CodeLibrary.repositories;

import com.example.CodeLibrary.entitites.Dislike;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface DislikesRepo extends CrudRepository<Dislike, Integer> {

    @Query(value = "SELECT * FROM dislikes WHERE userid = :userid AND articleId = :articleId", nativeQuery = true)
    Optional<List<Dislike>> findDislikesByUserIdAndArticleId(@Param("userid") Integer userid, @Param("articleId") Integer articleId);

    @Query(value = "SELECT * FROM dislikes WHERE articleId = :articleId", nativeQuery = true)
    List<Dislike> findDislikesByArticleId(@Param("articleId") Integer articleId);

    @Query(value = "SELECT * FROM dislikes WHERE userid = :userid", nativeQuery = true)
    List<Dislike> findDislikesByUserId(@Param("userid") Integer userid);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "DELETE FROM dislikes WHERE userid = :userid AND articleId = :articleId", nativeQuery = true)
    void deleteDislikeByArticleIdAndUserId(@Param("userid") Integer userid, @Param("articleId") Integer articleId);

    @Modifying(clearAutomatically = true)
    @Transactional
    void deleteByarticleid(Integer articleId);
}
