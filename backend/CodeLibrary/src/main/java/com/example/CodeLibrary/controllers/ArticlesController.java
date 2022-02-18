package com.example.CodeLibrary.controllers;

import com.example.CodeLibrary.entitites.Article;
import com.example.CodeLibrary.entitites.User;
import com.example.CodeLibrary.services.ArticleService;

import com.example.CodeLibrary.utility.StringFormatter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

// Använd @RestController istället för @Controller
// @RestController Spring Boot specifikt, tillåter oss använda @RequestBody för att
// automatiskt konvertera JSON till Java objekt. Med vanlig @Controller är det flera extra steg.
@RestController
@RequestMapping(value = "/rest", method = RequestMethod.POST)// Sätter denna strängen att komma automatiskt efter localhost:4000{minSträng}
public class ArticlesController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public List<Article> getAllArticles(){
        return articleService.findAllArticles();
    }

    @GetMapping("/articles/findArticleByTerm/{term}")
    public List<Article> getArticlesContaining(@PathVariable String term){
        return articleService.getArticlesContaining(term);
    }

    @GetMapping("/articles/{id}")
    public Article getOneArticle(@PathVariable int id){
        return articleService.findOneArticle(id);
    }

    // @RequestBody konverterar Req JSON objektet till det specifika java objektet vi anger som parameter
    @PostMapping("/articles/publish")
    public Article createNewArticle(@RequestBody String article){
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonParser().parse(article).getAsJsonObject();
        Article newArticle = new Article();
        newArticle.setmaintitle(StringFormatter.removeFirstAndLastChar(jsonObject.get("maintitle").toString()));
        newArticle.setAuthor(StringFormatter.removeFirstAndLastChar(jsonObject.get("author").toString()));
        newArticle.setFirsttag(StringFormatter.removeFirstAndLastChar(jsonObject.get("firsttag").toString()));
        newArticle.setSecondtag(StringFormatter.removeFirstAndLastChar(jsonObject.get("secondtag").toString()));
        newArticle.setThirdtag(StringFormatter.removeFirstAndLastChar(jsonObject.get("thirdtag").toString()));
        newArticle.setFirstprerequisite(StringFormatter.removeFirstAndLastChar(jsonObject.get("firstprerequisite").toString()));
        newArticle.setSecondprerequisite(StringFormatter.removeFirstAndLastChar(jsonObject.get("secondprerequisite").toString()));
        newArticle.setThirdprerequisite(StringFormatter.removeFirstAndLastChar(jsonObject.get("thirdprerequisite").toString()));
        newArticle.setDifficulty(StringFormatter.removeFirstAndLastChar(jsonObject.get("difficulty").toString()));
        newArticle.setLanguage(StringFormatter.removeFirstAndLastChar(jsonObject.get("language").toString()));
        newArticle.setFirstdescription(StringFormatter.removeFirstAndLastChar(jsonObject.get("firstdescription").toString()));
        newArticle.setSeconddescription(StringFormatter.removeFirstAndLastChar(jsonObject.get("seconddescription").toString()));
        newArticle.setThirddescription(StringFormatter.removeFirstAndLastChar(jsonObject.get("thirddescription").toString()));
        newArticle.setFirsttitle(StringFormatter.removeFirstAndLastChar(jsonObject.get("firsttitle").toString()));
        newArticle.setSecondtitle(StringFormatter.removeFirstAndLastChar(jsonObject.get("secondtitle").toString()));
        newArticle.setThirdtitle(StringFormatter.removeFirstAndLastChar(jsonObject.get("thirdtitle").toString()));
        newArticle.setFirstsection(StringFormatter.removeFirstAndLastChar(jsonObject.get("firstsection").toString()));
        newArticle.setSecondcontent(StringFormatter.removeFirstAndLastChar(jsonObject.get("secondcontent").toString()));
        newArticle.setThirdsection(StringFormatter.removeFirstAndLastChar(jsonObject.get("thirdsection").toString()));
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        newArticle.setTimestamp(Timestamp.from(ZonedDateTime.now().toInstant()));
        newArticle.setLikes(0);
        newArticle.setDislikes(0);
        newArticle.setComments(0);
        newArticle.setAuthorimage(StringFormatter.removeFirstAndLastChar(jsonObject.get("authorimage").toString()));

        return articleService.saveNewArticleToDB(newArticle);

    }

    @DeleteMapping("/articles/deleteArticle/{id}")
    public String deletearticleByID(@PathVariable int id){
        return articleService.deleteArticleByID(id);
    }


    @PutMapping("/articles/updateArticle/{id}/{maintitle}/{firsttag}/{secondtag}/{thirdtag}/{firstprereq}/{secondprereq}/{thirdprereq}/{difficulty}/{language}/{firstdescription}/{firsttitle}/{firstsection}/{seconddescription}/{secondtitle}/{secondcontent}/{thirddescription}/{thirdtitle}/{thirdsection}")
    public int updateArticle(@PathVariable int id, @PathVariable String maintitle, @PathVariable String firsttag, @PathVariable String secondtag, @PathVariable String thirdtag, @PathVariable String firstprereq, @PathVariable String secondprereq, @PathVariable String thirdprereq, @PathVariable String difficulty, @PathVariable String language, @PathVariable String firstdescription, @PathVariable String firsttitle, @PathVariable String firstsection, @PathVariable String seconddescription, @PathVariable String secondtitle, @PathVariable String secondcontent, @PathVariable String thirddescription, @PathVariable String thirdtitle, @PathVariable String thirdsection) { return articleService.updateArticle(id, maintitle, firsttag, secondtag, thirdtag, firstprereq, secondprereq, thirdprereq, difficulty, language, firstdescription, firsttitle, firstsection, seconddescription, secondtitle, secondcontent, thirddescription, thirdtitle, thirdsection); }


    @PutMapping("/articles/likeArticle/{id}")
    public int updateArticleLikes(@PathVariable int id){
        return articleService.likeArticle(id);
    }

    @PutMapping("/articles/dislikeArticle/{id}")
    public int updateArticleDislikes(@PathVariable int id){
        return articleService.dislikeArticle(id);
    }
}



