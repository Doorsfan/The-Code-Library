package com.example.CodeLibrary.controllers;

import com.example.CodeLibrary.entitites.Comment;
import com.example.CodeLibrary.services.CommentService;
import com.example.CodeLibrary.utility.StringFormatter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;

// Använd @RestController istället för @Controller
// @RestController Spring Boot specifikt, tillåter oss använda @RequestBody för att
// automatiskt konvertera JSON till Java objekt. Med vanlig @Controller är det flera extra steg.
@RestController
@RequestMapping(value = "/rest", method = RequestMethod.POST)
public class CommentsController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comments/postNewComment")
    public Comment createNewUser(@RequestBody String comment) {
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonParser().parse(comment).getAsJsonObject();
        Comment newComment = new Comment();
        newComment.setArticleid(Integer.parseInt(StringFormatter.removeFirstAndLastChar(jsonObject.get("articleid").toString())));
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        newComment.setTimestamp(Timestamp.from(ZonedDateTime.now().toInstant()));
        newComment.setTimestamp(timestamp);
        newComment.setContent(StringFormatter.removeFirstAndLastChar(jsonObject.get("content").toString()));
        newComment.setAuthorname(StringFormatter.removeFirstAndLastChar(jsonObject.get("authorname").toString()));
        newComment.setAuthorurl(StringFormatter.removeFirstAndLastChar(jsonObject.get("authorurl").toString()));

        return commentService.saveNewCommentToDB(newComment);
    }

    @GetMapping("/comments/getCommentsForArticle/{articleid}")
    public List<Comment> getCommentsByArticleId(@PathVariable Integer articleid) {
        return commentService.getCommentsForArticleId(articleid);
    }

    @DeleteMapping("/comments/deleteComment/{id}")
    public void deleteComment(@PathVariable Integer id) {
        commentService.deleteComment(id);
    }

}
