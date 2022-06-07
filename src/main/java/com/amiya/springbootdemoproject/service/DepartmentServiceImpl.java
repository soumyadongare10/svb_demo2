package com.amiya.springbootdemoproject.service;
import com.amiya.springbootdemoproject.entity.Department;
import com.amiya.springbootdemoproject.exception.DepartmentExistsException;
import com.amiya.springbootdemoproject.exception.DepartmentNotFoundException;
import com.amiya.springbootdemoproject.repository.DepartmentRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department)
    {
        if (departmentRepository.existsByDepartmentName(department.getDepartmentName())){
            throw new DepartmentExistsException("Department Exists by Name");
        }
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartment(String departmentName) throws DepartmentNotFoundException {

        if(departmentName!=null){
            Optional<List<Department>> byDepartmentName = departmentRepository.findByDepartmentName(departmentName);

            if(byDepartmentName.get().isEmpty()){
                throw new DepartmentNotFoundException("No Department Found");
            }
            return byDepartmentName.get();
        }
        else {
            List<Department> all = departmentRepository.findAll();
            return all;
        }
    }

    @Override
    public Department updateDepartment(Department department, Long departmentId)
    {
        Department depDB = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName())
                && !"".equalsIgnoreCase(
                department.getDepartmentName())) {
            depDB.setDepartmentName(
                    department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentAddress())
                && !"".equalsIgnoreCase(
                department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(
                    department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode())
                && !"".equalsIgnoreCase(
                department.getDepartmentCode())) {
            depDB.setDepartmentCode(
                    department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department deleteDepartment(String departmentName) throws DepartmentNotFoundException {
        Optional<List<Department>> byDepartmentName = departmentRepository.findByDepartmentName(departmentName);
        if (byDepartmentName.isEmpty()){
            throw new DepartmentNotFoundException("Department name not found");
        }else {
            departmentRepository.delete(byDepartmentName.get().get(0));
            return byDepartmentName.get().get(0);
        }
    }
}