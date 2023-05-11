package com.example.demo.service.imp;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.exception.DemoException;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.dto.EmployeeDTO;
import com.example.demo.service.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private EmployeeMapper employeeMapper=EmployeeMapper.INSTANCE;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    @Override
    public Employee getByEmployeeID(String empID) {
        return employeeRepository.findByEmployeeID(empID).orElseThrow(() -> DemoException.notFound("Emp_NOt_FOUND", "Khong thay emp " + empID));
    }
    @Override
    public Employee createEmployee(Long deptID, EmployeeDTO employeeDTO) {
        Optional<Department> department = departmentRepository.findById(deptID);

        Employee employee = new Employee();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setGender(employeeDTO.getGender());
        employee.setMiddleName(employeeDTO.getMiddleName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        if (department.isPresent())
            employee.setDepartment(department.get());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(String employeeId, EmployeeDTO employeeDTO) {
        Employee employee = getByEmployeeID(employeeId);
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setMiddleName(employeeDTO.getMiddleName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setGender(employeeDTO.getGender());
        employee.setSalary(employeeDTO.getSalary());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        return employeeRepository.save(employee);
    }
    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }


    @Override
    public List <EmployeeDTO> getEmployeeByLastNameAndFirstName (String lastName, String firstName){
        return employeeRepository.findByLastNameAndFirstName(lastName,firstName);
    }
    @Override
    public List <Employee> getEmployeeByFirstNameLike (String firstName){
        return employeeRepository.findByFirstNameLike("%"+firstName+"%");
    }
    @Override
    public List <Employee> getEmployeeByFirstNameNotLike (String firstName){
        return employeeRepository.findByFirstNameNotLike(firstName);
    }
    @Override
    public List<Employee> getEmployeeByLastNameNot (String lastName){
        return employeeRepository.findByLastNameNot(lastName);
    }
    @Override
    public List <Employee> getEmployeeBySalaryGreaterThan (Double salary){
        return employeeRepository.findBySalaryGreaterThan(salary);
    }
    @Override
    public List<EmployeeDTO> getEmployeeByFirstName (String firstName){
        return employeeMapper.toDtos(employeeRepository.getEmployeeByFirstName(firstName));

    }

    @Override
    public List<EmployeeDTO> getEmployeeBySalaryLessThan(Double salary) {
        return employeeMapper.toDtos(employeeRepository.getEmployeeBySalaryLessThan(salary));
    }


}
