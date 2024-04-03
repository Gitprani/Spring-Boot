package com.pranesh.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pranesh.backend.model.Signup;
import com.pranesh.backend.service.SignupService;

@RestController
public class SignupController {

    @Autowired
    SignupService ss;

    @PostMapping("/api/signup")
    public ResponseEntity<Signup> postUser(@RequestBody Signup signup)
    {
        Signup obj = ss.create(signup);
        return new ResponseEntity<>(obj,HttpStatus.CREATED);
    }

    @GetMapping("/api/signup")
    public ResponseEntity<List<Signup>> getAllUserController()
    {
        List<Signup> obj = ss.getAllUser();
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }
    @GetMapping("/api/signup/{userId}")
    public ResponseEntity<Signup> getUserByIdController(@PathVariable int userId)
    {
        Signup obj = ss.getUserbyId(userId);
        if(obj!=null)
            return new ResponseEntity<>(obj,HttpStatus.OK);
        else
            return new ResponseEntity<>(obj,HttpStatus.NOT_FOUND);
    }


    @PutMapping("/api/signup/{userId}")
    public ResponseEntity<Signup> updateUserController(@PathVariable int userId,@RequestBody Signup se)
    {
        if(ss.updateUser(userId, se)==true)
            return new ResponseEntity<>(se, HttpStatus.OK);
        else
            return new ResponseEntity<>(se,HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/api/signup/{userId}")
    public ResponseEntity<Boolean> deleteUserController(@PathVariable int userId)
    {
        if(ss.deleteUser(userId)==true)
            return new ResponseEntity<>(true,HttpStatus.OK);
        else
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}