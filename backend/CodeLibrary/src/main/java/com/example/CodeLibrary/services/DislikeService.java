package com.example.CodeLibrary.services;

import com.example.CodeLibrary.entitites.Dislike;
import com.example.CodeLibrary.repositories.DislikesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DislikeService {

    @Autowired
    private DislikesRepo dislikeRepo;

    public List<Dislike> findDislikesByUserId(int id) {
        List<Dislike> dislike = dislikeRepo.findDislikesByUserId(id);

        return dislike;
    }

    public void deleteDislikesByArticleId(int articleid) {
        try {
            dislikeRepo.deleteByarticleid(articleid);

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public List<Dislike> getDislikesForArticle(Integer id) {
        return dislikeRepo.findDislikesByArticleId(id);
    }

    public Dislike saveNewDislikeToDB(Dislike dislike) {
        return dislikeRepo.save(dislike);
    }

    public String deleteLikeByID(int articleid, int userid) {
        try {
            dislikeRepo.deleteDislikeByArticleIdAndUserId(articleid, userid);
            return "Success";
        } catch (Exception e) {
            return "Failed";
        }
    }

    public Optional<List<Dislike>> getDislikeByArticleIdAndUserId(int articleid, int userid) {
        return dislikeRepo.findDislikesByUserIdAndArticleId(articleid, userid);
    }

}
