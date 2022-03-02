package com.example.CodeLibrary.services;

import com.example.CodeLibrary.entitites.Like;
import com.example.CodeLibrary.repositories.LikesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This service class handles the logic of writing and reading from the database.
 * The Repo is only used for direct queries to the Database.
 * Built-in methods through 'extends CrudRepository'
 * The Controller classes handles receiving requests from the frontend.
 */
@Service
public class LikesService {

    // Spring uses a design pattern called: 'Dependency Injection'
    // It creates an empty class. Then it has a lot of setters and sets
    // the values in the correct order.
    // Thus we use the @ tags and 'AutoWire', we don't need to import ourselves
    // Spring handles it for us in the best way.
    @Autowired // Exempelvis för att importera spring klasser som @Service, @Repository etc
    private LikesRepo likeRepo;


    /**
     * When I retrieve a single Owner, THEN I want according to my system design also
     * retrieve a list of all pets owned by this Owner. Since this will use the 'pets' table in the DB
     * We will go through the PetService to retrieve the Pets Info. Since this class is only
     * for 'OwnerService'. We add the list of pets to the owner object and returns the data.
     *
     * @param id
     * @return
     */
    public List<Like> findLikesByUserId(int id) {
        List<Like> like = likeRepo.findLikesByUserId(id);

        return like;
        /*
        if( movie.isEmpty() ) return movie;

        List<Pet> ownerPets = petService.findPetsByOwnerID(id);
        owner.get().setPets(ownerPets);
        return owner; */
    }

    public List<Like> getLikesForArticle(Integer id) {
        return likeRepo.findLikesByArticleId(id);
    }

    public Like saveNewLikeToDB(Like like) {
        return likeRepo.save(like);
    }

    public void deleteLikesByArticleId(int articleid) {
        try {
            likeRepo.deleteByarticleid(articleid);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String deleteLikeByID(int articleid, int userid) {
        try {
            likeRepo.deleteLikeByArticleIdAndUserId(articleid, userid);
            return "Success";
        } catch (Exception e) {
            return "Failed";
        }
    }

    public List<Like> getLikeByArticleIdAndUserId(int articleid, int userid) {
        return likeRepo.findLikesByUserIdAndArticleId(articleid, userid);
    }

}
