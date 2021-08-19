package com.revature.overcharge.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.overcharge.beans.User;
import com.revature.overcharge.services.UserService;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	UserService us;
	
    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable("id") String id) {
        return us.getUser(Integer.parseInt(id));
    }
    
	
    @GetMapping(value = "/user/username")
    public User getUserByUname(@RequestParam("username") String username) {
        return us.getUserByUname(username);
    }
    
    @GetMapping(value = "/user")
    public List<User> getAllUsers() {
    	return us.getAllUsers();
    }

    @PostMapping(value = "/user", consumes = "application/json",
            produces = "application/json")
    public User addUser(@RequestBody User u) {
        return us.addUser(u);
    }

    @PutMapping(value = "/user/{id}", consumes = "application/json",
            produces = "application/json")
    public User updateUser(@PathVariable int id, @RequestBody User newUser) {
        newUser.setId(id);
        return us.updateUser(newUser);
    }
    
    @DeleteMapping(value = "/user/{id}")
    public boolean deleteUser(@PathVariable int id) {
    	return us.deleteUser(id);
    }

	
}