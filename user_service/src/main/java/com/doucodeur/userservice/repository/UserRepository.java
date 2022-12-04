package com.doucodeur.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doucodeur.userservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}