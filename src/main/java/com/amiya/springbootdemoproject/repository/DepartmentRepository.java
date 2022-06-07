package com.amiya.springbootdemoproject.repository;
import com.amiya.springbootdemoproject.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
// used to indicate that the class provides
// the mechanism for storage, retrieval, update, delete and search operation on objects
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    boolean existsByDepartmentName(String departmentName);
    Optional<List<Department>> findByDepartmentName(String departmentName);

}
// JpaRepository :it contains API for basic CRUD operations and also API for pagination and sorting