package com.amiya.springbootdemoproject.controller;
import com.amiya.springbootdemoproject.entity.Department;
import com.amiya.springbootdemoproject.exception.DepartmentNotFoundException;
import com.amiya.springbootdemoproject.service.DepartmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/dept")
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department saveDepartment(@RequestBody Department department)
    {
        return departmentService.saveDepartment(department);
    }

    @GetMapping
    public ResponseEntity<?> fetchDepartments(@RequestParam(value = "departmentName", required = false) String departmentName) throws DepartmentNotFoundException {
        return new ResponseEntity<>(departmentService.fetchDepartment(departmentName),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@RequestBody Department department, @PathVariable("id") Long departmentId)
    {
        return departmentService.updateDepartment(department, departmentId);
    }


    @DeleteMapping("/{departmentName}")
    public ResponseEntity<?> deleteDepartment(@PathVariable String departmentName) throws DepartmentNotFoundException{
        return new ResponseEntity<>(departmentService.deleteDepartment(departmentName),HttpStatus.OK);
    }
    
      @PatchMapping("/{id}")
    public ResponseEntity < ? > updateResource(@RequestBody Department department, @PathVariable("id") Long departmentId) {
        Department newDepartment = departmentService.updateDepartment(department, departmentId);
        return new ResponseEntity < > (newDepartment, HttpStatus.OK);
    }
    



}
