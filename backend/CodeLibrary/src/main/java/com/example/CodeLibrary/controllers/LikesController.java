package com.example.CodeLibrary.controllers;

import com.example.CodeLibrary.entitites.Dislike;
import com.example.CodeLibrary.entitites.Like;
import com.example.CodeLibrary.services.LikesService;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// Använd @RestController istället för @Controller
// @RestController Spring Boot specifikt, tillåter oss använda @RequestBody för att
// automatiskt konvertera JSON till Java objekt. Med vanlig @Controller är det flera extra steg.
@RestController
@RequestMapping(value = "/rest", method = RequestMethod.POST)
public class LikesController {

    @Autowired
    private LikesService likesService;

    @DeleteMapping("/likes/takeBackLike/{userid}/{articleid}")
    public void deletelikeByID(@PathVariable int userid, @PathVariable int articleid) {
        likesService.deleteLikeByID(userid, articleid);
    }

    @DeleteMapping("/likes/deleteLikesByArticleId/{articleid}")
    public void deleteLikesByArticleId(@PathVariable int articleid) {
        likesService.deleteLikesByArticleId(articleid);
    }
    
    @PostMapping("/likes/likeArticle/{articleid}")
    public Like likeArticle(@PathVariable int articleid, @RequestBody String userid) {
        Like myLike = new Like();
        myLike.setArticleId(articleid);
        myLike.setUserid(JsonParser.parseString(userid).getAsJsonObject().get("userid").getAsInt());
        return likesService.saveNewLikeToDB(myLike);
    }

    @GetMapping("/likes/findLikedArticle/{userid}/{articleid}")
    public List<Like> findLikeForArticle(@PathVariable int userid, @PathVariable int articleid) {
        return likesService.getLikeByArticleIdAndUserId(userid, articleid);
    }

}
