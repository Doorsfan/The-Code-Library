package com.example.CodeLibrary.controllers;

import com.example.CodeLibrary.entitites.Article;
import com.example.CodeLibrary.services.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Använd @RestController istället för @Controller
// @RestController Spring Boot specifikt, tillåter oss använda @RequestBody för att
// automatiskt konvertera JSON till Java objekt. Med vanlig @Controller är det flera extra steg.
@RestController
@RequestMapping(value = "/rest") // Sätter denna strängen att komma automatiskt efter localhost:4000{minSträng}
public class ArticlesController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public List<Article> getAllArticles(){
        return articleService.findAllArticles();
    }

    @GetMapping("/articles/{id}")
    public Optional<Article> getOneArticle(@PathVariable int id){
        return articleService.findOneArticle(id);
    }



    // @RequestBody konverterar Req JSON objektet till det specifika java objektet vi anger som parameter
    @PostMapping("/articles/publish")
    public Article createNewArticle(@RequestBody String image){
        Article newarticle = new Article();
        /*
            TO DO
        */
        return newarticle;
    }

    @DeleteMapping("/articles/{id}")
    public String deletearticleByID(@PathVariable int id){
        return articleService.deleteArticleByID(id);
    }

    @PutMapping("/articles")
    public String updateArticle(@RequestBody Article article){
        return articleService.updateArticle(article);
    }


}



