package com.example.demo.repository;

import com.example.demo.entity.Employee;
import com.example.demo.service.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long> {

    List<EmployeeDTO> findByLastNameAndFirstName(String lastName, String firstName);

    Optional<Employee> findByEmployeeID (String employeeId);

    List<Employee> findByFirstNameLike (String firstName);

    List<Employee> findByFirstNameNotLike (String firstName);

    List <Employee> findByLastNameNot (String lastName);

    List <Employee> findBySalaryGreaterThan(Double salary);

    @Query(value = "SELECT * FROM employee e where e.first_name = :firstName", nativeQuery = true)
    List <Employee> getEmployeeByFirstName (@Param("firstName") String firstName);

    @Query(value =" SELECT * FROM employee e where e.salary <:salary", nativeQuery = true)
    List <Employee> getEmployeeBySalaryLessThan (@Param("salary") Double salary);

}
