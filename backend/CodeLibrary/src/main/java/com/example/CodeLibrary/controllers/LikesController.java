package com.example.CodeLibrary.controllers;

import com.example.CodeLibrary.entitites.Like;
import com.example.CodeLibrary.services.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


// Använd @RestController istället för @Controller
// @RestController Spring Boot specifikt, tillåter oss använda @RequestBody för att
// automatiskt konvertera JSON till Java objekt. Med vanlig @Controller är det flera extra steg.
@RestController
@RequestMapping(value = "/rest", method = RequestMethod.POST)
public class LikesController {

    @Autowired
    private LikesService likesService;

    @DeleteMapping("/likes/{userid}/{articleid}")
    public String deletelikeByID(@PathVariable int userid, @PathVariable int articleid) {
        return likesService.deleteLikeByID(userid, articleid);
    }

    @DeleteMapping("/likes/deleteLikesByArticleId/{articleid}")
    public void deleteLikesByArticleId(@PathVariable int articleid) {
        likesService.deleteLikesByArticleId(articleid);
    }

    @GetMapping("/likes/{userid}/{articleid}")
    public Like likeArticle(@PathVariable int userid, @PathVariable int articleid) {
        System.out.println("Got in here");
        Like myLike = new Like();
        myLike.setArticleId(articleid);
        myLike.setUserid(userid);
        return likesService.saveNewLikeToDB(myLike);
    }

}
