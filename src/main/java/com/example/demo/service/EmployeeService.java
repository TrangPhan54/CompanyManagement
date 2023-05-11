package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.service.dto.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

     List<Employee> getAllEmployees();

     Employee getByEmployeeID (String empID);

    Employee createEmployee(Long deptID, EmployeeDTO employeeDTO);
    Employee updateEmployee(String employeeId, EmployeeDTO employeeDTO);

    void deleteEmployeeById(Long employeeId);

    List <EmployeeDTO> getEmployeeByLastNameAndFirstName (String lastName, String firstName);

    List <Employee> getEmployeeByFirstNameLike (String firstName);

    List <Employee> getEmployeeByFirstNameNotLike (String firstName);
    List<Employee> getEmployeeByLastNameNot (String lastName);
    List <Employee> getEmployeeBySalaryGreaterThan (Double salary);
    List<EmployeeDTO> getEmployeeByFirstName (String firstName);

    List <EmployeeDTO> getEmployeeBySalaryLessThan (Double salary);

}
