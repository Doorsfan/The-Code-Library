package com.example.CodeLibrary.controllers;

import com.example.CodeLibrary.entitites.Dislike;
import com.example.CodeLibrary.services.DislikeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


// Använd @RestController istället för @Controller
// @RestController Spring Boot specifikt, tillåter oss använda @RequestBody för att
// automatiskt konvertera JSON till Java objekt. Med vanlig @Controller är det flera extra steg.
@RestController
@RequestMapping(value = "/rest", method = RequestMethod.POST)
public class DislikesController {

    @Autowired
    private DislikeService dislikeService;

    @DeleteMapping("/dislikes/{userid}/{articleId}")
    public String deletedislikeByID(@PathVariable int userid, @PathVariable int articleId){
        return dislikeService.deleteLikeByID(userid, articleId);
    }

    @GetMapping("/dislikes/{userid}/{articleid}")
    public Dislike dislikeArticle(@PathVariable int userid, @PathVariable int articleid){
        System.out.println("Got in here");
        Dislike myDislike = new Dislike();
        myDislike.setArticleId(articleid);
        myDislike.setUserid(userid);

        return dislikeService.saveNewDislikeToDB(myDislike);
    }

}
