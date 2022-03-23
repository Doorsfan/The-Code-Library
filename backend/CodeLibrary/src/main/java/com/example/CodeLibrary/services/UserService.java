package com.example.CodeLibrary.services;

import com.example.CodeLibrary.entitites.User;
import com.example.CodeLibrary.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> findAllUsers() {
        return (List<User>) userRepo.findAll();
    }

    public Optional<User> findOneUser(int id) {
        Optional<User> user = userRepo.findById(id);

        return user;
    }

    public String addFollowerForUser(String username) {
        userRepo.updateFollowsOfUser(username);
        return userRepo.findFollowersForUserByUsername(username);
    }

    public User findUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public List<User> getUsersContaining(String username) {
        return userRepo.findByUsernameContainingIgnoreCase(username);
    }

    public User saveNewUserToDB(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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
