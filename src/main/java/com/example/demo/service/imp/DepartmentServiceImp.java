package com.example.demo.service.imp;

import com.example.demo.entity.Department;
import com.example.demo.exception.DemoException;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.dto.DepartmentDTO;
import com.example.demo.service.mapper.DepartmentMapper;
import com.example.demo.service.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImp implements DepartmentService {
    private final DepartmentRepository departmentRepository;
//    private DepartmentMapper departmentMapper =DepartmentMapper.INSTANCE;


    @Override
    public List<Department> getAllDepartment (){
        return departmentRepository.findAll();
    }
//    @Override
//    public Optional <Department> getDepartmentByID (Long deptID){
//        return  departmentRepository.findById(deptID);
//    }
    @Override
    public Department updateDepartment (Long deptID, DepartmentDTO departmentDTO){
        Department department = departmentRepository.findById(deptID).orElseThrow();
        department.setName(departmentDTO.getName());
        department.setStartDate(departmentDTO.getStartDate());
        return departmentRepository.save(department);
    }
    @Override
    public void deleteDepartmentById (Long departmentId){
        departmentRepository.deleteById(departmentId);
    }
    @Override
    public Department createDepartment (DepartmentDTO departmentDTO){
        Department department = new Department();
        department.setName(departmentDTO.getName());
        department.setStartDate(departmentDTO.getStartDate());
        return departmentRepository.save(department);
    }
    @Override
    public List<Department> getDepartmentByDate(LocalDate localDate){
        return departmentRepository.findByStartDate(localDate);
    }
    @Override
    public List <Department> getDepartmentByName(String name){
        return departmentRepository.findByName(name);
    }
    @Override
    public List <Department> getDepartmentByNameContaining (String partOfName){
        return departmentRepository.findByNameContaining(partOfName);
    }

    @Override
    public List<Department> getDepartmentByNameNotLike (String name){
        return departmentRepository.findByNameNotLike(name);
    }
    @Override
    public List <Department> getDepartmentByNameIgnoreCase (String anotherName){
        return departmentRepository.findByNameIgnoreCase(anotherName);
    }



    @Override
    public List <DepartmentDTO> getAll(){
        return DepartmentMapper.INSTANCE.toDtos(departmentRepository.findAll());
    }
    @Override
    public List<DepartmentDTO> getDepartmentByStartDate(LocalDate startDate) {
//
        return DepartmentMapper.INSTANCE.toDtos(departmentRepository.getDepartmentByStartDate(startDate));
    }

    @Override
    public List<DepartmentDTO> getDepartmentByDepartmentName(String name) {
        return DepartmentMapper.INSTANCE.toDtos(departmentRepository.getDepartmentByDepartmentName(name));
    }

    @Override
    public DepartmentDTO findById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(DemoException :: DepartmentNotFound);
        return DepartmentMapper.INSTANCE.toDto(department);
    }


}
