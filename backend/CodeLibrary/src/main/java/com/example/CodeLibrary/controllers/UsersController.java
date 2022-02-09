package com.example.CodeLibrary.controllers;

import com.example.CodeLibrary.DTOs.UserWithoutPW;
import com.example.CodeLibrary.entitites.User;
import com.example.CodeLibrary.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Använd @RestController istället för @Controller
// @RestController Spring Boot specifikt, tillåter oss använda @RequestBody för att
// automatiskt konvertera JSON till Java objekt. Med vanlig @Controller är det flera extra steg.
@RestController
@RequestMapping("/rest") // Sätter denna strängen att komma automatiskt efter localhost:4000{minSträng}
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getOneUser(@PathVariable int id){
        return userService.findOneUser(id);
    }

    @GetMapping("/users/username/{username}/{password}")
    public UserWithoutPW getUsersContaining(@PathVariable String username, @PathVariable String password){
        UserWithoutPW userDTO = new UserWithoutPW("", "");
        List<User> relevantUsers = userService.getUsersContaining(username);
        System.out.println(password);
        for(int i = 0; i < relevantUsers.size(); i++){
            if(relevantUsers.get(i).getUsername().equals(username) && relevantUsers.get(i).getPassword().equals(password)){
                userDTO.setUsername(relevantUsers.get(i).getUsername());
                userDTO.setProfileURL(relevantUsers.get(i).getProfileURL());
            }
        }
        return userDTO;
    }

    // @RequestBody konverterar Req JSON objektet till det specifika java objektet vi anger som parameter
    @PostMapping("/users")
    public User createNewUser(@RequestBody User user){
        return userService.saveNewUserToDB(user);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserByID(@PathVariable int id){
        return userService.deleteUserByID(id);
    }

    @PutMapping("/users")
    public String updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }


}



