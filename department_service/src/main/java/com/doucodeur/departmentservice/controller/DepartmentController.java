package com.doucodeur.departmentservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.doucodeur.departmentservice.model.Department;
import com.doucodeur.departmentservice.service.DepartmentServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentServiceImpl service;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Department> getDepartments(){
        return service.getDepartments();
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Department saveDepartment(@RequestBody final Department department){
        return service.saveDepartment(department);
    }

    @GetMapping("/{departmentId}")
    @ResponseStatus(HttpStatus.OK)
    public Department getDepartment(@PathVariable final Long departmentId){
        return service.getDepartment(departmentId);
    }

    @DeleteMapping("/{departmentId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDepartment(@PathVariable final Long departmentId){
        service.deleteDepartment(departmentId);
    }
}