package com.example.CodeLibrary.repositories;

import com.example.CodeLibrary.entitites.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepo extends CrudRepository<Article, Integer> {

    /*
    Custom queries
    Dynamiska värden i queryn skrivs med :kolon. Sedan hänvisar man till den i metodens parameter med @Param(“kolon”).

    @Query(value = "SELECT * FROM users WHERE name = :name", nativeQuery = true)
    List<User> customFindUsersByName(@Param("name") String name);
    */

    Article findByAuthor(String author);

    List<Article> findBymaintitleContainingIgnoreCase(String maintitle);

}
