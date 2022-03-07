package com.example.CodeLibrary.services;

import com.example.CodeLibrary.entitites.Comment;
import com.example.CodeLibrary.repositories.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    public Comment saveNewCommentToDB(Comment comment) {
        return commentRepo.save(comment);
    }

    public List<Comment> getCommentsForArticleId(int articleid) {
        return commentRepo.findAllCommentsByArticleId(articleid);
    }

    public void deleteComment(Integer id) { commentRepo.deleteById(id); }
}
