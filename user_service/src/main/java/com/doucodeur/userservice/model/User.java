package com.doucodeur.userservice.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private Long departmentId;
    
}