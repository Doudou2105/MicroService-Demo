package com.doucodeur.departmentservice.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.doucodeur.departmentservice.model.Department;
import com.doucodeur.departmentservice.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
    
        private final DepartmentRepository departmentRepository;

    @Override
    public List<Department> getDepartments() {
      
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartment(Long departmentId) {
        log.info("Department id is : {}", departmentId);
        return departmentRepository.findById(departmentId).orElseThrow();
    }

    @Override
    public Department saveDepartment(Department department) {
        log.info("Department {} save with successful", department);
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
       departmentRepository.deleteById(departmentId);
        
    }


    
    
}