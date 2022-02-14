package com.example.CodeLibrary.repositories;

import com.example.CodeLibrary.entitites.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ArticleRepo extends CrudRepository<Article, Integer> {

    /*
    Custom queries
    Dynamiska värden i queryn skrivs med :kolon. Sedan hänvisar man till den i metodens parameter med @Param(“kolon”).

    @Query(value = "SELECT * FROM users WHERE name = :name", nativeQuery = true)
    List<User> customFindUsersByName(@Param("name") String name);
    */

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE articles SET likes = (likes + 1) WHERE id = :id", nativeQuery = true)
    int updateLikesOfArticle(@Param("id") Integer id);

    @Query(value ="SELECT likes FROM articles WHERE id = :id", nativeQuery = true)
    int findLikesForArticleWithId(@Param("id") Integer id);

    @Query(value = "SELECT * FROM articles WHERE id = :id", nativeQuery = true)
    Article findBySpecificId(@Param("id") Integer id);

    Article findByAuthor(String author);

    List<Article> findBymaintitleContainingIgnoreCase(String maintitle);

    List<Article> findByAuthorContainingIgnoreCase(String author);

    List<Article> findByfirsttagContainingIgnoreCase(String firsttag);

    List<Article> findBysecondtagContainingIgnoreCase(String secondtag);

    List<Article> findBythirdtagContainingIgnoreCase(String thirdtag);

}
