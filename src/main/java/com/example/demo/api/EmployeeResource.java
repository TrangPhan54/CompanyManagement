package com.example.demo.api;

import com.example.demo.entity.Employee;
import com.example.demo.exception.DemoException;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/api/employees")
@RequiredArgsConstructor
public class EmployeeResource {

    @Autowired
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping(value = "/{employeeId}")
    ResponseEntity<Employee> getEmployeeByID(@PathVariable("employeeId") String employeeId) {
        return ResponseEntity.ok(employeeService.getByEmployeeID(employeeId));
    }

    @PostMapping(value = "/{deptID}")
    ResponseEntity<Employee> createEmployee(@PathVariable("deptID") Long deptID,
                                            @RequestBody EmployeeDTO employeeDTO) {
        Employee emp = employeeService.createEmployee(deptID, employeeDTO);
        return ResponseEntity.created(URI.create("/api/employees" + emp.getEmployeeID())).body(emp);
    }

    @PutMapping(value = "/{employeeID}")
    ResponseEntity<Employee> updateEmployee(@PathVariable("employeeID") String employeeID,
                                            @RequestBody EmployeeDTO employeeDTO){
        Employee employee = employeeService.updateEmployee(employeeID, employeeDTO);
        return ResponseEntity.created(URI.create("/api/employees/" + employee.getEmployeeID())).body(employee);
    }

    @DeleteMapping(value = "/{employeeId}")
    ResponseEntity<Employee> deleteEmployeeById(@PathVariable("employeeId") Long employeeID){
        employeeService.deleteEmployeeById(employeeID);
        return ResponseEntity.noContent().build();
    }

    @GetMapping (value = "/lastNameAndFirstName")
    ResponseEntity <List<EmployeeDTO>> getEmployeeByLastNameAndFirstName (@RequestParam("lastName") String lastName,@RequestParam("firstName") String firstName){
        return ResponseEntity.ok(employeeService.getEmployeeByLastNameAndFirstName(lastName, firstName));
    }

    @GetMapping(value = "/employee_like")
    ResponseEntity<List<Employee>> getEmployeeByFirstNameLike(@RequestParam("firstName") String firstName){
        return ResponseEntity.ok(employeeService.getEmployeeByFirstNameLike(firstName));
    }

    @GetMapping(value ="/employee_not_like")
    ResponseEntity<List<Employee>> getEmployeeByFirstNameNotLike (@RequestParam ("firstName") String firstName){
        return ResponseEntity.ok(employeeService.getEmployeeByFirstNameLike(firstName));
    }


    @GetMapping(value = "/last_name_not")
    ResponseEntity<List<Employee>> getEmployeeByLastNameNot (@RequestParam ("lastName") String lastName){
        return ResponseEntity.ok(employeeService.getEmployeeByLastNameNot(lastName));
    }
    @GetMapping(value = "/salary")
    ResponseEntity<List<Employee>> getEmployeeBySalaryGreaterThan (@RequestParam ("salary") Double salary){
        return ResponseEntity.ok(employeeService.getEmployeeBySalaryGreaterThan(salary));
    }
    @GetMapping(value = "/query/fn")
    ResponseEntity<List<EmployeeDTO>> getEmployeeByFirstName (@RequestParam ("firstName") @NotBlank String firstName){
        log.info("find employee by first name {}", firstName);
        if (firstName == null || firstName.isEmpty())
            throw DemoException.badRequest("FirstNameEmpty", "First name is null or empty");

        return ResponseEntity.ok().body(employeeService.getEmployeeByFirstName(firstName));
    }
    @GetMapping(value="/luong_it_hon")
    ResponseEntity<List<EmployeeDTO>> getEmployeeBySalaryLessThan (@RequestParam ("salary") Double salary){
        log.info("find employee by salary less than {} ",salary);
        if (salary < 0 || salary.isInfinite() || salary.isNaN())
            throw DemoException.badRequest("SalaryIsLessThanZeroOrInfinite","salary is less than zero or infinite");
        return ResponseEntity.ok().body(employeeService.getEmployeeBySalaryLessThan(salary));
    }



}