package com.doucodeur.departmentservice.service;

import java.util.List;

import com.doucodeur.departmentservice.model.Department;

public interface DepartmentService {
    
  List<Department> getDepartments();
  Department getDepartment(Long departmentId);
  Department saveDepartment(Department department);
  void deleteDepartment(Long departmentId);
}