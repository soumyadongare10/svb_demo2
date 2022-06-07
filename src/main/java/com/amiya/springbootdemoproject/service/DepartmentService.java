package com.amiya.springbootdemoproject.service;
import com.amiya.springbootdemoproject.entity.Department;
import com.amiya.springbootdemoproject.exception.DepartmentExistsException;
import com.amiya.springbootdemoproject.exception.DepartmentNotFoundException;

import java.util.List;


public interface DepartmentService {

    Department saveDepartment(Department department) throws DepartmentExistsException;

    List<Department> fetchDepartment(String departmentName) throws DepartmentNotFoundException;

    Department updateDepartment(Department department, Long departmentId);

    Department deleteDepartment(String departmentName) throws DepartmentNotFoundException;
}