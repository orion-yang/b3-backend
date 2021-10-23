package com.b3backend.b3backend.service;

import com.b3backend.b3backend.exception.UserNotFoundException;
import com.b3backend.b3backend.model.User;
import com.b3backend.b3backend.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    public User findById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User by id" + id + "was not found"));
    }

    public User findByUserName(String userName) {
        return userRepo.findByUserName(userName).orElseThrow(() -> new UserNotFoundException("User by username" + userName + "was not found"));
    }

    public void deleteUserByFirstName(String firstName) {
        userRepo.deleteUserByFirstName(firstName);
        System.out.println("Here in Service!");
    }

}