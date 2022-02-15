package com.example.CodeLibrary.services;

import com.example.CodeLibrary.entitites.Dislike;
import com.example.CodeLibrary.repositories.DislikesRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This service class handles the logic of writing and reading from the database.
 * The Repo is only used for direct queries to the Database.
 * Built-in methods through 'extends CrudRepository'
 * The Controller classes handles receiving requests from the frontend.
 */
@Service
public class DislikeService {

    // Spring uses a design pattern called: 'Dependency Injection'
    // It creates an empty class. Then it has a lot of setters and sets
    // the values in the correct order.
    // Thus we use the @ tags and 'AutoWire', we don't need to import ourselves
    // Spring handles it for us in the best way.
    @Autowired // Exempelvis för att importera spring klasser som @Service, @Repository etc
    private DislikesRepo dislikeRepo;



    /**
     * When I retrieve a single Owner, THEN I want according to my system design also
     * retrieve a list of all pets owned by this Owner. Since this will use the 'pets' table in the DB
     * We will go through the PetService to retrieve the Pets Info. Since this class is only
     * for 'OwnerService'. We add the list of pets to the owner object and returns the data.
     * @param id
     * @return
     */
    public List<Dislike> findDislikesByUserId(int id){
        List<Dislike> dislike = dislikeRepo.findDislikesByUserId(id);

        return dislike;
        /*
        if( movie.isEmpty() ) return movie;

        List<Pet> ownerPets = petService.findPetsByOwnerID(id);
        owner.get().setPets(ownerPets);
        return owner; */
    }

    public List<Dislike> getDislikesForArticle(Integer id){
        return dislikeRepo.findDislikesByArticleId(id);
    }

    public Dislike saveNewDislikeToDB(Dislike dislike){
        return dislikeRepo.save(dislike);
    }

    public String deleteLikeByID(int articleid, int userid){
        try {
            dislikeRepo.deleteDislikeByArticleIdAndUserId(articleid, userid);
            return "Success";
        } catch (Exception e){
            return "Failed";
        }
    }

}
