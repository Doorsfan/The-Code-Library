package com.example.CodeLibrary.services;

import com.example.CodeLibrary.entitites.Article;
import com.example.CodeLibrary.repositories.ArticleRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This service class handles the logic of writing and reading from the database.
 * The Repo is only used for direct queries to the Database.
 * Built-in methods through 'extends CrudRepository'
 * The Controller classes handles receiving requests from the frontend.
 */
@Service
public class ArticleService {

    // Spring uses a design pattern called: 'Dependency Injection'
    // It creates an empty class. Then it has a lot of setters and sets
    // the values in the correct order.
    // Thus we use the @ tags and 'AutoWire', we don't need to import ourselves
    // Spring handles it for us in the best way.
    @Autowired // Exempelvis för att importera spring klasser som @Service, @Repository etc
    private ArticleRepo articleRepo;

    /**
     * When I retrieve ALL OWNERS, According to my system design, I don't want
     * to retrieve all of their pets, that will be a lot of data being sent over the server
     * when the request doesn't necessarily say they want information about the pets.
     * @return
     */
    public List<Article> findAllArticles(){
        return (List<Article>) articleRepo.findAll();
    }

    /**
     * When I retrieve a single Owner, THEN I want according to my system design also
     * retrieve a list of all pets owned by this Owner. Since this will use the 'pets' table in the DB
     * We will go through the PetService to retrieve the Pets Info. Since this class is only
     * for 'OwnerService'. We add the list of pets to the owner object and returns the data.
     * @param id
     * @return
     */
    public Optional<Article> findOneArticle(int id){
        Optional<Article> article = articleRepo.findById(id);

        return article;
        /*
        if( movie.isEmpty() ) return movie;

        List<Pet> ownerPets = petService.findPetsByOwnerID(id);
        owner.get().setPets(ownerPets);
        return owner; */
    }

    public Article findArticleByAuthor(String author){
        return articleRepo.findByAuthor(author);
    }

    public List<Article> getArticlesContaining(String maintitle){
        ArrayList<Article> myList = new ArrayList<Article>();
        ArrayList<Integer> coveredIds = new ArrayList<Integer>();
        var searchBasedOnTitle = articleRepo.findBymaintitleContainingIgnoreCase(maintitle);
        for(int i = 0; i < searchBasedOnTitle.size(); i++){
            myList.add(searchBasedOnTitle.get(i));
            coveredIds.add(searchBasedOnTitle.get(i).getId());
        }

        var searchBasedOnAuthor = articleRepo.findByAuthorContainingIgnoreCase(maintitle);
        for(int a = 0; a < searchBasedOnAuthor.size(); a++){
            if(!coveredIds.contains(searchBasedOnAuthor.get(a).getId())){
                myList.add(searchBasedOnAuthor.get(a));
                coveredIds.add(searchBasedOnAuthor.get(a).getId());
            }
        }

        var searchBasedOnFirstTag = articleRepo.findByfirsttagContainingIgnoreCase(maintitle);
        for(int b = 0; b < searchBasedOnFirstTag.size(); b++) {
            if(!coveredIds.contains(searchBasedOnFirstTag.get(b).getId())){
                myList.add(searchBasedOnFirstTag.get(b));
                coveredIds.add(searchBasedOnFirstTag.get(b).getId());
            }
        }

        var searchBasedOnSecondTag = articleRepo.findBysecondtagContainingIgnoreCase(maintitle);
        for(int c = 0; c < searchBasedOnSecondTag.size(); c++) {
            if(!coveredIds.contains(searchBasedOnSecondTag.get(c).getId())){
                myList.add(searchBasedOnSecondTag.get(c));
                coveredIds.add(searchBasedOnSecondTag.get(c).getId());
            }
        }

        var searchBasedOnThirdTag = articleRepo.findBythirdtagContainingIgnoreCase(maintitle);
        for(int d = 0; d < searchBasedOnThirdTag.size(); d++) {
            if(!coveredIds.contains(searchBasedOnThirdTag.get(d).getId())){
                myList.add(searchBasedOnThirdTag.get(d));
                coveredIds.add(searchBasedOnThirdTag.get(d).getId());
            }
        }

        return myList;
    }

    public Article saveNewArticleToDB(Article article){
        return articleRepo.save(article);
    }

    public String deleteArticleByID(int id){
        try {
            articleRepo.deleteById(id);
            return "Success";
        } catch (Exception e){
            return "Failed";
        }
    }

    public String updateArticle(Article article){
        try {
            articleRepo.save(article);
            return "Success";
        } catch (Exception e){
            return "Failed";
        }
    }

}
