package com.pranesh.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranesh.backend.model.Signup;

public interface SignupRepo extends JpaRepository<Signup,Integer>{
    
}