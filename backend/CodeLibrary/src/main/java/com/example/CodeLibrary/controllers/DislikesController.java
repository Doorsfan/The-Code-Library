package com.example.CodeLibrary.controllers;

import com.example.CodeLibrary.entitites.Dislike;
import com.example.CodeLibrary.services.DislikeService;
import com.google.gson.JsonParser;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


// Använd @RestController istället för @Controller
// @RestController Spring Boot specifikt, tillåter oss använda @RequestBody för att
// automatiskt konvertera JSON till Java objekt. Med vanlig @Controller är det flera extra steg.
@RestController
@RequestMapping(value = "/rest", method = RequestMethod.POST)
public class DislikesController {

    @Autowired
    private DislikeService dislikeService;

    @DeleteMapping("/dislikes/takeBackDislike/{userid}/{articleId}")
    public String deletedislikeByID(@PathVariable int userid, @PathVariable int articleId) {
        return dislikeService.deleteLikeByID(userid, articleId);
    }

    @DeleteMapping("/dislikes/deleteDislikesByArticleId/{articleid}")
    public void deleteDislikesByArticleId(@PathVariable int articleid) {
        dislikeService.deleteDislikesByArticleId(articleid);
    }

    @PostMapping("/dislikes/dislikeArticle/{articleid}")
    public Dislike dislikeArticle(@PathVariable int articleid, @RequestBody String userid) {
        Dislike myDislike = new Dislike();
        myDislike.setArticleId(articleid);
        myDislike.setUserid(JsonParser.parseString(userid).getAsJsonObject().get("userid").getAsInt());
        return dislikeService.saveNewDislikeToDB(myDislike);
    }

    @GetMapping("/dislikes/findDislikedArticle/{userid}/{articleid}")
    public Optional<List<Dislike>> findDislikeForArticle(@PathVariable int userid, @PathVariable int articleid) {
        return dislikeService.getDislikeByArticleIdAndUserId(userid, articleid);
    }

}
