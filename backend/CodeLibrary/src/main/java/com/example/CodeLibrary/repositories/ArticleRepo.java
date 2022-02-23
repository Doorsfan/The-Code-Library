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

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE articles SET dislikes = (dislikes + 1) WHERE id = :id", nativeQuery = true)
    int updateDislikesOfArticle(@Param("id") Integer id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE articles SET maintitle = :maintitle, firsttag = :firsttag, secondtag = :secondtag, thirdtag = :thirdtag, firstprerequisite = :firstprereq, secondprerequisite = :secondprereq, thirdprerequisite = :thirdprereq, difficulty = :difficulty, language = :language, firstdescription = :firstdescription, firsttitle = :firsttitle, firstsection = :firstsection, seconddescription = :seconddescription, secondtitle = :secondtitle, secondsection = :secondsection, thirddescription = :thirddescription, thirdtitle = :thirdtitle, thirdsection = :thirdsection WHERE id = :id", nativeQuery = true)
    int updateArticle(@Param("id") Integer id, @Param("maintitle") String maintitle, @Param("firsttag") String firsttag, @Param("secondtag") String secondtag, @Param("thirdtag") String thirdtag, @Param("firstprereq") String firstprereq, @Param("secondprereq") String secondprereq, @Param("thirdprereq") String thirdprereq, @Param("difficulty") String difficulty, @Param("language") String language, @Param("firstdescription") String firstdescription, @Param("firsttitle") String firsttitle, @Param("firstsection") String firstsection, @Param("seconddescription") String seconddescription, @Param("secondtitle") String secondtitle, @Param("secondsection") String secondsection, @Param("thirddescription") String thirddescription, @Param("thirdtitle") String thirdtitle, @Param("thirdsection") String thirdsection);

    @Query(value = "SELECT likes FROM articles WHERE id = :id", nativeQuery = true)
    int findLikesForArticleWithId(@Param("id") Integer id);

    @Query(value = "SELECT dislikes FROM articles WHERE id = :id", nativeQuery = true)
    int findDislikesForArticleWithId(@Param("id") Integer id);

    @Query(value = "SELECT * FROM articles WHERE id = :id", nativeQuery = true)
    Article findBySpecificId(@Param("id") Integer id);

    @Query(value = "SELECT * FROM articles WHERE author = :author", nativeQuery = true)
    List<Article> findArticlesByAuthor(@Param("author") String author);

    Article findByAuthor(String author);

    List<Article> findBymaintitleContainingIgnoreCase(String maintitle);

    List<Article> findByAuthorContainingIgnoreCase(String author);

    List<Article> findByfirsttagContainingIgnoreCase(String firsttag);

    List<Article> findBysecondtagContainingIgnoreCase(String secondtag);

    List<Article> findBythirdtagContainingIgnoreCase(String thirdtag);

}
