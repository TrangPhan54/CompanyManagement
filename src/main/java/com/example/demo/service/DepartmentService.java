package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.service.dto.DepartmentDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<Department> getAllDepartment ();
//    Optional<Department> getDepartmentByID (Long deptID);
    DepartmentDTO findById (Long departmentId);

    Department updateDepartment (Long deptID, DepartmentDTO departmentDTO);
    void deleteDepartmentById (Long departmentId);
    Department createDepartment (DepartmentDTO departmentDTO);
    List<Department> getDepartmentByDate(LocalDate localDate);
    List <Department> getDepartmentByName(String name);
    List <Department> getDepartmentByNameContaining (String partOfName);
    List<Department> getDepartmentByNameNotLike (String name);
    List <Department> getDepartmentByNameIgnoreCase (String anotherName);
    List <DepartmentDTO> getAll();

    List <DepartmentDTO> getDepartmentByStartDate (LocalDate startDate);
    List <DepartmentDTO> getDepartmentByDepartmentName (String name);

}
