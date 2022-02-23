package com.example.CodeLibrary.services;

import com.example.CodeLibrary.entitites.User;
import com.example.CodeLibrary.repositories.UserRepo;
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
public class UserService {

    // Spring uses a design pattern called: 'Dependency Injection'
    // It creates an empty class. Then it has a lot of setters and sets
    // the values in the correct order.
    // Thus we use the @ tags and 'AutoWire', we don't need to import ourselves
    // Spring handles it for us in the best way.
    @Autowired // Exempelvis för att importera spring klasser som @Service, @Repository etc
    private UserRepo userRepo;

    /**
     * When I retrieve ALL OWNERS, According to my system design, I don't want
     * to retrieve all of their pets, that will be a lot of data being sent over the server
     * when the request doesn't necessarily say they want information about the pets.
     *
     * @return
     */
    public List<User> findAllUsers() {
        return (List<User>) userRepo.findAll();
    }

    /**
     * When I retrieve a single Owner, THEN I want according to my system design also
     * retrieve a list of all pets owned by this Owner. Since this will use the 'pets' table in the DB
     * We will go through the PetService to retrieve the Pets Info. Since this class is only
     * for 'OwnerService'. We add the list of pets to the owner object and returns the data.
     *
     * @param id
     * @return
     */
    public Optional<User> findOneUser(int id) {
        Optional<User> user = userRepo.findById(id);

        return user;
        /*
        if( movie.isEmpty() ) return movie;

        List<Pet> ownerPets = petService.findPetsByOwnerID(id);
        owner.get().setPets(ownerPets);
        return owner; */
    }

    public User findUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public List<User> getUsersContaining(String username) {
        return userRepo.findByUsernameContainingIgnoreCase(username);
    }

    public User saveNewUserToDB(User user) {
        return userRepo.save(user);
    }

    public String deleteUserByID(int id) {
        try {
            userRepo.deleteById(id);
            return "Success";
        } catch (Exception e) {
            return "Failed";
        }
    }

    public String updateUser(User user) {
        try {
            userRepo.save(user);
            return "Success";
        } catch (Exception e) {
            return "Failed";
        }
    }

}
