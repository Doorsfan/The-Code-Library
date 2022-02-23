package com.example.CodeLibrary.repositories;

import com.example.CodeLibrary.entitites.Like;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface LikesRepo extends CrudRepository<Like, Integer> {

    @Query(value = "SELECT * FROM likes WHERE userid = :userid AND articleId = :articleId", nativeQuery = true)
    List<Like> findLikesByUserIdAndArticleId(@Param("userid") Integer userid, @Param("articleId") Integer articleId);

    @Query(value = "SELECT * FROM likes WHERE articleId = :articleId", nativeQuery = true)
    List<Like> findLikesByArticleId(@Param("articleId") Integer articleId);

    @Query(value = "SELECT * FROM likes WHERE userid = :userid", nativeQuery = true)
    List<Like> findLikesByUserId(@Param("userid") Integer userid);

    @Query(value = "DELETE * FROM likes WHERE userid = :userid AND articleId = :articleId", nativeQuery = true)
    void deleteLikeByArticleIdAndUserId(@Param("userid") Integer userid, @Param("articleId") Integer articleId);

    @Modifying(clearAutomatically = true)
    @Transactional
    void deleteByarticleid(Integer articleId);
}
